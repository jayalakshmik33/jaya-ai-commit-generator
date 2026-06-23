package com.jay.commitgenerator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response containing the generated commit message")
public class CommitResponse {

    @Schema(description = "Generated Conventional Commit message", example = "feat(auth): add JWT authentication")
    private String commitMessage;
}
