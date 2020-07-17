package com.challenge.endpoints;

import com.challenge.entity.Candidate;
import com.challenge.entity.Challenge;
import com.challenge.service.impl.CandidateService;
import com.challenge.service.impl.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    ChallengeService challengeService;

    @GetMapping()
    public List<Challenge> findByAccelerationIdAndUserId(@PathParam("accelerationId") Long accelerationId, @PathParam("userId") Long userId) {
        return this.challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
    }


}
