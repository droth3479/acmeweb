package com.acme.statusmgr.beans;

import com.acme.ISystemStatus;

public abstract class AbstractServerStatus {
    protected static ISystemStatus systemStatusImplementation;

    public static void setSystemStatus(ISystemStatus implementation) {
        systemStatusImplementation = implementation;
    }
    public abstract String getStatusDesc();
    public abstract Integer getRequestCost();
}
