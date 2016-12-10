package ninja.dock.gbfs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StationStatus {

    @JsonProperty("station_id")
    private String stationId;
    @JsonProperty("num_bikes_available")
    private Integer numBikesAvailable;
    @JsonProperty("num_bikes_disabled")
    private Integer numBikesDisabled;
    @JsonProperty("num_docks_available")
    private Integer numDocksAvailable;
    @JsonProperty("num_docks_disabled")
    private Integer numDocksDisabled;
    @JsonProperty("is_installed")
    private boolean installed;
    @JsonProperty("is_renting")
    private boolean renting;
    @JsonProperty("is_returning")
    private boolean returning;
    @JsonProperty("last_reported")
    private Long lastReported;

    public StationStatus() {
    }

    public StationStatus(final String stationId, final Integer numBikesAvailable, final Integer numBikesDisabled,
                         final Integer numDocksAvailable, final Integer numDocksDisabled, final boolean installed,
                         final boolean renting, final boolean returning, final Long lastReported) {
        this();
        this.stationId = stationId;
        this.numBikesAvailable = numBikesAvailable;
        this.numBikesDisabled = numBikesDisabled;
        this.numDocksAvailable = numDocksAvailable;
        this.numDocksDisabled = numDocksDisabled;
        this.installed = installed;
        this.renting = renting;
        this.returning = returning;
        this.lastReported = lastReported;
    }

    public String getStationId() {
        return stationId;
    }

    public Integer getNumBikesAvailable() {
        return numBikesAvailable;
    }

    public Integer getNumBikesDisabled() {
        return numBikesDisabled;
    }

    public Integer getNumDocksAvailable() {
        return numDocksAvailable;
    }

    public Integer getNumDocksDisabled() {
        return numDocksDisabled;
    }

    public boolean isInstalled() {
        return installed;
    }

    public boolean isRenting() {
        return renting;
    }

    public boolean isReturning() {
        return returning;
    }

    public Long getLastReported() {
        return lastReported;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final StationStatus that = (StationStatus) o;

        return new EqualsBuilder()
                .append(installed, that.installed)
                .append(renting, that.renting)
                .append(returning, that.returning)
                .append(stationId, that.stationId)
                .append(numBikesAvailable, that.numBikesAvailable)
                .append(numBikesDisabled, that.numBikesDisabled)
                .append(numDocksAvailable, that.numDocksAvailable)
                .append(numDocksDisabled, that.numDocksDisabled)
                .append(lastReported, that.lastReported)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(stationId)
                .append(numBikesAvailable)
                .append(numBikesDisabled)
                .append(numDocksAvailable)
                .append(numDocksDisabled)
                .append(installed)
                .append(renting)
                .append(returning)
                .append(lastReported)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("stationId", stationId)
                .append("numBikesAvailable", numBikesAvailable)
                .append("numBikesDisabled", numBikesDisabled)
                .append("numDocksAvailable", numDocksAvailable)
                .append("numDocksDisabled", numDocksDisabled)
                .append("installed", installed)
                .append("renting", renting)
                .append("returning", returning)
                .append("lastReported", lastReported)
                .toString();
    }
}
