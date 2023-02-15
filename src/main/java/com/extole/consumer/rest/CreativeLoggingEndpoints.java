package com.extole.consumer.rest;

import com.extole.consumer.ApiClient;
import com.extole.consumer.EncodingUtils;
import com.extole.consumer.RestException;


import com.extole.consumer.rest.model.CreateCreativeLogRequest;
import com.extole.consumer.rest.model.CreateCreativeLogResponse;
import com.extole.consumer.rest.model.RestExceptionResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

public interface CreativeLoggingEndpoints extends ApiClient.Api {

  /**
   * Used to send log messages to Extole
   * 
   * @param body  (optional)
   * @return CreateCreativeLogResponse
   */
  @RequestLine("POST /v4/debug/logs")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  CreateCreativeLogResponse create(CreateCreativeLogRequest body) throws RestException;

  /**
   * Used to send log messages to Extole
   * 
   * Note, this is equivalent to the other <code>create</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param body  (optional)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>
   * @return CreateCreativeLogResponse

   */
  @RequestLine("POST /v4/debug/logs")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  CreateCreativeLogResponse create(CreateCreativeLogRequest body, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

}
