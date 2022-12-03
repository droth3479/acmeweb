package com.acme;

public class SystemStatus implements ISystemStatus{
    static String getCurrentServerStatus() {
        return "up";
    }

    static String getAvailableProcessors() {
        return String.format(", and there are %d processors available",
                Runtime.getRuntime().availableProcessors());
    }

    static String getFreeJvmMemory() {
        return String.format(", and there are %d bytes of JVM memory free",
                Runtime.getRuntime().freeMemory());
    }

    static String getTotalJvmMemory() {
        return String.format("\n" +
                ", and there is a total of %d bytes of JVM memory",
                Runtime.getRuntime().totalMemory());
    }

    static String getJreVersion() {
        return String.format(", and the JRE version is %s",
                Runtime.version());
    }

    static String getTempLocation() {
        return String.format(", and the server's temp file location is %s",
                System.getenv("TEMP"));
    }
}
