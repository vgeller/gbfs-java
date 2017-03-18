package ninja.dock.gbfs.api;

import ninja.dock.gbfs.model.*;

import java.time.Clock;
import java.util.List;
import java.util.Optional;

public class Gbfs {

    private final FeedProvider feedProvider;
    private final String feedUrl;
    private final String name;

    /**
     * Construct a new GBFS API instance.  TTL caching is set to true.
     *
     * @param feedUrl the main URL of the feed (gbfs.json)
     */
    public Gbfs(final String feedUrl, final String name) {
        this(feedUrl, new CachingFeedProvider(new HttpFeedProvider(), Clock.systemUTC()), name);
    }

    /**
     * Construct a new GBFS API instance.  TTL caching is set to true.
     *
     * @param gbfsSystem a GBFS system constant
     */
    public Gbfs(final GbfsSystem gbfsSystem) {
        this(gbfsSystem.getFeedUrl(), gbfsSystem.getName());
    }

    /**
     * Construct a new GBFS API instance
     *
     * @param feedUrl the main URL of the feed (gbfs.json)
     * @param feedProvider the feed provider
     */
    Gbfs(final String feedUrl, final FeedProvider feedProvider, final String name) {
        this.feedUrl = feedUrl;
        this.feedProvider = feedProvider;
        this.name = name;
    }

    public GbfsFeed getGbfsFeed() {
        return feedProvider.get(feedUrl, GbfsFeed.class);
    }

    public StationStatusFeed getStationStatusFeed() {
        return feedProvider.get(getUrl("station_status"), StationStatusFeed.class);
    }

    public List<StationStatus> getStationStatusList() {
        final StationStatusFeed feed = getStationStatusFeed();
        return feed.getData().getStations();
    }

    public Optional<StationStatus> getStationStatus(final String stationId) {
        return getStationStatusList().stream()
                .filter(stationStatus -> stationId.equals(stationStatus.getStationId()))
                .findAny();
    }

    public StationInformationFeed getStationInformationFeed() {
        return feedProvider.get(getUrl("station_information"), StationInformationFeed.class);
    }

    public List<StationInformation> getStationInformationList() {
        final StationInformationFeed feed = getStationInformationFeed();
        return feed.getData().getStations();
    }

    public Optional<StationInformation> getStationInformation(final String stationId) {
        return getStationInformationList().stream()
                .filter(stationInformation -> stationId.equals(stationInformation.getStationId()))
                .findAny();
    }

    private String getUrl(final String feedName) {
        final List<Feed> feeds = getGbfsFeed().getData().getEn().getFeeds();
        final Optional<Feed> foundFeed = feeds.stream()
                .filter(feed -> feedName.equals(feed.getName()))
                .findAny();
        if (foundFeed.isPresent()) {
            return foundFeed.get().getUrl();
        } else {
            throw new RuntimeException("Feed not found: " + feedName);
        }
    }

    public void reset() {
        this.feedProvider.reset();
    }

    public String getName() {
        return name;
    }
}
