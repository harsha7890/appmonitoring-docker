package com.stackroute.agent.Domain;

import java.util.List;

//import lombok.Data;
//
//@Data
public class Metrics {
    Integer userID;
    Integer applicationID;
    Object metrics;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(Integer applicationID) {
        this.applicationID = applicationID;
    }

    public Object getMetrics() {
        return metrics;
    }

    public void setMetrics(Object metrics) {
        this.metrics = metrics;
    }

    public Metrics(Integer userID, Integer applicationID, Object metrics) {
        this.userID = userID;
        this.applicationID = applicationID;
        this.metrics = metrics;
    }

    public Metrics() {
    }
}
