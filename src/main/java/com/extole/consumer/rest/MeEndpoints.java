package com.extole.consumer.rest;

import com.extole.consumer.ApiClient;
import com.extole.consumer.EncodingUtils;
import com.extole.consumer.RestException;


import com.extole.consumer.rest.model.MyProfileResponse;
import com.extole.consumer.rest.model.RestExceptionResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

public interface MeEndpoints extends ApiClient.Api {

  /**
   * 
   * Will return profile information based on the access token used.
   * @return MyProfileResponse
   */
  @RequestLine("GET /v4/me")
  @Headers({
      "Accept: application/json",
  })
  MyProfileResponse getMyProfile() throws RestException;

  /**
   * 
   * Will return profile information based on the access token used.
   * Note, this is equivalent to the other <code>getMyProfile</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>
   * @return MyProfileResponse

   */
  @RequestLine("GET /v4/me")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  MyProfileResponse getMyProfile(@QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

}
