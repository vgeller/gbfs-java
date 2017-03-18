package ninja.dock.gbfs.model;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public enum GbfsSystem {

    NYC("https://gbfs.citibikenyc.com/gbfs/gbfs.json", "America/New_York"),
    BCYCLE_AUSTIN("https://gbfs.bcycle.com/bcycle_austin/gbfs.json", "America/Chicago"),
    DIVVY("https://gbfs.divvybikes.com/gbfs/gbfs.json", "America/Chicago"),
    PRONTO("https://gbfs.prontocycleshare.com/gbfs/gbfs.json", "America/Los_Angeles"),
    VELGO("http://velogo.ca/opendata/gbfs.json", "America/Toronto");

    private final String feedUrl;
    private final String timeZone;

    GbfsSystem(final String feedUrl, final String timeZone) {
        this.feedUrl = feedUrl;
        this.timeZone = timeZone;
    }

    public String getFeedUrl() {
        return feedUrl;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getName() {
        return this.name().toLowerCase();
    }

    public ZonedDateTime currentTime() {
        return ZonedDateTime.now(ZoneId.of(timeZone));
    }
}
