package com.acme;

public class SystemStatus implements ISystemStatus{
    public String getCurrentServerStatus() {
        return "up";
    }

    public String getAvailableProcessors() {
        return String.format(", and there are %d processors available",
                Runtime.getRuntime().availableProcessors());
    }

    public String getFreeJvmMemory() {
        return String.format(", and there are %d bytes of JVM memory free",
                Runtime.getRuntime().freeMemory());
    }

    public String getTotalJvmMemory() {
        return String.format("\n" +
                ", and there is a total of %d bytes of JVM memory",
                Runtime.getRuntime().totalMemory());
    }

    public String getJreVersion() {
        return String.format(", and the JRE version is %s",
                Runtime.version());
    }

    public String getTempLocation() {
        return String.format(", and the server's temp file location is %s",
                System.getenv("TEMP"));
    }
}
