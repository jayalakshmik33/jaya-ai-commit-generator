package com.jay.commitgenerator.controller;

import com.jay.commitgenerator.dto.CommitRequest;
import com.jay.commitgenerator.dto.CommitResponse;
import com.jay.commitgenerator.service.CommitGenerationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/commit")
@Tag(name = "Commit Generator", description = "Generate Conventional Commit messages from git diff")
public class CommitController {

    private final CommitGenerationService commitGenerationService;

    public CommitController(CommitGenerationService commitGenerationService) {
        this.commitGenerationService = commitGenerationService;
    }

    @PostMapping("/generate")
    @Operation(summary = "Generate commit message", description = "Analyzes git diff and returns a Conventional Commit message")
    public ResponseEntity<CommitResponse> generateCommit(@Valid @RequestBody CommitRequest request) {
        String commitMessage = commitGenerationService.generateCommitMessage(request.getGitDiff());
        return ResponseEntity.ok(new CommitResponse(commitMessage));
    }
}
