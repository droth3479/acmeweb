package com.acme;

public interface ISystemStatus {
    String getCurrentServerStatus();

    String getAvailableProcessors();

    String getFreeJvmMemory();

    String getTotalJvmMemory();

    String getJreVersion();

    String getTempLocation();
}
