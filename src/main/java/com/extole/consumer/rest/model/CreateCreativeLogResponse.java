/*
 * Extole consumer-api
 * This is a sample generated doc.
 *
 * OpenAPI spec version: 1.0
 * Contact: support@extole.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.extole.consumer.rest.model;

import java.util.*;
import java.time.*;
import java.math.*;
import com.extole.consumer.*;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;
/**
 * CreateCreativeLogResponse
 */


public class CreateCreativeLogResponse {
  @JsonProperty("polling_id")
  private String pollingId = null;

  public CreateCreativeLogResponse pollingId(String pollingId) {
    this.pollingId = pollingId;
    return this;
  }

   /**
   * Get pollingId
   * @return pollingId
  **/
  @Schema(description = "")
  public String getPollingId() {
    return pollingId;
  }

  public void setPollingId(String pollingId) {
    this.pollingId = pollingId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCreativeLogResponse createCreativeLogResponse = (CreateCreativeLogResponse) o;
    return Objects.equals(this.pollingId, createCreativeLogResponse.pollingId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pollingId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCreativeLogResponse {\n");
    
    sb.append("    pollingId: ").append(toIndentedString(pollingId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
