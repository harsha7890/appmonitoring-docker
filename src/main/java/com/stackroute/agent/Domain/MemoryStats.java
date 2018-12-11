package com.stackroute.agent.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DecimalFormat;

public class MemoryStats {
    @Override
    public String toString() {
        return ""+ usage;
    }

    @JsonProperty("usage")
    private float usage;
    // Getter Methods

    public float getUsage() {

//        DecimalFormat decimalFormat = new DecimalFormat("#.##");
//        float twoDigitsFR = Float.valueOf(decimalFormat.format(usage));
//        double new_variable = Math.round(usage*100) / 100.0;
//        return new_variable;
        return usage;
    }
    // Setter Methods

    public void setUsage( float usage ) {
        this.usage = usage;
    }

}
