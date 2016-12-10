package ninja.dock.gbfs.api;

import ninja.dock.gbfs.model.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static ninja.dock.gbfs.api.TestUtils.resource;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GbfsTest {

    private static final String GBFS_URL = "https://mysite.com/gbfs.json";

    private FeedProvider feedProvider;
    private Gbfs gbfs;

    @Before
    public void setUp() {
        feedProvider = mock(HttpFeedProvider.class);
        gbfs = new Gbfs(GBFS_URL, feedProvider);
    }

    @Test
    public void testGbfsFeed() throws IOException {
        when(feedProvider.get(GBFS_URL, GbfsFeed.class))
                .thenReturn(resource("gbfs_feed.json", GbfsFeed.class));

        final GbfsFeed gbfsFeed = gbfs.getGbfsFeed();

        assertEquals(Long.valueOf(10L), gbfsFeed.getTtl());
    }
}
