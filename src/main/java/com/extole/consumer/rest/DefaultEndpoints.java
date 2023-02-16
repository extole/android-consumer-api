package com.extole.consumer.rest;

import com.extole.consumer.ApiClient;
import com.extole.consumer.EncodingUtils;
import com.extole.consumer.RestException;


import com.extole.consumer.rest.model.CreativeMetricRequest;
import com.extole.consumer.rest.model.CreativeMetricResponse;
import com.extole.consumer.rest.model.PersonAssetResponse;
import com.extole.consumer.rest.model.RenderZoneRequest;
import com.extole.consumer.rest.model.RestExceptionResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

public interface DefaultEndpoints extends ApiClient.Api {

  /**
   * Download content for an asset
   * 
   * @param personId The Extole unique profile identifier of this user at Extole. (required)
   * @param assetId The Extole unique profile identifier of this asset at Extole. (required)
   */
  @RequestLine("GET /v4/persons/{personId}/assets/{assetId}/download")
  @Headers({
      "Accept: application/json",
  })
  void downloadAssetById(@Param("personId") String personId, @Param("assetId") String assetId) throws RestException;

  /**
   * Download content for an asset
   * 
   * Note, this is equivalent to the other <code>downloadAssetById</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param personId The Extole unique profile identifier of this user at Extole. (required)
   * @param assetId The Extole unique profile identifier of this asset at Extole. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>

   */
  @RequestLine("GET /v4/persons/{personId}/assets/{assetId}/download")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  void downloadAssetById(@Param("personId") String personId, @Param("assetId") String assetId, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

  /**
   * Download content for an asset
   * 
   * @param personId The Extole unique profile identifier of this user at Extole. (required)
   * @param name  (optional)
   */
  @RequestLine("GET /v4/persons/{personId}/assets/download?name={name}")
  @Headers({
      "Accept: application/json",
  })
  void downloadAssetByName(@Param("personId") String personId, @Param("name") String name) throws RestException;

  /**
   * Download content for an asset
   * 
   * Note, this is equivalent to the other <code>downloadAssetByName</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param personId The Extole unique profile identifier of this user at Extole. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>name -  (optional)</li>
   *   </ul>

   */
  @RequestLine("GET /v4/persons/{personId}/assets/download?name={name}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  void downloadAssetByName(@Param("personId") String personId, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

  /**
   * Get a list of assets
   * 
   * @param personId The Extole unique profile identifier of this user at Extole. (required)
   * @return List&lt;PersonAssetResponse&gt;
   */
  @RequestLine("GET /v4/persons/{personId}/assets")
  @Headers({
      "Accept: application/json",
  })
  List<PersonAssetResponse> listAssets(@Param("personId") String personId) throws RestException;

  /**
   * Get a list of assets
   * 
   * Note, this is equivalent to the other <code>listAssets</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param personId The Extole unique profile identifier of this user at Extole. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>
   * @return List&lt;PersonAssetResponse&gt;

   */
  @RequestLine("GET /v4/persons/{personId}/assets")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  List<PersonAssetResponse> listAssets(@Param("personId") String personId, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

  /**
   * 
   * This endpoint is optimized for calling from a web page.For proper RESTful endpoint consider /v6/zones.
   * @param zoneName  (required)
   * @param body  (optional)
   */
  @RequestLine("POST /zones/{zoneName}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  void post(@Param("zoneName") String zoneName, Map<String, Object> body) throws RestException;

  /**
   * 
   * This endpoint is optimized for calling from a web page.For proper RESTful endpoint consider /v6/zones.
   * Note, this is equivalent to the other <code>post</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param zoneName  (required)
   * @param body  (optional)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>

   */
  @RequestLine("POST /zones/{zoneName}")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  void post(@Param("zoneName") String zoneName, Map<String, Object> body, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

  /**
   * 
   * This endpoint is optimized for calling from a web page.For proper RESTful endpoint consider /v6/zones.
   * @param body  (optional)
   */
  @RequestLine("POST /zones")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  void post(RenderZoneRequest body) throws RestException;

  /**
   * 
   * This endpoint is optimized for calling from a web page.For proper RESTful endpoint consider /v6/zones.
   * Note, this is equivalent to the other <code>post</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param body  (optional)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>

   */
  @RequestLine("POST /zones")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  void post(RenderZoneRequest body, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

  /**
   * Gets Details for an asset
   * 
   * @param personId The Extole unique profile identifier of this user at Extole. (required)
   * @param assetId The Extole unique profile identifier of this asset at Extole. (required)
   * @return PersonAssetResponse
   */
  @RequestLine("GET /v4/persons/{personId}/assets/{assetId}")
  @Headers({
      "Accept: application/json",
  })
  PersonAssetResponse readAsset(@Param("personId") String personId, @Param("assetId") String assetId) throws RestException;

  /**
   * Gets Details for an asset
   * 
   * Note, this is equivalent to the other <code>readAsset</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param personId The Extole unique profile identifier of this user at Extole. (required)
   * @param assetId The Extole unique profile identifier of this asset at Extole. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>
   * @return PersonAssetResponse

   */
  @RequestLine("GET /v4/persons/{personId}/assets/{assetId}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  PersonAssetResponse readAsset(@Param("personId") String personId, @Param("assetId") String assetId, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

  /**
   * Record metric internally in grafana
   * 
   * @param body  (optional)
   * @return CreativeMetricResponse
   */
  @RequestLine("POST /v4/debug/metrics")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  CreativeMetricResponse record(CreativeMetricRequest body) throws RestException;

  /**
   * Record metric internally in grafana
   * 
   * Note, this is equivalent to the other <code>record</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param body  (optional)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   </ul>
   * @return CreativeMetricResponse

   */
  @RequestLine("POST /v4/debug/metrics")
  @Headers({
      "Content-Type: application/json",
      "Accept: application/json",
  })
  CreativeMetricResponse record(CreativeMetricRequest body, @QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

}
