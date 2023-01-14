package com.vitacard.rewardsvc.domain.dao.rewardcategory1;

import com.vitacard.rewardsvc.domain.entity.RewardCategory1;

import java.util.List;

public interface RewardCategory1Dao {
    RewardCategory1 addRewardCategory1(RewardCategory1 rewardCategory1);
    RewardCategory1 getRewardCategory1ById(String id);
    List<RewardCategory1> getAllRewardCategory1s();
}
