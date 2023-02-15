package com.extole.consumer.rest;

import com.extole.consumer.ApiClient;
import com.extole.consumer.EncodingUtils;
import com.extole.consumer.RestException;


import com.extole.consumer.rest.model.RestExceptionResponse;
import com.extole.consumer.rest.model.SubmitEventRequest;
import com.extole.consumer.rest.model.SubmitEventResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

public interface EventEndpoints extends ApiClient.Api {

  /**
   * Submits the event with the name specified in URI.
   * Event data may be passed as query parameters and/or JWT encoded query parameter. This endpoint may return a new access_token cookie. Please use the more standard /api/vN/events endpoint if you want to manage the access token.
   * @param eventName  (required)
   * @return SubmitEventResponse
   */
  @RequestLine("GET /events/{eventName}")
  @Headers({
      "Accept: application/json",
  })
  SubmitEventResponse fetch(@Param("eventName") String eventName) throws RestException;

  /**
   * Submits the event with the name specified in URI.
   * Event data may be passed as query parameters and/or JWT encoded query parameter. This endpoint may return a new access_token cookie. Please use the more standard /api/vN/events endpoint if you want to manage the access token.
   * Note, this is equivalent to the other <code>fetch</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param eventName  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>
   * @return SubmitEventResponse

   */
  @RequestLine("GET /events/{eventName}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  SubmitEventResponse fetch(@Param("eventName") String eventName, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

  /**
   * Submits the event with the name specified in request body.
   * Event data may be passed as query parameters/request body and/or  JWT encoded query parameter/request body attribute. This endpoint may return a new access_token cookie. Please use the more standard /api/vN/events endpoint if you want to manage the access token.
   * @param body  (optional)
   * @return SubmitEventResponse
   */
  @RequestLine("POST /events")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  SubmitEventResponse post(SubmitEventRequest body) throws RestException;

  /**
   * Submits the event with the name specified in request body.
   * Event data may be passed as query parameters/request body and/or  JWT encoded query parameter/request body attribute. This endpoint may return a new access_token cookie. Please use the more standard /api/vN/events endpoint if you want to manage the access token.
   * Note, this is equivalent to the other <code>post</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param body  (optional)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>
   * @return SubmitEventResponse

   */
  @RequestLine("POST /events")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  SubmitEventResponse post(SubmitEventRequest body, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

}
