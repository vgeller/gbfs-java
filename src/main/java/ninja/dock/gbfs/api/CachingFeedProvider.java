package ninja.dock.gbfs.api;

import ninja.dock.gbfs.model.BaseFeed;

import java.time.Clock;
import java.util.HashMap;
import java.util.Map;

/**
 * Wrapper to add caching for feeds
 */
public class CachingFeedProvider implements FeedProvider {

    private final FeedProvider internalFeedProvider;
    private final Clock clock;
    private Map<String, BaseFeed> cache;

    public CachingFeedProvider(final FeedProvider internalFeedProvider, final Clock clock) {
        this.internalFeedProvider = internalFeedProvider;
        this.clock = clock;
        this.cache = new HashMap<>();
    }

    @Override
    public <T extends BaseFeed> T get(final String url, final Class<T> feedClass) {
        T cached = (T) cache.get(url);
        if (isStale(cached)) {
            cached = internalFeedProvider.get(url, feedClass);
            cache.put(url, cached);
        }
        return cached;
    }

    @Override
    public void reset() {
        cache = new HashMap<>();
    }

    private boolean isStale(final BaseFeed baseFeed) {
        if (baseFeed == null || baseFeed.getLastUpdated() == null || baseFeed.getTtl() == null) {
            return true;
        }
        final long now = clock.millis() / 1000;
        final long diff = now - (baseFeed.getLastUpdated() + baseFeed.getTtl());
        return diff > 0;
    }
}
