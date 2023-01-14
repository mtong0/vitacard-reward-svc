package com.vitacard.rewardsvc.domain.service;

import com.vitacard.rewardsvc.TestData;
import com.vitacard.rewardsvc.domain.aggregate.RewardProgram;
import com.vitacard.rewardsvc.domain.dao.rewardcategory2.RewardCategory2Dao;
import com.vitacard.rewardsvc.domain.dao.rewardprogram.RewardProgramDao;
import com.vitacard.rewardsvc.domain.entity.RewardCategory2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
class RewardProgramServiceTest {
    @Autowired
    private RewardProgramService rewardProgramService;
    @Autowired
    private RewardProgramDao rewardProgramDao;
    @Autowired
    private RewardCategory2Dao rewardCategory2Dao;

    private static String rewardCategory1Id = "001";
    @Test
    void createRewardPrograms() {
        long customerId = 123456;
        Map<String, Set<String>> rewardCategoryMap = new HashMap<>();
        List<RewardCategory2> rewardCategory2s = rewardCategory2Dao.getRewardCategory2sByRewardCategory1Id(rewardCategory1Id);
        Set<String> rewardCategory2Ids = rewardCategory2s.stream().map(RewardCategory2::getId).collect(Collectors.toSet());
        rewardCategoryMap.put(rewardCategory1Id, rewardCategory2Ids);
        List<String> rewardProgramIds = rewardProgramService.createRewardPrograms(customerId, rewardCategoryMap);

        String addedRewardProgramId = rewardProgramIds.get(0);
        RewardProgram addedRewardProgram = rewardProgramDao.getRewardProgramById(addedRewardProgramId);
        Assertions.assertEquals(rewardCategory2s.size(), addedRewardProgram.getRewardCategory2s().size());
    }

    @Test
    void createRewardProgram() {
    }
}