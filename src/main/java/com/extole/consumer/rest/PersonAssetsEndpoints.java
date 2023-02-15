package com.extole.consumer.rest;

import com.extole.consumer.ApiClient;
import com.extole.consumer.EncodingUtils;
import com.extole.consumer.RestException;


import com.extole.consumer.rest.model.RestExceptionResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

public interface PersonAssetsEndpoints extends ApiClient.Api {

  /**
   * Download asset by personId and assetId
   * 
   * @param personId The Extole unique profile identifier of this user at Extole. (required)
   * @param assetId The Extole unique profile identifier of this asset at Extole. (required)
   * @param defaultUrl  (optional)
   */
  @RequestLine("GET /web/persons/{personId}/assets/{assetId}/download?default_url={defaultUrl}")
  @Headers({
      "Accept: application/json",
  })
  void downloadAssetById(@Param("personId") String personId, @Param("assetId") String assetId, @Param("defaultUrl") String defaultUrl) throws RestException;

  /**
   * Download asset by personId and assetId
   * 
   * Note, this is equivalent to the other <code>downloadAssetById</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param personId The Extole unique profile identifier of this user at Extole. (required)
   * @param assetId The Extole unique profile identifier of this asset at Extole. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>defaultUrl -  (optional)</li>
   *   </ul>

   */
  @RequestLine("GET /web/persons/{personId}/assets/{assetId}/download?default_url={defaultUrl}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  void downloadAssetById(@Param("personId") String personId, @Param("assetId") String assetId, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

  /**
   * Download asset by personId and name
   * 
   * @param personId The Extole unique profile identifier of this user at Extole. (required)
   * @param name  (optional)
   * @param defaultUrl  (optional)
   */
  @RequestLine("GET /web/persons/{personId}/assets/download?name={name}&default_url={defaultUrl}")
  @Headers({
      "Accept: application/json",
  })
  void downloadAssetByName(@Param("personId") String personId, @Param("name") String name, @Param("defaultUrl") String defaultUrl) throws RestException;

  /**
   * Download asset by personId and name
   * 
   * Note, this is equivalent to the other <code>downloadAssetByName</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param personId The Extole unique profile identifier of this user at Extole. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>name -  (optional)</li>
   *   <li>defaultUrl -  (optional)</li>
   *   </ul>

   */
  @RequestLine("GET /web/persons/{personId}/assets/download?name={name}&default_url={defaultUrl}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  void downloadAssetByName(@Param("personId") String personId, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

}
