package com.vitacard.rewardsvc.domain.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class RewardCategory1 {
    private String id;
    private String category;
    private String description;

    public String getId() {
        return id;
    }

    public RewardCategory1 setId(String id) {
        this.id = id;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public RewardCategory1 setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RewardCategory1 setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RewardCategory1 that = (RewardCategory1) o;

        return new EqualsBuilder().append(id, that.id).append(category, that.category).append(description, that.description).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(category).append(description).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("category", category)
                .append("description", description)
                .toString();
    }
}
