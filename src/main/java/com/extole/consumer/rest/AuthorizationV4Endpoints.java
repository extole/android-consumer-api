package com.extole.consumer.rest;

import com.extole.consumer.ApiClient;
import com.extole.consumer.EncodingUtils;
import com.extole.consumer.RestException;


import com.extole.consumer.rest.model.RestExceptionResponse;
import com.extole.consumer.rest.model.TokenV4Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

public interface AuthorizationV4Endpoints extends ApiClient.Api {

  /**
   * Deletes the unique access token identified in the request from the associate user&#x27;s profile.
   * It is optional to pass a token in the URL.  If no token is passed in the URL it will attempt to delete any implied token that exists as a cookie, fingerprint, etc.
   */
  @RequestLine("DELETE /v4/token")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  void deleteToken() throws RestException;

  /**
   * Deletes the unique access token identified in the request from the associate user&#x27;s profile.
   * It is optional to pass a token in the URL.  If no token is passed in the URL it will attempt to delete any implied token that exists as a cookie, fingerprint, etc.
   * Note, this is equivalent to the other <code>deleteToken</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>

   */
  @RequestLine("DELETE /v4/token")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  void deleteToken(@QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

  /**
   * Deletes the unique access token identified in the request from the associate user&#x27;s profile.
   * It is optional to pass a token in the URL.  If no token is passed in the URL it will attempt to delete any implied token that exists as a cookie, fingerprint, etc.
   * @param token  (required)
   */
  @RequestLine("DELETE /v4/token/{token}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  void deleteToken(@Param("token") String token) throws RestException;

  /**
   * Deletes the unique access token identified in the request from the associate user&#x27;s profile.
   * It is optional to pass a token in the URL.  If no token is passed in the URL it will attempt to delete any implied token that exists as a cookie, fingerprint, etc.
   * Note, this is equivalent to the other <code>deleteToken</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param token  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>

   */
  @RequestLine("DELETE /v4/token/{token}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  void deleteToken(@Param("token") String token, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

  /**
   * By calling the Get Token endpoint a new access token is created.
   * By calling the Get Token endpoint a new access token is created.  Extole will attempt to detect who the advocate is (based on cookies, browser fingerprint, etc) and provide them an access token with the greatest number of capabilities possible.  If Extole is unable to recognize the advocate the access token will only have the UPDATE_PROFILE capability available.
   * @return TokenV4Response
   */
  @RequestLine("GET /v4/token")
  @Headers({
      "Accept: application/json",
  })
  TokenV4Response getToken() throws RestException;

  /**
   * By calling the Get Token endpoint a new access token is created.
   * By calling the Get Token endpoint a new access token is created.  Extole will attempt to detect who the advocate is (based on cookies, browser fingerprint, etc) and provide them an access token with the greatest number of capabilities possible.  If Extole is unable to recognize the advocate the access token will only have the UPDATE_PROFILE capability available.
   * Note, this is equivalent to the other <code>getToken</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>
   * @return TokenV4Response

   */
  @RequestLine("GET /v4/token")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  TokenV4Response getToken(@QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

  /**
   * Returns the unique access token associated with the user in the browser.
   * 
   * @param token  (required)
   * @return TokenV4Response
   */
  @RequestLine("GET /v4/token/{token}")
  @Headers({
      "Accept: application/json",
  })
  TokenV4Response getTokenDetails(@Param("token") String token) throws RestException;

  /**
   * Returns the unique access token associated with the user in the browser.
   * 
   * Note, this is equivalent to the other <code>getTokenDetails</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param token  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>
   * @return TokenV4Response

   */
  @RequestLine("GET /v4/token/{token}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  TokenV4Response getTokenDetails(@Param("token") String token, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

  /**
   * Returns the unique access token associated with the user in the browser.
   * Support POST to get token details to allow request without token in url.
   * @return TokenV4Response
   */
  @RequestLine("POST /v4/token/get")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  TokenV4Response getTokenPost() throws RestException;

  /**
   * Returns the unique access token associated with the user in the browser.
   * Support POST to get token details to allow request without token in url.
   * Note, this is equivalent to the other <code>getTokenPost</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>
   * @return TokenV4Response

   */
  @RequestLine("POST /v4/token/get")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  TokenV4Response getTokenPost(@QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

}
