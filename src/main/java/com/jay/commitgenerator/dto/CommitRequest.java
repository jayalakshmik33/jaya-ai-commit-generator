package com.jay.commitgenerator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request containing the git diff to analyze")
public class CommitRequest {

    @NotBlank(message = "gitDiff must not be blank")
    @Schema(description = "Git diff text to analyze", example = "Added JWT authentication and login validation")
    private String gitDiff;
}
