package com.vitacard.rewardsvc.domain.dao.rewardcategory2;

import com.vitacard.rewardsvc.domain.entity.RewardCategory2;

import java.util.List;

public interface RewardCategory2Dao {
    List<RewardCategory2> getRewardCategory2sByRewardCategory1Id(String rewardCategory1Id);
    List<RewardCategory2> getRewardCategory2sByRewardProgramId(String rewardProgramId);
    RewardCategory2 getRewardCategory2ById(String id);
}
