/*
 * Copyright 2015-2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.athena.waiters;

import com.amazonaws.annotation.SdkInternalApi;
import com.amazonaws.services.athena.AmazonAthena;
import com.amazonaws.services.athena.model.GetQueryExecutionRequest;
import com.amazonaws.services.athena.model.GetQueryExecutionResult;
import com.amazonaws.waiters.*;

import javax.annotation.Generated;
import java.util.concurrent.ExecutorService;

@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class AmazonAthenaWaiters {

    /**
     * Represents the service client
     */
    private final AmazonAthena client;

    private final ExecutorService executorService = WaiterExecutorServiceFactory.buildExecutorServiceForWaiter("AmazonAthenaWaiters");

    /**
     * Constructs a new AmazonAthenaWaiters with the given client
     *
     * @param client Service client
     */
    @SdkInternalApi
    public AmazonAthenaWaiters(AmazonAthena client) {
        this.client = client;
    }

    /**
     * Builds a QueryExecutionSucceeded waiter by using custom parameters waiterParameters and other parameters defined in the
     * waiters specification, and then polls until it determines whether the resource entered the desired state or not,
     * where polling criteria is bound by either default polling strategy or custom polling strategy.
     */
    public Waiter<GetQueryExecutionRequest> queryExecutionSucceeded() {

        return new WaiterBuilder<GetQueryExecutionRequest, GetQueryExecutionResult>()
                .withSdkFunction(new GetQueryExecutionFunction(client))
                .withAcceptors(new QueryExecutionSucceeded.IsSUCCEEDEDMatcher(), new QueryExecutionSucceeded.IsCANCELLEDMatcher(),
                        new QueryExecutionSucceeded.IsFAILEDMatcher(), new QueryExecutionSucceeded.IsValidationErrorMatcher())
                .withDefaultPollingStrategy(new PollingStrategy(new MaxAttemptsRetryStrategy(60), new FixedDelayStrategy(3)))
                .withExecutorService(executorService).build();
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
