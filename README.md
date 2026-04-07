# Personalized E-Learning Recommendation System

A production-ready backend system that delivers personalized course recommendations using Spring Boot + MySQL + Machine Learning (Flask).

# Overview

This project is a microservices-based architecture designed to:

Manage users, courses, and enrollments
Track learner interactions (clicks, views, ratings)
Generate personalized course recommendations
Integrate a Machine Learning model using collaborative filtering

# Architecture
[ Client / Postman ]
          ↓
[ Spring Boot Backend ]
          ↓ (REST API call)
[ Python ML Microservice ]
          ↓
[ MySQL Database ]  

# Tech Stack
Backend:
Java + Spring Boot
Spring Security (JWT Authentication)
Hibernate (JPA)
Database:
MySQL
ML Microservice:
Python
Flask
Scikit-learn (Collaborative Filtering)
DevOps:
Docker (for both services)  

# Features
Authentication & Authorization
User Registration & Login
JWT-based authentication
Role-based access:
LEARNER
INSTRUCTOR
ADMIN
# Course Management
Create, update, delete courses
Instructor-specific course ownership
Pagination support
# Enrollment System
Enroll users into courses
Track learning progress (percentage)
# User Interaction Tracking
Track:
Views
Clicks
Ratings
Stored for ML recommendations
# Recommendation Engine
Collaborative Filtering (User-User similarity)
Uses cosine similarity
Returns Top N recommended courses
# Microservice Integration
Spring Boot → Flask via REST API
Fallback mechanism if ML service fails
# Performance Optimizations
Indexed database queries
JPQL custom queries
Pagination for APIs
# Docker Support
Separate Dockerfiles for:
Backend
ML Service  

# Database Design
Tables:
users
roles
courses
enrollments
skills
user_skills
interactions
Key Relationships:
User ↔ Roles (Many-to-Many)
User ↔ Course (Enrollment)
User ↔ Interaction (Tracking behavior)
# API Endpoints
Auth
POST /auth/register
POST /auth/login
Courses
POST /courses
GET /courses?page=0&size=10
Enrollment
POST /enroll
Recommendations
GET /recommendations/{userId}
# Sample Request
Register User
{
  "username": "pooja",
  "email": "pooja@gmail.com",
  "password": "1234"
}
Recommendation Response
[101, 103, 104]
# Setup Instructions
1️⃣ Clone Repository
git clone https://github.com/your-username/personalized-elearning-system.git
cd personalized-elearning-system
2️⃣ Setup MySQL
CREATE DATABASE elearning;

Update credentials in:

backend-springboot/src/main/resources/application.yml
3️⃣ Run ML Microservice
cd ml-service
pip install -r requirements.txt
python app.py

Runs on:

http://localhost:5000
4️⃣ Run Spring Boot Backend
cd backend-springboot
mvn clean install
mvn spring-boot:run

Runs on:

http://localhost:8080
5️⃣ Test APIs
Use Postman collection inside /postman
Add JWT token for secured endpoints
# JWT Flow
User logs in
Server returns JWT token
Client sends token in header:
Authorization: Bearer <token>
Backend validates and authorizes request
# Testing
Basic unit tests included
Can be extended using:
JUnit
Mockito
# Future Enhancements
Redis caching for recommendations
Kafka for event streaming (user interactions)
CI/CD pipeline (GitHub Actions)
Kubernetes deployment
Advanced ML (Matrix Factorization / Deep Learning)
