# AI Email Generator API (Spring Boot)

This project is a REST API that generates professional emails using an AI model based on user input such as purpose, recipient name, and tone.  
It is built using Spring Boot and integrated with an external AI API (Gemini/OpenAI compatible).

--------------------------------------------------

## 🚀 Features
- Generate AI-based professional emails  
- Accepts dynamic input:
  - purpose  
  - recipient name  
  - tone (formal, friendly, professional)  
- Returns generated email text  
- Measures AI API response time  
- Clean layered architecture  
  Controller → Service → DTO  

--------------------------------------------------

## 🛠 Tech Stack
- Java  
- Spring Boot  
- Maven  
- RestTemplate  
- External AI API (Gemini/OpenAI compatible)  
- Postman (testing)

--------------------------------------------------

## 📂 Project Structure
src/main/java/com/app

controller  
 └── EmailController.java  

service  
 └── EmailService.java  

dto  
 ├── EmailRequest.java  
 └── EmailResponse.java  

AiEmailGeneratorApplication.java  

--------------------------------------------------

## 📥 API Endpoint

POST /api/email/generate  
Generates an email using AI.

### Request Body
{
  "purpose": "schedule meeting",
  "recipient_name": "Rahul",
  "tone": "formal"
}

### Sample Response
{
  "responseTimeMs": 3276,
  "email": "Subject: Project Meeting Schedule\n\nDear Rahul,\n\nI hope this email finds you well.\n\nI would like to schedule a meeting to discuss our current project. Please let me know your availability over the next few days.\n\nRegards,\n\n[Your Name]"
}

--------------------------------------------------
<img width="1383" height="757" alt="Screenshot 2026-02-18 001654" src="https://github.com/user-attachments/assets/3800d203-7907-4f83-a9ed-ee37b65ee241" />


## 🧠 AI Prompt Design

The AI prompt is dynamically created using user input.

Example prompt sent to AI:

Write an email.  
Purpose: schedule meeting  
Recipient Name: Rahul  
Tone: formal  
Generate a complete email with subject and body.

This ensures the AI generates structured business emails based on context and tone.

--------------------------------------------------

## ⏱ Response Time Calculation

The system measures how long the AI API takes to respond.

long start = System.currentTimeMillis();  
long end = System.currentTimeMillis();  
responseTime = end - start;  

This value is returned in the API response.

--------------------------------------------------

## ⚙️ Configuration

Add your AI API key in:

src/main/resources/application.properties

ai.api.key=YOUR_API_KEY

The AI API URL is configured inside the service layer.

--------------------------------------------------

## ▶️ How to Run the Project

1. Clone repository  
git clone https://github.com/sachinpawar14/ai-email-generator.git  

2. Open in Eclipse or IntelliJ  

3. Add API key in application.properties  

4. Run Spring Boot application  

5. Test using Postman  
POST http://localhost:8080/api/email/generate  

--------------------------------------------------

## 🧪 Testing Using Postman

Method: POST  
URL: http://localhost:8080/api/email/generate  

Body → JSON:
{
  "purpose": "leave request",
  "recipient_name": "Manager",
  "tone": "formal"
}

--------------------------------------------------

## 👨‍💻 Author
Sachin Pawar  
Java Backend Developer  
Spring Boot | React | SQL
