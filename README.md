# Hospital project

## Description
This project is a hospital management application developed in Java, using the Spring Boot framework and JPA (Java Persistence API). It allows the management of patients, doctors, consultations, and appointments within a healthcare facility.

## Project Structure
- **Entities**: This directory contains the Java classes that represent the business entities of the application, such as Patient, Doctor, Consultation, and Appointment.
- **Repositories**: This directory contains the interfaces that define basic methods to interact with the database for each entity. These interfaces are implemented by Spring Data JPA.
- **Web**: This directory contains the patients controllers to manage all the functions of the class 

## Features
- Registration of patients with their personal information.
- Registration of doctors with their specialties.
- Programming and tracking of medical consultations.
- Management of appointments between patients and doctors.

## Installation
1. Make sure you have Java JDK installed on your system.
2. Clone this GitHub repository to your local machine.
3. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
4. Ensure you have Maven installed to manage the project dependencies.
5. Run the `HospitalApplication` class to start the application.

## Usage
Once the application is started, you can access the features via a user interface or by manipulating the data directly in the code. The entities are automatically persisted in the database using JPA.

## Development
This project uses Spring Boot to manage the application architecture and facilitate development. JPA is used for the persistence layer to interact with the relational database. The main classes to modify are located in the `entities` and `repositories` packages.
