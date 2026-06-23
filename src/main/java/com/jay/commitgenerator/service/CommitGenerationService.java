package com.jay.commitgenerator.service;

import com.jay.commitgenerator.exception.CommitGenerationException;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class CommitGenerationService {

    private static final String SYSTEM_PROMPT = """
            You are an expert software engineer.
            Analyze the provided git diff.
            Generate one Conventional Commit message.
            Allowed types: feat, fix, refactor, docs, test, chore.
            Return only the commit message.
            """;

    private final ChatClient chatClient;

    public CommitGenerationService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String generateCommitMessage(String gitDiff) {
        try {
            return chatClient.prompt()
                    .system(SYSTEM_PROMPT)
                    .user(gitDiff)
                    .call()
                    .content();
        } catch (Exception e) {
            throw new CommitGenerationException("Failed to generate commit message: " + e.getMessage(), e);
        }
    }
}
