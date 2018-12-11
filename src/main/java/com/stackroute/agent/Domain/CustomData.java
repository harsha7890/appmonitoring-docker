package com.stackroute.agent.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CustomData {
    @JsonProperty("stats")
    private List<CustomStats> customStats;

    public CustomData() {
    }

//    public CustomData(CustomSpec customSpec, List<CustomStats> customStats) {
//        this.customSpec = customSpec;
//        this.customStats = customStats;
//    }
//
//
//    public CustomSpec getCustomSpec() {
//        return customSpec;
//    }
//
//    public void setCustomSpec(CustomSpec customSpec) {
//        this.customSpec = customSpec;
//    }

    public List<CustomStats> getCustomStats() {
        return customStats;
    }

    public void setCustomStats(List<CustomStats> customStats) {
        this.customStats = customStats;
    }

    @Override
    public String toString() {
//        return "CustomData{" +
//                "customSpec=" + customSpec +
//                ", customStats=" + customStats +
//                '}';
        return "{stats="+customStats+"}";
    }
}
