# AI Commit Message Generator

A Spring Boot REST API that analyzes Git diff text and generates Conventional Commit messages using OpenAI (Spring AI).

## Architecture

```
Client → CommitController → CommitGenerationService → OpenAI (GPT)
                              ↑
                        ChatClient (Spring AI)
```

- CommitController — REST endpoint accepting git diff input
- CommitGenerationService — uses Spring AI "ChatClient" to call OpenAI
- ChatClient — prompt-based LLM interaction

## How It Works

1. You make code changes in your project
2. Run `git diff` to get the raw diff of your changes
3. Send that diff to this API
4. OpenAI analyzes the actual code changes (added/removed lines)
5. Returns a Conventional Commit message

## API Example

Suppose you added a login method. First, run in your terminal:

```bash
git diff
```

Output (this is what you'd copy):
```diff
diff --git a/src/AuthService.java b/src/AuthService.java
+public String login(String username, String password) {
+    String token = JWT.create()
+        .withSubject(username)
+        .sign(Algorithm.HMAC256("secret"));
+    return token;
+}
```

### Request

Send that diff to the API:

```
POST /api/commit/generate
Content-Type: application/json

{
  "gitDiff": "diff --git a/src/AuthService.java b/src/AuthService.java\n+public String login(String username, String password) {\n+    String token = JWT.create()\n+        .withSubject(username)\n+        .sign(Algorithm.HMAC256(\"secret\"));\n+    return token;\n+}"
}
```

### Response

```json
{
  "commitMessage": "feat(auth): add JWT login with token generation"
}
```

## Technologies Used

- Java 21
- Spring Boot 3.x
- Spring AI (OpenAI)
- Maven
- Lombok
- SpringDoc OpenAPI (Swagger UI)
- Jakarta Validation

## How to Run

1. Set your OpenAI API key:
   ```bash
   export OPENAI_API_KEY=sk-your-key-here
   ```

2. Build and run
   ```bash
   ./mvnw spring-boot:run
   ```

3. Access Swagger UI: http://localhost:8080/swagger-ui.html

4. Test the endpoint using Swagger UI or any HTTP client.

### Prerequisites

- Java 21+
- Maven 3.9+
- OpenAI API key with access to GPT models
