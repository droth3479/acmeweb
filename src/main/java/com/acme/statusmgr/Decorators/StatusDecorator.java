package com.acme.statusmgr.Decorators;

import com.acme.statusmgr.beans.AbstractServerStatus;

abstract class StatusDecorator extends AbstractServerStatus {
    private final AbstractServerStatus statusToBeDecorated;

    public StatusDecorator(AbstractServerStatus statusToBeDecorated) {
        this.statusToBeDecorated = statusToBeDecorated;
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
