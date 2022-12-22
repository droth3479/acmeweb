package com.acme;

/**
 * Interface for system status retrieval, to be implemented by concrete implementations.
 */
public interface ISystemStatus {
    /**
     * Get the current server status
     * @return string
     */
    String getCurrentServerStatus();

    /**
     * Get the number of currently available processors
     * @return string
     */
    String getAvailableProcessors();

    /**
     * Get the current free jvm memory
     * @return string
     */
    String getFreeJvmMemory();

    /**
     * Get the current jvm memory
     * @return string
     */
    String getTotalJvmMemory();

    /**
     * Get the current jre version
     * @return string
     */
    String getJreVersion();

    /**
     * Get the current temporary file location
     * @return string
     */
    String getTempLocation();
}
