package com.extole.consumer.rest;

import com.extole.consumer.ApiClient;
import com.extole.consumer.EncodingUtils;
import com.extole.consumer.RestException;


import com.extole.consumer.rest.model.PollingRewardResponse;
import com.extole.consumer.rest.model.RestExceptionResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

public interface MeRewardEndpoints extends ApiClient.Api {

  /**
   * 
   * Poll this endpoint in order to get Person reward
   * @param pollingId  (optional)
   * @param rewardName  (optional)
   * @param partnerEventId  (optional)
   * @return PollingRewardResponse
   */
  @RequestLine("GET /v4/me/rewards/status?polling_id={pollingId}&reward_name={rewardName}&partner_event_id={partnerEventId}")
  @Headers({
      "Accept: application/json",
  })
  PollingRewardResponse getRewardStatus(@Param("pollingId") String pollingId, @Param("rewardName") String rewardName, @Param("partnerEventId") String partnerEventId) throws RestException;

  /**
   * 
   * Poll this endpoint in order to get Person reward
   * Note, this is equivalent to the other <code>getRewardStatus</code> method,
   * but with the query parameters collected into a single Map parameter.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>pollingId -  (optional)</li>
   *   <li>rewardName -  (optional)</li>
   *   <li>partnerEventId -  (optional)</li>
   *   </ul>
   * @return PollingRewardResponse

   */
  @RequestLine("GET /v4/me/rewards/status?polling_id={pollingId}&reward_name={rewardName}&partner_event_id={partnerEventId}")
  @Headers({
      "Content-Type: */*",
      "Accept: application/json",
  })
  PollingRewardResponse getRewardStatus(@QueryMap(encoded=true) Map<String, Object> queryParams) throws RestException;

}
