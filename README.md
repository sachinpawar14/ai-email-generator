# AI Email Generator API (Spring Boot)

This project is a REST API that generates professional emails using an AI model based on user input such as purpose, recipient name, and tone.  
It was built using Spring Boot and external AI API integration.

---

## 🚀 Features

- Generate AI-based professional emails
- Accepts dynamic input:
  - purpose
  - recipient name
  - tone (formal, friendly, professional)
- Returns generated email text
- Measures API response time
- Clean layered architecture (Controller → Service → DTO)

---

## 🛠 Tech Stack

- Java
- Spring Boot
- Maven
- RestTemplate
- External AI API (Gemini/OpenAI compatible)
- Postman (testing)

---

## 📂 Project Structure

rc/main/java/com/app
│
├── controller
│ └── EmailController.java
│
├── service
│ └── EmailService.java
│
├── dto
│ ├── EmailRequest.java
│ └── EmailResponse.java
│
└── AiEmailGeneratorApplication.java

---

## 📥 API Endpoint

### POST `/api/email/generate`

Generates an email using AI.

### Request Body

```json
{
  "purpose": "schedule meeting",
  "recipient_name": "Rahul",
  "tone": "formal"
}
Sample Response
{
  "responseTimeMs": 3276,
  "email": "Subject: Project Meeting Schedule\n\nDear Rahul,\n\nI hope this email finds you well.\n\nI would like to schedule a meeting to discuss our current project. Please let me know your availability over the next few days.\n\nRegards,\n\n[Your Name]"
}
```
![Screenshot 2026-02-18 001658](https://github.com/user-attachments/assets/23f90b70-d816-4d92-9e03-83fa10457c55)

🧠 AI Prompt Design

The AI prompt is dynamically created using user input.

Example prompt sent to AI:
Write an email.
Purpose: schedule meeting  
Recipient Name: Rahul  
Tone: formal  
Generate a complete email with subject and body.

This ensures the AI generates structured business emails based on context and tone.

⏱ Response Time Calculation

The system measures how long the AI API takes to respond.
long start = System.currentTimeMillis();
long end = System.currentTimeMillis();
responseTime = end - start;
This value is returned in API response.


⚙️ Configuration

Add your AI API key in:

src/main/resources/application.properties
ai.api.key=YOUR_API_KEY
Example (Gemini):
ai.api.url=https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent
ai.api.key=YOUR_KEY

▶️ How to Run Project

1.Clone repository
git clone https://github.com/sachinpawar14/ai-email-generator.git
2.Open in Eclipse
3.Add API key in application.properties
4.Run Spring Boot application
5.Test using Postman
 POST request: http://localhost:8080/api/email/generate

🧪 Testing Using Postman

Method: POST
URL: http://localhost:8080/api/email/generate
Body → JSON:
{
  "purpose": "leave request",
  "recipient_name": "Manager",
  "tone": "formal"
}



👨‍💻 Author
Sachin Pawar
Java Backend Developer
Spring Boot | React | SQL
