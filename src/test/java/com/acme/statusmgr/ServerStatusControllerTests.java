/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.acme.statusmgr;

import com.acme.MockSystemStatus;
import com.acme.statusmgr.beans.AbstractServerStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.is;

/**
 * Test class for status controller
 */

@SpringBootTest
@AutoConfigureMockMvc
public class ServerStatusControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public static void setUp() {
        AbstractServerStatus.setSystemStatus(new MockSystemStatus());
    }

    @Test
    public void noNameParamShouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(get("/server/status")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.statusDesc").value("Server is up"));
    }

    @Test
    public void nameParamShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(get("/server/status").param("name", "RebYid"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by RebYid"));
    }

    /**
     * Assert that detail and name param are operational
     * @throws Exception if invalid detail is passed
     */
    @Test
    public void basicDetail() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=availableProcessors&name=Bob"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Bob"))
                .andExpect(jsonPath("$.statusDesc").value("Server is up, and there are 4 processors available"));
    }

    /**
     * Assert all details operate, as well as proper ordering
     * @throws Exception if invalid detail is passed
     */
    @Test
    public void detailed_all_details() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=availableProcessors," +
                        "freeJvmMemory,jreVersion,tempLocation,totalJvmMemory"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.requestCost").value(72))
                .andExpect(jsonPath("$.statusDesc").value(
                        "Server is up, and there are 4 processors available, and there are 127268272 bytes " +
                                "of JVM memory free, and the JRE version is 15.0.2+7-27, and the server's temp file " +
                                "location is M:\\AppData\\Local\\Temp, and there is a total of 159383552 bytes of " +
                                "JVM memory"));
    }

    /**
     * Assert that details can be doubled
     * @throws Exception iif invalid detail is passed
     */
    @Test
    public void detailed_double_detail() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=availableProcessors,availableProcessors"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.requestCost").value(7))
                .andExpect(jsonPath("$.statusDesc").value(
                        "Server is up, and there are 4 processors available, and there are 4 processors available"));
    }

    /**
     * Assert appropriate error is thrown if invalid detail is requested
     * @throws IllegalArgumentException due to invalid detail
     */
    @Test
    public void badDetail() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=badDetail"))
                .andExpect(status().isBadRequest())
                .andExpect(status().reason(is("Invalid detail requested: badDetail")));
    }
}
/*
For the testing of expected error cases, instead of .andExpect(status().isOk()
you would call the .isXXXXXXX() method for the type of error you are expecting.
If that tests true (that you received that expected error, you would then use the
following pattern to check for your custom error message text:

.andExpect(status().reason(is("my custom message")));

The "is()" method should be imported via: "import static org.hamcrest.Matchers.is;"
 */
