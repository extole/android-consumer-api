package com.extole.consumer.rest;

import com.extole.consumer.ApiClient;
import com.extole.consumer.EncodingUtils;
import com.extole.consumer.RestException;


import com.extole.consumer.rest.model.CreateTokenRequest;
import com.extole.consumer.rest.model.RestExceptionResponse;
import com.extole.consumer.rest.model.SuccessResponse;
import com.extole.consumer.rest.model.TokenResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

public interface AuthorizationEndpoints extends ApiClient.Api {

  /**
   * Creates a new access token
   * It is optional to pass an email or JWT.
   * @param body  (optional)
   * @return TokenResponse
   */
  @RequestLine("POST /v5/token")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  TokenResponse createToken(CreateTokenRequest body) throws RestException;

  /**
   * Creates a new access token
   * It is optional to pass an email or JWT.
   * Note, this is equivalent to the other <code>createToken</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param body  (optional)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>
   * @return TokenResponse

   */
  @RequestLine("POST /v5/token")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  TokenResponse createToken(CreateTokenRequest body, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

  /**
   * Deletes the unique access token identified in the request from the associate user&#x27;s profile.
   * It is optional to pass a token in the URL. If no token is passed in the URL it will attempt to delete any implied token from authorization header.
   * @return SuccessResponse
   */
  @RequestLine("DELETE /v5/token")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  SuccessResponse deleteToken() throws RestException;

  /**
   * Deletes the unique access token identified in the request from the associate user&#x27;s profile.
   * It is optional to pass a token in the URL. If no token is passed in the URL it will attempt to delete any implied token from authorization header.
   * Note, this is equivalent to the other <code>deleteToken</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>
   * @return SuccessResponse

   */
  @RequestLine("DELETE /v5/token")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  SuccessResponse deleteToken(@QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

  /**
   * Get access token details
   * It is optional to pass a token in the URL. If no token is passed in the URL it will attempt to return details about any implied token from authorization header.
   * @return TokenResponse
   */
  @RequestLine("GET /v5/token")
  @Headers({
      "Accept: application/json",
  })
  TokenResponse getTokenDetails() throws RestException;

  /**
   * Get access token details
   * It is optional to pass a token in the URL. If no token is passed in the URL it will attempt to return details about any implied token from authorization header.
   * Note, this is equivalent to the other <code>getTokenDetails</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>
   * @return TokenResponse

   */
  @RequestLine("GET /v5/token")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  TokenResponse getTokenDetails(@QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

}
