package com.acme.statusmgr.Decorators;

import com.acme.ISystemStatus;
import com.acme.statusmgr.beans.AbstractServerStatus;

public class FreeJvmMemoryDecorator extends StatusDecorator{
    final int COST = 7;

    public FreeJvmMemoryDecorator(AbstractServerStatus status){
        super(status);
    }

    @Override
    public String getStatusDesc() {
        return super.getStatusDesc() + systemStatusImplementation.getFreeJvmMemory();
    }

    @Override
    public Integer getRequestCost() {
        return super.getRequestCost() + COST;
    }
}