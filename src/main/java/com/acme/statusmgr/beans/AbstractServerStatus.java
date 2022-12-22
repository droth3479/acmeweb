package com.acme.statusmgr.beans;

import com.acme.ISystemStatus;

/**
 * Abstract class to represent server status
 */

public abstract class AbstractServerStatus {
    protected static ISystemStatus systemStatusImplementation;

    public static void setSystemStatus(ISystemStatus implementation) {
        systemStatusImplementation = implementation;
    }
    /**
     * Obtain content header
     * @return string
     */
    public abstract String getContentHeader();
    /**
     * Obtain status description
     * @return string
     */
    public abstract String getStatusDesc();
    /**
     * Obtain request cost
     * @return Integer
     */
    public abstract Integer getRequestCost();
}
