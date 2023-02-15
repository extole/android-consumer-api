package com.extole.consumer;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RestException extends RuntimeException {

    private final String uniqueId;
    private final String httpStatusCode;
    private final String errorCode;
    private final String message;
    private final Map<String, String> parameters;

    @JsonCreator
    public RestException(@JsonProperty("unique_id") String uniqueId,
        @JsonProperty("http_status_code") String httpStatusCode,
        @JsonProperty("error_code") String errorCode,
        @JsonProperty("message") String message,
        @JsonProperty("parameters") Map<String, String> parameters) {
        super(message);
        this.uniqueId = uniqueId;
        this.httpStatusCode = httpStatusCode;
        this.errorCode = errorCode;
        this.message = message;
        this.parameters = parameters;
    }

    @JsonProperty("unique_id")
    public String getUniqueId() {
        return uniqueId;
    }

    @JsonProperty("http_status_code")
    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    @JsonProperty("error_code")
    public String getErrorCode() {
        return errorCode;
    }

    @JsonProperty("message")
    @Override
    public String getMessage() {
        return message;
    }

    @JsonProperty("parameters")
    public Map<String, String> getParameters() {
        return parameters;
    }
}