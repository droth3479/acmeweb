package com.acme.statusmgr;

import com.acme.SystemStatus;
import com.acme.statusmgr.Decorators.*;
import com.acme.statusmgr.beans.AbstractServerStatus;
import com.acme.statusmgr.beans.ServerStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Controller for all web/REST requests about the status of servers
 * <p>
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 * All start with /server
 * /status  will give back status of server
 * a param of 'name' specifies a requestor name to appear in response
 * <p>
 * Examples:
 * http://localhost:8080/server/status
 * <p>
 * http://localhost:8080/server/status?name=Noach
 */
@RestController
@RequestMapping("/server")
public class StatusController {

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();
    protected final Logger logger = LoggerFactory.getLogger("DetailLogger");
    protected static final String logTemplate = "Details were provided: [%s]";


    /**
     * Process a request for server status information
     *
     * @param name optional param identifying the requester
     * @return a ServerStatus object containing the info to be returned to the requestor
     */
    @RequestMapping("/status")
    public ServerStatus getStatus(@RequestParam(value = "name", defaultValue = "Anonymous") String name,
                                  @RequestParam(value = "details", required = false) List<String> details) {
        if(details != null) {
            logger.info(String.format(logTemplate, String.join(",", details)));
        }

        return new ServerStatus(counter.incrementAndGet(),
                String.format(template, name), new SystemStatus());
    }

    /**
     * Process a request for detailed server status info
     *
     * @param name optional param identifying the requester
     * @param details a list of details requested
     * @return a ServerStatus object containing the details to be returned to the requester
     */
    @RequestMapping("/status/detailed")
    public AbstractServerStatus getDetailedStatus(@RequestParam(value = "name", defaultValue = "Anonymous") String name,
                                          @RequestParam(value = "details") List<String> details) {
        System.out.println("In method");
        AbstractServerStatus status = new ServerStatus(counter.incrementAndGet(), String.format(template, name), new SystemStatus());
        for (String detail : details) {
            System.out.println("in for");
            status = switch (detail) {
                case "availableProcessors" -> new AvailableProcessorsDecorator(status);
                case "freeJvmMemory" -> new FreeJvmMemoryDecorator(status);
                case "jreVersion" -> new JreVersionDecorator(status);
                case "tempLocation" -> new TempLocationDecorator(status);
                case "totalJvmMemory" -> new TotalJvmMemoryDecorator(status);
                default ->
            };
        }
        System.out.println("about to return");
        return status;
    }
}
