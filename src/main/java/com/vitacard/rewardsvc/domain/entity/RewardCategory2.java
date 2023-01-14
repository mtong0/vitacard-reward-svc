package com.vitacard.rewardsvc.domain.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class RewardCategory2 {
    private String id;
    private String category;
    private String description;
    private String category1Id;

    public String getId() {
        return id;
    }

    public RewardCategory2 setId(String id) {
        this.id = id;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public RewardCategory2 setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RewardCategory2 setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCategory1Id() {
        return category1Id;
    }

    public RewardCategory2 setCategory1Id(String category1Id) {
        this.category1Id = category1Id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RewardCategory2 that = (RewardCategory2) o;

        return new EqualsBuilder().append(id, that.id).append(category, that.category).append(description, that.description).append(category1Id, that.category1Id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(category).append(description).append(category1Id).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("category", category)
                .append("description", description)
                .append("category1Id", category1Id)
                .toString();
    }
}
