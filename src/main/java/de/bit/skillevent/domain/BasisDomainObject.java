package de.bit.skillevent.domain;

public class BasisDomainObject {

    @org.springframework.data.neo4j.annotation.GraphId
    protected Long id;

    public <T extends BasisDomainObject> T withId(Long id){
        this.id = id;
        return (T) this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
