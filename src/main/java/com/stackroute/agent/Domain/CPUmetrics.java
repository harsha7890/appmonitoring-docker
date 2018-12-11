package com.stackroute.agent.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CPUmetrics {
    @JsonProperty("usage")
    private Dockerusage dockerusage;

    @Override
    public String toString() {
        return "" + dockerusage;
    }

    public Dockerusage getDockerusage() {
        return dockerusage;
    }

    public void setDockerusage(Dockerusage dockerusage) {
        this.dockerusage = dockerusage;
    }

    public CPUmetrics() {
    }
}
