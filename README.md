# AI Commit Message Generator

A Spring Boot REST API that analyzes Git diff text and generates Conventional Commit messages using OpenAI (Spring AI).

## Architecture

```
Client → CommitController → CommitGenerationService → OpenAI (GPT)
                              ↑
                        ChatClient (Spring AI)
```

- **CommitController** — REST endpoint accepting git diff input
- **CommitGenerationService** — uses Spring AI `ChatClient` to call OpenAI
- **ChatClient** — prompt-based LLM interaction

## API Example

### Request

```
POST /api/commit/generate
Content-Type: application/json

{
  "gitDiff": "Added JWT authentication and login validation"
}
```

### Response

```json
{
  "commitMessage": "feat(auth): add JWT authentication"
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

1. **Set your OpenAI API key**:
   ```bash
   export OPENAI_API_KEY=sk-your-key-here
   ```

2. **Build and run**:
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Access Swagger UI**: http://localhost:8080/swagger-ui.html

4. **Test the endpoint** using Swagger UI or any HTTP client.

### Prerequisites

- Java 21+
- Maven 3.9+
- OpenAI API key with access to GPT models
