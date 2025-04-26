
# 💬 ChatnHeal Backend

A powerful emotional wellness backend built with **Spring Boot**, integrating:
- GPT-powered AI Companion Chat
- Mood Tracker & Journaling
- AstroMatch (Zodiac-based matching)
- Real Listener/Coach Booking System
- Firebase Authentication (JWT)
- MongoDB + PostgreSQL hybrid storage
- Clean Swagger API docs, JUnit tests, and environment profiles

---

## 🧱 Tech Stack

- **Java 17** + **Spring Boot 3**
- **MongoDB**: GPT chats, journals, mood logs
- **PostgreSQL**: Structured user/coach data
- **OpenAI GPT-4 API**
- **Firebase Authentication**
- **Swagger**: API docs (`/swagger-ui.html`)
- **JUnit 5 + Mockito**: Tests
- **Profiles**: `dev` and `prod` ready

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 17+
- Maven
- MongoDB & PostgreSQL running locally
- Firebase project with Auth enabled
- Firebase Admin SDK JSON file
- OpenAI API Key

---

## 🔧 Environment Configuration

### 📄 `application.properties`
```properties
spring.profiles.active=dev
```

### 📄 `application-dev.properties`
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/chatnheal
spring.datasource.url=jdbc:postgresql://localhost:5432/chatnheal
spring.datasource.username=postgres
spring.datasource.password=your_password

openai.api.key=sk-xxxx...
firebase.service.account.path=classpath:firebase-service-account.json
```

> 🔐 Place your Firebase service account JSON in:
```
src/main/resources/firebase-service-account.json
```

---

## 📡 Running the Application

```bash
mvn clean install
mvn spring-boot:run
```

Access:
- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- API Base URL: `http://localhost:8080`

---

## 🔐 Authentication

All endpoints are secured via **Firebase JWT**.  
Clients must send this header:

```http
Authorization: Bearer <firebase_id_token>
```

Spring filter automatically extracts and injects:
```java
String userId = (String) request.getAttribute("uid");
```

---

## 📦 Key API Endpoints

### 🔹 Chat
- `POST /chat/send` → Chat with GPT persona

### 🔹 Mood
- `POST /mood/today` → Save today's mood
- `GET /mood/history` → Get mood history

### 🔹 Journal
- `POST /journal/write` → Save journal
- `GET /journal/all` → View past journals

### 🔹 AstroMatch
- `POST /astro/profile` → Get Zodiac & AI matches

### 🔹 Coaches
- `GET /coach/list` → List all available listeners
- `POST /coach/book` → Book a session
- `GET /coach/my-bookings` → View bookings

---

## 🧪 Testing

Run all unit tests:
```bash
mvn test
```

- Test coverage includes:
  - Services (Chat, Mood, Journal, Astro, Booking)
  - Controllers via MockMvc
  - Firebase filter handling

---

## ✨ Project Structure
```
com.chatnheal
├── controller/
├── service/
├── repository/
├── entity/
├── dto/ (grouped per module)
├── config/ (Firebase, Filters)
└── util/ (Zodiac logic, etc.)
```

---

## ⚙️ Deployment

- Use **Render**, **Railway**, or **EC2** for Spring Boot backend
- Connect your frontend via REST with Bearer Token Auth
- `spring.profiles.active=prod` for production environment

---

## 🛡️ Security

- Firebase JWT validation via filter
- All routes protected — no public routes except root

---

## 🧠 Future Enhancements

- Razorpay integration for paid coach booking
- AI companion customization (voice, memory)
- Admin dashboard for managing coaches and content
- Email notifications & appointment reminders

---

## 👨‍💻 Maintained By
**CodeVerse AI**  
[https://github.com/codeverse-ai](https://github.com/codeverse-ai)

---

## 📄 License

This project is open-source and under the [MIT License](LICENSE).
