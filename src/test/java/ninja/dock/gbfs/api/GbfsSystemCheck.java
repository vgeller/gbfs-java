package ninja.dock.gbfs.api;

import ninja.dock.gbfs.model.GbfsSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility to check whether various GBFS systems are responding
 */
public class GbfsSystemCheck {

    private static final Logger LOGGER = LoggerFactory.getLogger(GbfsSystemCheck.class);

    public static void main(String[] args) {
        for (final GbfsSystem system : GbfsSystem.values()) {
            final Gbfs gbfs = new Gbfs(system);
            final int stations = gbfs.getStationStatusList().size();
            LOGGER.info("System: {} Stations: {} Time: {}", system, stations, system.currentTime());
        }
    }
}
