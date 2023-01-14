package com.vitacard.rewardsvc.domain.service;

import com.vitacard.rewardsvc.domain.dao.rewardcategory1.RewardCategory1DaoImpl;
import com.vitacard.rewardsvc.domain.dao.rewardcategory2.RewardCategory2DaoImpl;
import com.vitacard.rewardsvc.domain.entity.RewardCategory1;
import com.vitacard.rewardsvc.domain.entity.RewardCategory2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardCategoryService {
    @Autowired
    private RewardCategory1DaoImpl rewardCategory1Dao;
    @Autowired
    private RewardCategory2DaoImpl rewardCategory2Dao;

    public List<RewardCategory1> getAllRewardCategory1s() {
        return rewardCategory1Dao.getAllRewardCategory1s();
    }

    public List<RewardCategory2> getRewardCategory2sByRewardCategoryId(String rewardCategory1Id) {
        return rewardCategory2Dao.getRewardCategory2sByRewardCategory1Id(rewardCategory1Id);
    }
}
