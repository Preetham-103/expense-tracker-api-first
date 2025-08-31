package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ExpenseSummary
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-31T13:54:08.277838500+05:30[Asia/Calcutta]", comments = "Generator version: 7.14.0")
public class ExpenseSummary {

  private @Nullable String category;

  private @Nullable Double totalAmount;

  public ExpenseSummary category(@Nullable String category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   */
  
  @Schema(name = "category", example = "Food", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("category")
  public @Nullable String getCategory() {
    return category;
  }

  public void setCategory(@Nullable String category) {
    this.category = category;
  }

  public ExpenseSummary totalAmount(@Nullable Double totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

  /**
   * Get totalAmount
   * @return totalAmount
   */
  
  @Schema(name = "totalAmount", example = "500.75", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalAmount")
  public @Nullable Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(@Nullable Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExpenseSummary expenseSummary = (ExpenseSummary) o;
    return Objects.equals(this.category, expenseSummary.category) &&
        Objects.equals(this.totalAmount, expenseSummary.totalAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, totalAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExpenseSummary {\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

