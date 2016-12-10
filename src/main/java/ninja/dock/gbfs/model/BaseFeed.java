package ninja.dock.gbfs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseFeed {

    @JsonProperty("last_updated")
    private Long lastUpdated;
    @JsonProperty("ttl")
    private Long ttl;

    public Long getLastUpdated() {
        return lastUpdated;
    }

    public Long getTtl() {
        return ttl;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final BaseFeed common = (BaseFeed) o;

        return new EqualsBuilder()
                .append(lastUpdated, common.lastUpdated)
                .append(ttl, common.ttl)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(lastUpdated)
                .append(ttl)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("lastUpdated", lastUpdated)
                .append("ttl", ttl)
                .toString();
    }
}
