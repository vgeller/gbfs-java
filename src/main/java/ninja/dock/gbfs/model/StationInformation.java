package ninja.dock.gbfs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StationInformation {

    @JsonProperty("station_id")
    private String stationId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("short_name")
    private String shortName;
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lon")
    private String lon;
    @JsonProperty("region_id")
    private String regionId;
    @JsonProperty("capacity")
    private Integer capacity;

    public String getStationId() {
        return stationId;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getRegionId() {
        return regionId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final StationInformation that = (StationInformation) o;

        return new EqualsBuilder()
                .append(stationId, that.stationId)
                .append(name, that.name)
                .append(shortName, that.shortName)
                .append(lat, that.lat)
                .append(lon, that.lon)
                .append(regionId, that.regionId)
                .append(capacity, that.capacity)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(stationId)
                .append(name)
                .append(shortName)
                .append(lat)
                .append(lon)
                .append(regionId)
                .append(capacity)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("stationId", stationId)
                .append("name", name)
                .append("shortName", shortName)
                .append("lat", lat)
                .append("lon", lon)
                .append("regionId", regionId)
                .append("capacity", capacity)
                .toString();
    }
}
