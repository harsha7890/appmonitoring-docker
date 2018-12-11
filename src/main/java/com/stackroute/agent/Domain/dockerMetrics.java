package com.stackroute.agent.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class dockerMetrics {
    @Override
    public String toString() {
//        return "dockerMetrics{" +
//                "customData=" + customData +
//                '}';
        return  customData+"";

    };

    public CustomData getCustomData() {
        return customData;
    }


    public void setCustomData(CustomData customData) {
        this.customData = customData;
    }

    public dockerMetrics(CustomData customData) {
        this.customData = customData;
    }

    public dockerMetrics() {
    }

    @JsonProperty("/docker")
    private CustomData customData;

}
