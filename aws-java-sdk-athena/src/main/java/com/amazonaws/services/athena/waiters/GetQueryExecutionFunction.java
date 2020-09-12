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
import com.amazonaws.waiters.SdkFunction;

import javax.annotation.Generated;

@SdkInternalApi
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetQueryExecutionFunction implements SdkFunction<GetQueryExecutionRequest, GetQueryExecutionResult> {

    /**
     * Represents the service client
     */
    private final AmazonAthena client;

    /**
     * Constructs a new DescribeStacksFunction with the given client
     *
     * @param client Service client
     */
    public GetQueryExecutionFunction(AmazonAthena client) {
        this.client = client;
    }

    /**
     * Makes a call to the operation specified by the waiter by taking the corresponding request and returns the
     * corresponding result
     *
     * @param describeStacksRequest Corresponding request for the operation
     * @return Corresponding result of the operation
     */

    @Override
    public GetQueryExecutionResult apply(GetQueryExecutionRequest getQueryExecutionRequest) {
        return client.getQueryExecution(getQueryExecutionRequest);
    }
}
