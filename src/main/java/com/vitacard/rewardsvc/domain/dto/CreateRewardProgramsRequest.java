package com.vitacard.rewardsvc.domain.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Map;
import java.util.Set;

public class CreateRewardProgramsRequest {
    private long customerId;
    private Map<String, Set<String>> rewardCategoryMap;

    public long getCustomerId() {
        return customerId;
    }

    public CreateRewardProgramsRequest setCustomerId(long customerId) {
        this.customerId = customerId;
        return this;
    }

    public Map<String, Set<String>> getRewardCategoryMap() {
        return rewardCategoryMap;
    }

    public CreateRewardProgramsRequest setRewardCategoryMap(Map<String, Set<String>> rewardCategoryMap) {
        this.rewardCategoryMap = rewardCategoryMap;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("customerId", customerId)
                .append("rewardCategoryMap", rewardCategoryMap)
                .toString();
    }
}
