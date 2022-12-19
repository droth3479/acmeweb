package com.acme.statusmgr.Decorators;

import com.acme.ISystemStatus;
import com.acme.statusmgr.beans.AbstractServerStatus;
/**
 * Decorator to add details about temp location
 */
public class TempLocationDecorator extends StatusDecorator{
    final int COST = 29;

    public TempLocationDecorator(AbstractServerStatus status){
        super(status);
    }

    @Override
    public String getStatusDesc() {
        return super.getStatusDesc() + systemStatusImplementation.getTempLocation();
    }

    @Override
    public Integer getRequestCost() {
        return super.getRequestCost() + COST;
    }
}
