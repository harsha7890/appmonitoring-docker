package com.stackroute.agent.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dockerusage {
    @Override
    public String toString() {
        return ""+total
                ;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Dockerusage() {
    }

    @JsonProperty("total")
    private String total;
}
