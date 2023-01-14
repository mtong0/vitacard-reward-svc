package com.vitacard.rewardsvc;

import com.vitacard.rewardsvc.domain.aggregate.RewardProgram;
import com.vitacard.rewardsvc.domain.entity.RewardCategory2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestData {
    public static RewardProgram getNewRewardProgram() {
        return new RewardProgram()
                .setId(String.valueOf(UUID.randomUUID()))
                .setCustomerId(123456)
                .setProgress(0)
                .setStatusCode(0)
                .setRewardCategory1Id("001");
    }

    public static List<RewardCategory2> getRewardCategory2sByRewardCategory1Id(String rewardCategory1Id) {
        RewardCategory2 rewardCategory2One = new RewardCategory2()
                .setCategory("test reward category 2-1")
                .setDescription("test reward category 2-1")
                .setId("001001")
                .setCategory1Id(rewardCategory1Id);
        RewardCategory2 rewardCategory2Two = new RewardCategory2()
                .setCategory("test reward category 2-2")
                .setDescription("test reward category 2-2")
                .setId("001002")
                .setCategory1Id(rewardCategory1Id);

        List<RewardCategory2> rewardCategory2s = new ArrayList<>();
        rewardCategory2s.add(rewardCategory2One);
        rewardCategory2s.add(rewardCategory2Two);
        return rewardCategory2s;
    }
}
