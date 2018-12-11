package com.stackroute.agent.Domain;

public class SystemMetrics {
    private String systemmemory;
    private String systemcpu;

    @Override
    public String toString() {
        return "SystemMetrics{" +
                "systemmemory='" + systemmemory + '\'' +
                ", systemcpu='" + systemcpu + '\'' +
                '}';
    }

    public String getSystemmemory() {
        return systemmemory;
    }

    public void setSystemmemory(String systemmemory) {
        this.systemmemory = systemmemory;
    }

    public String getSystemcpu() {
        return systemcpu;
    }

    public void setSystemcpu(String systemcpu) {
        this.systemcpu = systemcpu;
    }

    public SystemMetrics(String systemmemory, String systemcpu) {
        this.systemmemory = systemmemory;
        this.systemcpu = systemcpu;
    }

    public SystemMetrics() {
    }
}
