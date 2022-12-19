package com.acme.statusmgr.Decorators;

import com.acme.ISystemStatus;
import com.acme.statusmgr.beans.AbstractServerStatus;

public class JreVersionDecorator extends StatusDecorator{
    final int COST = 19;

    public JreVersionDecorator(AbstractServerStatus status){
        super(status);
    }

    @Override
    public String getStatusDesc() {
        return super.getStatusDesc() + systemStatusImplementation.getJreVersion();
    }

    @Override
    public Integer getRequestCost() {
        return super.getRequestCost() + COST;
    }
}