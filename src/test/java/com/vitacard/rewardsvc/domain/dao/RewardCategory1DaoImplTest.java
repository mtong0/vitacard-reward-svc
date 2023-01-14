package com.vitacard.rewardsvc.domain.dao;

import com.vitacard.rewardsvc.domain.dao.rewardcategory1.RewardCategory1DaoImpl;
import com.vitacard.rewardsvc.domain.entity.RewardCategory1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RewardCategory1DaoImplTest {
    @Autowired
    private RewardCategory1DaoImpl subject1Dao;

    @Test
    @Transactional
    public void testAddFieldCategory1() {
        RewardCategory1 rewardCategory1 = new RewardCategory1()
                .setId("123456")
                .setCategory("Category 1 Value")
                .setDescription("This is a test field category 1");

        subject1Dao.addRewardCategory1(rewardCategory1);
        RewardCategory1 savedRewardCategory1 = subject1Dao.getRewardCategory1ById("123456");

        assertEquals(rewardCategory1, savedRewardCategory1);
    }

    @Test
    @Transactional
    public void getAllRewardCategory1() {
        int originalSize = subject1Dao.getAllRewardCategory1s().size();
        RewardCategory1 rewardCategory1 = new RewardCategory1()
                .setId("123456")
                .setCategory("Category 1 Value")
                .setDescription("This is a test field category 1");

        subject1Dao.addRewardCategory1(rewardCategory1);
        int updatedSize =  subject1Dao.getAllRewardCategory1s().size();
        assertEquals(originalSize + 1, updatedSize);
    }
}
