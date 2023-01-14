package com.vitacard.rewardsvc.domain.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class RewardProgramRewardCategory2 {
    private String id;
    private String rewardProgramId;
    private String rewardCategory2Id;

    public String getId() {
        return id;
    }

    public RewardProgramRewardCategory2 setId(String id) {
        this.id = id;
        return this;
    }

    public String getRewardProgramId() {
        return rewardProgramId;
    }

    public RewardProgramRewardCategory2 setRewardProgramId(String rewardProgramId) {
        this.rewardProgramId = rewardProgramId;
        return this;
    }

    public String getRewardCategory2Id() {
        return rewardCategory2Id;
    }

    public RewardProgramRewardCategory2 setRewardCategory2Id(String rewardCategory2Id) {
        this.rewardCategory2Id = rewardCategory2Id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RewardProgramRewardCategory2 that = (RewardProgramRewardCategory2) o;

        return new EqualsBuilder().append(id, that.id).append(rewardProgramId, that.rewardProgramId).append(rewardCategory2Id, that.rewardCategory2Id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(rewardProgramId).append(rewardCategory2Id).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("rewardProgramId", rewardProgramId)
                .append("rewardCategory2Id", rewardCategory2Id)
                .toString();
    }
}

