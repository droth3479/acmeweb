package com.acme;

public class MockSystemStatus implements ISystemStatus{
    public String getCurrentServerStatus() {
        return "Server is up";
    }

    public String getAvailableProcessors() {
        return ", and there are 4 processors available";
    }

    public String getFreeJvmMemory() {
        return ", and there are 127268272 bytes of JVM memory free";
    }

    public String getTotalJvmMemory() {
        return ", and there is a total of 159383552 bytes of JVM memory";
    }

    public String getJreVersion() {
        return ", and the JRE version is 15.0.2+7-27";
    }

    public String getTempLocation() {
        return ", and the server's temp file location is M:\\AppData\\Local\\Temp";
    }
}
