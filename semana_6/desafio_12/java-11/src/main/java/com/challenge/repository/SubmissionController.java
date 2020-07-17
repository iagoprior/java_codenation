package com.challenge.repository;


import com.challenge.entity.Submission;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    SubmissionService submissionService;

    @GetMapping
    public List<Submission> findByChallengeIdAndAccelerationId(@PathParam("challengeId") Long challengeId, @PathParam("accelerationId") Long accelerationId) {
        return this.submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);

    }
}
