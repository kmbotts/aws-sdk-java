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

import com.amazonaws.AmazonServiceException;
import com.amazonaws.annotation.SdkInternalApi;
import com.amazonaws.jmespath.*;
import com.amazonaws.services.athena.model.GetQueryExecutionResult;
import com.amazonaws.waiters.AcceptorPathMatcher;
import com.amazonaws.waiters.WaiterAcceptor;
import com.amazonaws.waiters.WaiterState;
import com.fasterxml.jackson.databind.JsonNode;

import javax.annotation.Generated;
import java.io.IOException;

@SdkInternalApi
@Generated("com.amazonaws:aws-java-sdk-code-generator")
class QueryExecutionSucceeded {

    static class IsSUCCEEDEDMatcher extends WaiterAcceptor<GetQueryExecutionResult> {
        private static final JsonNode expectedResult;

        static {
            try {
                expectedResult = ObjectMapperSingleton.getObjectMapper().readTree("\"SUCCEEDED\"");
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
        }

        private static final JmesPathExpression ast = new JmesPathProjection(new JmesPathField("queryExecution"),
                new JmesPathSubExpression(new JmesPathField("status"), new JmesPathField("state")));

        /**
         * Takes the result and determines whether the state of the resource matches the expected state. To determine
         * the current state of the resource, JmesPath expression is evaluated and compared against the expected result.
         *
         * @param result Corresponding result of the operation
         * @return True if current state of the resource matches the expected state, False otherwise
         */
        @Override
        public boolean matches(GetQueryExecutionResult result) {
            JsonNode queryNode = ObjectMapperSingleton.getObjectMapper().valueToTree(result);
            JsonNode finalResult = ast.accept(new JmesPathEvaluationVisitor(), queryNode);
            return AcceptorPathMatcher.pathAll(expectedResult, finalResult);
        }

        /**
         * Represents the current waiter state in the case where resource state matches the expected state
         *
         * @return Corresponding state of the waiter
         */
        @Override
        public WaiterState getState() {
            return WaiterState.SUCCESS;
        }
    }

    static class IsFAILEDMatcher extends WaiterAcceptor<GetQueryExecutionResult> {
        private static final JsonNode expectedResult;

        static {
            try {
                expectedResult = ObjectMapperSingleton.getObjectMapper().readTree("\"FAILED\"");
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
        }

        private static final JmesPathExpression ast = new JmesPathProjection(new JmesPathField("queryExecution"),
                new JmesPathSubExpression(new JmesPathField("status"), new JmesPathField("state")));

        /**
         * Takes the result and determines whether the state of the resource matches the expected state. To determine
         * the current state of the resource, JmesPath expression is evaluated and compared against the expected result.
         *
         * @param result Corresponding result of the operation
         * @return True if current state of the resource matches the expected state, False otherwise
         */
        @Override
        public boolean matches(GetQueryExecutionResult result) {
            JsonNode queryNode = ObjectMapperSingleton.getObjectMapper().valueToTree(result);
            JsonNode finalResult = ast.accept(new JmesPathEvaluationVisitor(), queryNode);
            return AcceptorPathMatcher.pathAny(expectedResult, finalResult);
        }

        /**
         * Represents the current waiter state in the case where resource state matches the expected state
         *
         * @return Corresponding state of the waiter
         */
        @Override
        public WaiterState getState() {
            return WaiterState.FAILURE;
        }
    }

    static class IsCANCELLEDMatcher extends WaiterAcceptor<GetQueryExecutionResult> {
        private static final JsonNode expectedResult;

        static {
            try {
                expectedResult = ObjectMapperSingleton.getObjectMapper().readTree("\"CANCELLED\"");
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
        }

        private static final JmesPathExpression ast = new JmesPathProjection(new JmesPathField("queryExecution"),
                new JmesPathSubExpression(new JmesPathField("status"), new JmesPathField("state")));

        /**
         * Takes the result and determines whether the state of the resource matches the expected state. To determine
         * the current state of the resource, JmesPath expression is evaluated and compared against the expected result.
         *
         * @param result Corresponding result of the operation
         * @return True if current state of the resource matches the expected state, False otherwise
         */
        @Override
        public boolean matches(GetQueryExecutionResult result) {
            JsonNode queryNode = ObjectMapperSingleton.getObjectMapper().valueToTree(result);
            JsonNode finalResult = ast.accept(new JmesPathEvaluationVisitor(), queryNode);
            return AcceptorPathMatcher.pathAny(expectedResult, finalResult);
        }

        /**
         * Represents the current waiter state in the case where resource state matches the expected state
         *
         * @return Corresponding state of the waiter
         */
        @Override
        public WaiterState getState() {
            return WaiterState.FAILURE;
        }
    }

    static class IsValidationErrorMatcher extends WaiterAcceptor<GetQueryExecutionResult> {
        /**
         * Takes the response exception and determines whether this exception matches the expected exception, by
         * comparing the respective error codes.
         *
         * @param e Response Exception
         * @return True if it matches, False otherwise
         */
        @Override
        public boolean matches(AmazonServiceException e) {
            return "ValidationError".equals(e.getErrorCode());
        }

        /**
         * Represents the current waiter state in the case where resource state matches the expected state
         *
         * @return Corresponding state of the waiter
         */
        @Override
        public WaiterState getState() {
            return WaiterState.FAILURE;
        }
    }
}
