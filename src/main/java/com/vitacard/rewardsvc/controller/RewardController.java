package com.vitacard.rewardsvc.controller;

import com.vitacard.rewardsvc.domain.dto.CreateRewardProgramsRequest;
import com.vitacard.rewardsvc.domain.entity.RewardCategory1;
import com.vitacard.rewardsvc.domain.entity.RewardCategory2;
import com.vitacard.rewardsvc.domain.service.RewardCategoryService;
import com.vitacard.rewardsvc.domain.service.RewardProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/reward")
public class RewardController {
    @Autowired
    private RewardCategoryService rewardCategoryService;
    @Autowired
    private RewardProgramService rewardProgramService;

    @GetMapping("/reward-category1s")
    public ResponseEntity<List<RewardCategory1>> getAllFieldCategory1s() {
        return new ResponseEntity<>(rewardCategoryService.getAllRewardCategory1s(), HttpStatus.OK);
    }

    @GetMapping("/reward-category2s-by-reward-category1-id/{id}")
    public ResponseEntity<List<RewardCategory2>> getRewardCategory2ByRewardCategory1Id(@PathVariable String id) {
        return new ResponseEntity<>(rewardCategoryService.getRewardCategory2sByRewardCategoryId(id), HttpStatus.OK);
    }

    @PostMapping("/reward-programs")
    @ExceptionHandler
    public ResponseEntity<Void> createRewardPrograms(@RequestBody CreateRewardProgramsRequest createRewardProgramsRequest) {
        System.out.println(createRewardProgramsRequest);
        long customerId = createRewardProgramsRequest.getCustomerId();
        Map<String, Set<String>> rewardCategoryMap = createRewardProgramsRequest.getRewardCategoryMap();
        List<String> rewardProgramIds = rewardProgramService.createRewardPrograms(customerId, rewardCategoryMap);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
