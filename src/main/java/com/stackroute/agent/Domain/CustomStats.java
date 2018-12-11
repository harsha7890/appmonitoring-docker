package com.stackroute.agent.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomStats {
    public CustomStats() {
    }
    @JsonProperty("memory")
    private MemoryStats memoryStats;
    @JsonProperty("cpu")
    private CPUmetrics cpUmetrics;

    @Override
    public String toString() {
        return "{" +
                "memory=" + memoryStats +","+
                "cpu="+cpUmetrics+
                '}';
    }

    public MemoryStats getMemoryStats() {
        return memoryStats;
    }

    public void setMemoryStats(MemoryStats memoryStats) {
        this.memoryStats = memoryStats;
    }

    public CPUmetrics getCpUmetrics() {
        return cpUmetrics;
    }

    public void setCpUmetrics(CPUmetrics cpUmetrics) {
        this.cpUmetrics = cpUmetrics;
    }
}
