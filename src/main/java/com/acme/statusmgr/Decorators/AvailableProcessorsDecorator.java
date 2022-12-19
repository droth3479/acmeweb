package com.acme.statusmgr.Decorators;

import com.acme.ISystemStatus;
import com.acme.statusmgr.beans.AbstractServerStatus;

public class AvailableProcessorsDecorator extends StatusDecorator{
    final int COST = 3;

    public AvailableProcessorsDecorator(AbstractServerStatus status){
        super(status);
    }

    @Override
    public String getStatusDesc() {
        return super.getStatusDesc() + systemStatusImplementation.getAvailableProcessors();
    }

    @Override
    public Integer getRequestCost() {
        return super.getRequestCost() + COST;
    }
}
