package com.vitacard.rewardsvc.domain.dao.rewardprogram;

import com.vitacard.rewardsvc.domain.aggregate.RewardProgram;

public interface RewardProgramDao {
    RewardProgram addRewardProgram(RewardProgram rewardProgram);
    RewardProgram getRewardProgramById(String id);
}
