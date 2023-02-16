package com.extole.consumer.rest;

import com.extole.consumer.ApiClient;
import com.extole.consumer.EncodingUtils;
import com.extole.consumer.RestException;


import com.extole.consumer.rest.model.RenderZoneRequest;
import com.extole.consumer.rest.model.RestExceptionResponse;
import com.extole.consumer.rest.model.ZoneResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

public interface ZoneEndpoints extends ApiClient.Api {

  /**
   * 
   * This endpoint is REST - optimized. For web behavior consider /zones endpoints.
   * @param eventName  (required)
   * @param body  (optional)
   * @return ZoneResponse
   */
  @RequestLine("POST /v6/zones/{eventName}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  ZoneResponse render(@Param("eventName") String eventName, Map<String, Object> body) throws RestException;

  /**
   * 
   * This endpoint is REST - optimized. For web behavior consider /zones endpoints.
   * Note, this is equivalent to the other <code>render</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param eventName  (required)
   * @param body  (optional)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>
   * @return ZoneResponse

   */
  @RequestLine("POST /v6/zones/{eventName}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  ZoneResponse render(@Param("eventName") String eventName, Map<String, Object> body, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

  /**
   * 
   * This endpoint is REST - optimized. For web behavior consider /zones endpoints.
   * @param body  (optional)
   * @return ZoneResponse
   */
  @RequestLine("POST /v6/zones")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  ZoneResponse render(RenderZoneRequest body) throws RestException;

  /**
   * 
   * This endpoint is REST - optimized. For web behavior consider /zones endpoints.
   * Note, this is equivalent to the other <code>render</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param body  (optional)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>
   * @return ZoneResponse

   */
  @RequestLine("POST /v6/zones")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  ZoneResponse render(RenderZoneRequest body, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

}
