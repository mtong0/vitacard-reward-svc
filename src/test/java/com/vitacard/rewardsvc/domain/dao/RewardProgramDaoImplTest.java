package com.vitacard.rewardsvc.domain.dao;

import com.vitacard.rewardsvc.domain.aggregate.RewardProgram;
import com.vitacard.rewardsvc.domain.dao.rewardprogram.RewardProgramDaoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RewardProgramDaoImplTest {

    @Autowired
    private RewardProgramDaoImpl rewardProgramDao;

    @Test
    public void testAddRewardProgram() {
        RewardProgram rewardProgram = new RewardProgram()
                .setId("1")
                .setCustomerId(1)
                .setDescription("Test reward program")
                .setProgress(50)
                .setStatusCode(1)
                .setRewardCategory1Id("001");

        RewardProgram addedRewardProgram = rewardProgramDao.addRewardProgram(rewardProgram);

        assertNotNull(addedRewardProgram);
        assertEquals(rewardProgram.getId(), addedRewardProgram.getId());
        assertEquals(rewardProgram.getCustomerId(), addedRewardProgram.getCustomerId());
        assertEquals(rewardProgram.getDescription(), addedRewardProgram.getDescription());
        assertEquals(rewardProgram.getProgress(), addedRewardProgram.getProgress());
        assertEquals(rewardProgram.getStatusCode(), addedRewardProgram.getStatusCode());
    }
}



