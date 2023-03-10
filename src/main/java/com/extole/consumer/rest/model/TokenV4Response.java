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
import java.util.List;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
/**
 * TokenV4Response
 */


public class TokenV4Response {
  @JsonProperty("access_token")
  private String accessToken = null;

  @JsonProperty("expires_in")
  private Long expiresIn = null;

  /**
   * Gets or Sets scopes
   */
  public enum ScopesEnum {
    VERIFIED_CONSUMER("VERIFIED_CONSUMER"),
    UPDATE_PROFILE("UPDATE_PROFILE");

    private String value;

    ScopesEnum(String value) {
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
    public static ScopesEnum fromValue(String text) {
      for (ScopesEnum b : ScopesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("scopes")
  private List<ScopesEnum> scopes = null;

  /**
   * Gets or Sets capabilities
   */
  public enum CapabilitiesEnum {
    VERIFIED_CONSUMER("VERIFIED_CONSUMER"),
    UPDATE_PROFILE("UPDATE_PROFILE");

    private String value;

    CapabilitiesEnum(String value) {
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
    public static CapabilitiesEnum fromValue(String text) {
      for (CapabilitiesEnum b : CapabilitiesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("capabilities")
  private List<CapabilitiesEnum> capabilities = null;

  public TokenV4Response accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

   /**
   * Get accessToken
   * @return accessToken
  **/
  @Schema(description = "")
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public TokenV4Response expiresIn(Long expiresIn) {
    this.expiresIn = expiresIn;
    return this;
  }

   /**
   * Get expiresIn
   * @return expiresIn
  **/
  @Schema(description = "")
  public Long getExpiresIn() {
    return expiresIn;
  }

  public void setExpiresIn(Long expiresIn) {
    this.expiresIn = expiresIn;
  }

  public TokenV4Response scopes(List<ScopesEnum> scopes) {
    this.scopes = scopes;
    return this;
  }

  public TokenV4Response addScopesItem(ScopesEnum scopesItem) {
    if (this.scopes == null) {
      this.scopes = new ArrayList<>();
    }
    this.scopes.add(scopesItem);
    return this;
  }

   /**
   * Get scopes
   * @return scopes
  **/
  @Schema(description = "")
  public List<ScopesEnum> getScopes() {
    return scopes;
  }

  public void setScopes(List<ScopesEnum> scopes) {
    this.scopes = scopes;
  }

  public TokenV4Response capabilities(List<CapabilitiesEnum> capabilities) {
    this.capabilities = capabilities;
    return this;
  }

  public TokenV4Response addCapabilitiesItem(CapabilitiesEnum capabilitiesItem) {
    if (this.capabilities == null) {
      this.capabilities = new ArrayList<>();
    }
    this.capabilities.add(capabilitiesItem);
    return this;
  }

   /**
   * Get capabilities
   * @return capabilities
  **/
  @Schema(description = "")
  public List<CapabilitiesEnum> getCapabilities() {
    return capabilities;
  }

  public void setCapabilities(List<CapabilitiesEnum> capabilities) {
    this.capabilities = capabilities;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenV4Response tokenV4Response = (TokenV4Response) o;
    return Objects.equals(this.accessToken, tokenV4Response.accessToken) &&
        Objects.equals(this.expiresIn, tokenV4Response.expiresIn) &&
        Objects.equals(this.scopes, tokenV4Response.scopes) &&
        Objects.equals(this.capabilities, tokenV4Response.capabilities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, expiresIn, scopes, capabilities);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenV4Response {\n");
    
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
    sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
    sb.append("    capabilities: ").append(toIndentedString(capabilities)).append("\n");
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
