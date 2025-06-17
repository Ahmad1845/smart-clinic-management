
# 📘 MySQL Database Schema Design for Smart Clinic Management System

## 🔹 1. Table: `doctors`

| Column Name      | Data Type     | Constraints              |
|------------------|---------------|--------------------------|
| doctor_id        | INT           | PRIMARY KEY, AUTO_INCREMENT |
| name             | VARCHAR(100)  | NOT NULL                 |
| email            | VARCHAR(100)  | UNIQUE, NOT NULL         |
| specialization   | VARCHAR(100)  | NOT NULL                 |
| available_times  | TEXT          |                          |

---

## 🔹 2. Table: `patients`

| Column Name     | Data Type     | Constraints              |
|-----------------|---------------|--------------------------|
| patient_id      | INT           | PRIMARY KEY, AUTO_INCREMENT |
| name            | VARCHAR(100)  | NOT NULL                 |
| email           | VARCHAR(100)  | UNIQUE, NOT NULL         |
| phone_number    | VARCHAR(15)   |                          |
| password        | VARCHAR(100)  | NOT NULL                 |

---

## 🔹 3. Table: `appointments`

| Column Name      | Data Type     | Constraints                    |
|------------------|---------------|--------------------------------|
| appointment_id   | INT           | PRIMARY KEY, AUTO_INCREMENT    |
| doctor_id        | INT           | FOREIGN KEY → `doctors(doctor_id)` |
| patient_id       | INT           | FOREIGN KEY → `patients(patient_id)` |
| appointment_time | DATETIME      | NOT NULL                       |
| status           | VARCHAR(50)   | DEFAULT 'Scheduled'            |

---

## 🔹 4. Table: `prescriptions`

| Column Name     | Data Type     | Constraints                    |
|-----------------|---------------|--------------------------------|
| prescription_id | INT           | PRIMARY KEY, AUTO_INCREMENT    |
| appointment_id  | INT           | FOREIGN KEY → `appointments(appointment_id)` |
| medicine_list   | TEXT          | NOT NULL                       |
| notes           | TEXT          |                                |

---

## 🔗 Relationships:
- A doctor can have **many appointments**.
- A patient can have **many appointments**.
- An appointment can have **one prescription**.

