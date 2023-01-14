package com.vitacard.rewardsvc.domain.aggregate;

import com.vitacard.rewardsvc.domain.dao.rewardcategory2.RewardCategory2Dao;
import com.vitacard.rewardsvc.domain.entity.RewardCategory2;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RewardProgram {
    private String id;
    private long customerId;
    private String description;
    private int progress;
    private int statusCode;
    private String rewardCategory1Id;

    private List<RewardCategory2> rewardCategory2s = new ArrayList<>();

    @Autowired
    private transient RewardCategory2Dao rewardCategory2Dao;

    public RewardProgram() {
    }

    public RewardProgram(long customerId, String rewardCategory1Id) {
        this.customerId = customerId;
        this.rewardCategory1Id = rewardCategory1Id;
        this.progress = 0;
    }

    public String getId() {
        return id;
    }

    public RewardProgram setId(String id) {
        this.id = id;
        return this;
    }

    public long getCustomerId() {
        return customerId;
    }

    public RewardProgram setCustomerId(long customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RewardProgram setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getProgress() {
        return progress;
    }

    public RewardProgram setProgress(int progress) {
        this.progress = progress;
        return this;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public RewardProgram setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getRewardCategory1Id() {
        return rewardCategory1Id;
    }

    public RewardProgram setRewardCategory1Id(String rewardCategory1Id) {
        this.rewardCategory1Id = rewardCategory1Id;
        return this;
    }

    public List<RewardCategory2> getRewardCategory2s() {
        return rewardCategory2s;
    }

    public RewardProgram setRewardCategory2s(List<RewardCategory2> rewardCategory2s) {
        this.rewardCategory2s = rewardCategory2s;
        return this;
    }

    public void addRewardCategory2s(Set<String> rewardCategory2Ids) {
        Set<RewardCategory2> rewardCategory2s = new HashSet<>();
        for (String rewardCategory2Id: rewardCategory2Ids) {
            RewardCategory2 rewardCategory2 = rewardCategory2Dao.getRewardCategory2ById(rewardCategory2Id);
            rewardCategory2s.add(rewardCategory2);
        }
        this.rewardCategory2s.addAll(rewardCategory2s);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("customerId", customerId)
                .append("description", description)
                .append("progress", progress)
                .append("statusCode", statusCode)
                .append("rewardCategory1Id", rewardCategory1Id)
                .append("rewardCategory2s", rewardCategory2s)
                .toString();
    }
}
