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
 * CreativeMetricRequest
 */


public class CreativeMetricRequest {
  @JsonProperty("key")
  private String key = null;

  /**
   * Gets or Sets metricType
   */
  public enum MetricTypeEnum {
    HISTOGRAM("HISTOGRAM"),
    COUNTER("COUNTER");

    private String value;

    MetricTypeEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static MetricTypeEnum fromValue(String text) {
      for (MetricTypeEnum b : MetricTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("metric_type")
  private MetricTypeEnum metricType = null;

  @JsonProperty("value")
  private Long value = null;

  public CreativeMetricRequest key(String key) {
    this.key = key;
    return this;
  }

   /**
   * Get key
   * @return key
  **/
  @Schema(description = "")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public CreativeMetricRequest metricType(MetricTypeEnum metricType) {
    this.metricType = metricType;
    return this;
  }

   /**
   * Get metricType
   * @return metricType
  **/
  @Schema(description = "")
  public MetricTypeEnum getMetricType() {
    return metricType;
  }

  public void setMetricType(MetricTypeEnum metricType) {
    this.metricType = metricType;
  }

  public CreativeMetricRequest value(Long value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @Schema(description = "")
  public Long getValue() {
    return value;
  }

  public void setValue(Long value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreativeMetricRequest creativeMetricRequest = (CreativeMetricRequest) o;
    return Objects.equals(this.key, creativeMetricRequest.key) &&
        Objects.equals(this.metricType, creativeMetricRequest.metricType) &&
        Objects.equals(this.value, creativeMetricRequest.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, metricType, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreativeMetricRequest {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    metricType: ").append(toIndentedString(metricType)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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