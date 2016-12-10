package ninja.dock.gbfs.api;

import ninja.dock.gbfs.model.BaseFeed;

public interface FeedProvider {

    <T extends BaseFeed> T get(final String url, final Class<T> feedClass);

    void reset();
}
