package de.bit.skillevent.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;

public class BasisDomainObject {

    @GraphId
    protected Long   id;

    @Indexed(unique = true, failOnDuplicate = true, level = Indexed.Level.INSTANCE)
    protected String oId;

    public <T extends BasisDomainObject> T withId(String oId) {
        this.oId = oId;
        return (T) this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOId() {
        return oId;
    }

    public void setOId(String oId) {
        this.oId = oId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BasisDomainObject)) {
            return false;
        }

        BasisDomainObject that = (BasisDomainObject) o;

        return !(oId != null ? !oId.equals(that.oId) : that.oId != null);

    }

    @Override
    public int hashCode() {
        return oId != null ? oId.hashCode() : 0;
    }
}
