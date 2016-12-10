package ninja.dock.gbfs.api;

import ninja.dock.gbfs.model.BaseFeed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class HttpFeedProvider implements FeedProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpFeedProvider.class);

    private Client client;

    public HttpFeedProvider() {
        this.client = ClientBuilder.newClient();
    }

    @Override
    public <T extends BaseFeed> T get(final String url, final Class<T> feedClass) {
        final long start = System.currentTimeMillis();
        final Response response = client.target(url).request().get();
        final long elapsedMs = System.currentTimeMillis() - start;
        LOGGER.debug("GET {} = {}, took {} ms", url, response.getStatusInfo(), elapsedMs);
        return response.readEntity(feedClass);
    }

    @Override
    public void reset() {
        this.client = ClientBuilder.newClient();
    }
}
