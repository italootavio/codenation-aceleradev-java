package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {
    @Autowired
    SubmissionService submissionService;

    @Autowired
    SubmissionMapper submissionMapper;

    @GetMapping
    ResponseEntity<List<SubmissionDTO>> getSubmissionByChallengeIdAndAccelerationId(
            @RequestParam(name = "challengeId") Long challengeId,
            @RequestParam(name = "accelerationId") Long accelerationId){
        return ResponseEntity.ok(submissionMapper.map(
                this.submissionService.findByChallengeIdAndAccelerationId(
                        challengeId,accelerationId)));
    }
}
