package com.acme.statusmgr.Decorators;

import com.acme.ISystemStatus;
import com.acme.statusmgr.beans.AbstractServerStatus;
/**
 * Decorator to add details about total jvm memory
 */
public class TotalJvmMemoryDecorator extends StatusDecorator{
    final int COST = 13;

    public TotalJvmMemoryDecorator(AbstractServerStatus status) {
        super(status);
    }

    @Override
    public String getStatusDesc() {
        return super.getStatusDesc() + systemStatusImplementation.getTotalJvmMemory();
    }

    @Override
    public Integer getRequestCost() {
        return super.getRequestCost() + COST;
    }
}
