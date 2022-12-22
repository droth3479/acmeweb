package com.acme.statusmgr.Decorators;

import com.acme.statusmgr.beans.AbstractServerStatus;

/**
 * Abstract class to serve as the super class for all decorators
 * <p>
 * Extends AbstractServerStatus, and serves as a wrapper for an AbstractServerStatus object
 */
abstract class StatusDecorator extends AbstractServerStatus {
    private final AbstractServerStatus statusToBeDecorated;

    public StatusDecorator(AbstractServerStatus statusToBeDecorated) {
        this.statusToBeDecorated = statusToBeDecorated;
    }

    @Override
    public String getContentHeader() {
        return statusToBeDecorated.getContentHeader();
    }

    @Override
    public String getStatusDesc() {
        return statusToBeDecorated.getStatusDesc();
    }

    @Override
    public Integer getRequestCost() {
        return statusToBeDecorated.getRequestCost();
    }
}
