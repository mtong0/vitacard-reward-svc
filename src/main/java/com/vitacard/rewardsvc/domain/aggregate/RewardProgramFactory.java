package com.vitacard.rewardsvc.domain.aggregate;

import com.vitacard.rewardsvc.domain.dao.rewardcategory2.RewardCategory2Dao;
import com.vitacard.rewardsvc.domain.dao.rewardprogram.RewardProgramDao;
import com.vitacard.rewardsvc.domain.entity.RewardCategory2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RewardProgramFactory {
    @Autowired
    private RewardProgramDao rewardProgramDao;
    @Autowired
    private RewardCategory2Dao rewardCategory2Dao;
    public RewardProgram construct(long customerId, String rewardCategory1Id, Set<String> rewardCategory2Ids) {
        List<RewardCategory2> rewardCategory2s = new ArrayList<>();
        for (String rewardCategory2Id: rewardCategory2Ids) {
            RewardCategory2 rewardCategory2 = rewardCategory2Dao.getRewardCategory2ById(rewardCategory2Id);
            rewardCategory2s.add(rewardCategory2);
        }
        return new RewardProgram()
                .setId(UUID.randomUUID().toString())
                .setCustomerId(customerId)
                .setRewardCategory1Id(rewardCategory1Id)
                .setRewardCategory2s(rewardCategory2s);
    }
}
