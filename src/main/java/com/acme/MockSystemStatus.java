package com.acme;

public class MockSystemStatus implements ISystemStatus{
    static String getCurrentServerStatus() {
        return "up";
    }

    static String getAvailableProcessors() {
        return ", and there are 4 processors available";
    }

    static String getFreeJvmMemory() {
        return ", and there are 127268272 bytes of JVM memory free";
    }

    static String getTotalJvmMemory() {
        return ", and there is a total of 159383552 bytes of JVM memory";
    }

    static String getJreVersion() {
        return ", and the JRE version is 15.0.2+7-27";
    }

    static String getTempLocation() {
        return ", and the server's temp file location is M:\\\\AppData\\\\Local\\\\Temp";
    }
}
