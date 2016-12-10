package ninja.dock.gbfs.api;

import ninja.dock.gbfs.model.BaseFeed;
import org.junit.Before;
import org.junit.Test;

import java.time.Clock;

import static ninja.dock.gbfs.api.TestUtils.resource;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CachingFeedProviderTest {

    private FeedProvider internalFeedProvider;
    private Clock clock;
    private BaseFeed feed1 = resource("feed1.json", BaseFeed.class);
    private BaseFeed feed2 = resource("feed2.json", BaseFeed.class);

    private CachingFeedProvider cachingFeedProvider;

    @Before
    public void setUp() {
        internalFeedProvider = mock(FeedProvider.class);
        clock = mock(Clock.class);
        cachingFeedProvider = new CachingFeedProvider(internalFeedProvider, clock);
    }

    @Test
    public void testNonExpired() {
        when(internalFeedProvider.get("url", BaseFeed.class)).thenReturn(feed1).thenReturn(feed2);
        when(clock.millis()).thenReturn(150_000L);

        final BaseFeed actual = cachingFeedProvider.get("url", BaseFeed.class);

        assertEquals(feed1, actual);
    }

    @Test
    public void testExpired() {
        when(internalFeedProvider.get("url", BaseFeed.class)).thenReturn(feed1).thenReturn(feed2);
        when(clock.millis()).thenReturn(150_000L);

        cachingFeedProvider.get("url", BaseFeed.class);
        when(clock.millis()).thenReturn(250_000L);
        final BaseFeed actual = cachingFeedProvider.get("url", BaseFeed.class);

        assertEquals(feed2, actual);
    }

}
