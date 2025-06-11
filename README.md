# Employee Management System (EMS)

A modern, full stack Java web application for managing employees, built with **Spring Boot**, **Thymeleaf**, **Bootstrap**, **MySQL**, and **Docker**.  
This project demonstrates real-world Java full stack development, including authentication, role-based access, REST APIs, testing, and cloud-ready deployment.

---

## 🚀 Features

- **User Authentication:** Secure login with Admin/User roles
- **Employee Management:** Add, edit, delete, and list employees
- **Audit Logging:** Tracks who created/updated records and when
- **User Profile:** View and update your profile
- **Flash Messages:** User feedback for all actions
- **Responsive UI:** Modern Bootstrap 5 design, mobile-friendly
- **REST API Documentation:** Integrated Swagger/OpenAPI UI
- **Testing:** Unit and integration tests with JUnit & Mockito
- **Dockerized:** Easy to run anywhere, cloud-ready

---

## 🛠️ Tech Stack

- **Backend:** Spring Boot, Spring Security, Spring Data JPA
- **Frontend:** Thymeleaf, Bootstrap 5
- **Database:** MySQL 8
- **Testing:** JUnit 5, Mockito
- **API Docs:** Swagger (OpenAPI)
- **Deployment:** Docker, Docker Compose, Render.com

---

## 📸 Screenshots

> _Add screenshots below: login page, employee list, add/edit form, profile, Swagger UI, etc._
> ![image](https://github.com/user-attachments/assets/f63bdb80-87b5-4184-ad7a-1b1c9db60c0d)
> ![{1C4980B0-29B5-4E54-8744-5EAE85AEAF2A}](https://github.com/user-attachments/assets/a935eb54-5a7b-4899-8c34-46a16619560d)
> ![{40563B33-8C9A-4710-988F-F221C43452E1}](https://github.com/user-attachments/assets/9758c88d-9962-4c3c-a4f0-5bda08725e9e)




---

## ⚙️ Local Setup

### 1. Clone the repository

```sh
git clone https://github.com/yourusername/javaems.git
cd javaems
```

### 2. Configure MySQL

- Make sure MySQL 8 is running locally.
- Create a database named `javaems`.
- Update `src/main/resources/application.properties` if needed.

### 3. Build and Run with Docker

```sh
mvn clean package
docker-compose up --build
```

- App: [http://localhost:8080](http://localhost:8080)
- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### 4. Default Admin/User

> _Add default credentials here if you have them, or instructions to register._

---

## 🌐 Cloud Deployment

### **Deploy on Render.com**

1. Push your code to GitHub.
2. Create a new Web Service on [Render.com](https://render.com/).
3. Connect your repo and deploy using Docker (see `docker-compose.yml`).
4. (Optional) Add a managed MySQL database and set environment variables:
    - `SPRING_DATASOURCE_URL`
    - `SPRING_DATASOURCE_USERNAME`
    - `SPRING_DATASOURCE_PASSWORD`
5. Access your app via the public Render URL.

---

## 🧪 Testing

- Run all tests:
  ```sh
  mvn test
  ```
- Includes unit and integration tests for services and controllers.

---

## 📄 License

This project is for educational and demonstration purposes.

---

## 🙋‍♂️ Author

- **Your Name**
- [LinkedIn](https://www.linkedin.com/in/yourprofile)
- [GitHub](https://github.com/yourusername)

---

**⭐️ Star this repo if you found it useful! Feel free to fork or reach out for collaboration.**
