package com.vitacard.rewardsvc.domain.service;

import com.vitacard.rewardsvc.domain.aggregate.RewardProgram;
import com.vitacard.rewardsvc.domain.aggregate.RewardProgramFactory;
import com.vitacard.rewardsvc.domain.dao.rewardprogram.RewardProgramDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RewardProgramService {
    @Autowired
    private RewardProgramDao rewardProgramDao;
    @Autowired
    private RewardProgramFactory rewardProgramFactory;

    public List<String> createRewardPrograms(long customerId, Map<String, Set<String>> rewardCategoryMap) {
        List<String> rewardProgramIds = new ArrayList<>();
        for (String rewardCategory1Id: rewardCategoryMap.keySet()) {
            RewardProgram rewardProgram =
                    rewardProgramFactory.construct(customerId, rewardCategory1Id, rewardCategoryMap.get(rewardCategory1Id));
            String rewardProgramId = addRewardProgram(rewardProgram);
            rewardProgramIds.add(rewardProgramId);
        }
        return rewardProgramIds;
    }

    @Transactional
    public String addRewardProgram(RewardProgram rewardProgram) {
        RewardProgram addedRewardProgram = rewardProgramDao.addRewardProgram(rewardProgram);
        return addedRewardProgram.getId();
    }
}
