package de.bit.skillevent.domain;

public class BasisDomainObject {

    protected String id;

    public <T extends BasisDomainObject> T withId(String id){
        this.id = id;
        return (T) this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
