# Casino Back-End System
The Casino Back-End System is a Java-based application built with Spring Boot to provide the necessary infrastructure and functionality for a casino start-up. It integrates with a game provider, Dagacube, and handles player balances, transactions, and support-related features.

### Features
* Integration with Dagacube game provider
* Player balance management
* Transaction handling
* Last 10 wager/win transactions retrieval
* Basic authentication and authorization (optional)

### Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* H2 Database

## Getting Started

To run the Casino Back-End System locally, follow these steps:

1 . Clone the repository: git clone https://github.com/siyamtanda/Rank-Casino-Game

1 Open the project in your preferred Java IDE.

2 Build the project using Gradle: ./gradlew clean build

1 Run the application: ./gradlew bootRun

The application will start running on `http://localhost:8080`.

## Configuration

* Database configuration (H2): The application is preconfigured to use an H2 in-memory database. The database schema and tables will be automatically created when the application starts. The database connection settings can be modified in the application.properties or application.yml file.

* Authentication and Authorization (optional): Authentication and authorization mechanisms can be configured in the SecurityConfig.java class. User roles and permissions can be defined to restrict access to specific endpoints.

### Testing

The application includes unit tests to validate the functionality of the controllers, services, and repositories. The tests cover various scenarios, including valid and invalid requests, edge cases, and concurrent transactions. To run the tests, use the following command:

./gradlew test

### Contributions

Contributions to the Casino Back-End System are welcome! If you find any issues or want to suggest improvements, feel free to open an issue or submit a pull request.

## License

This project is licensed under the **MIT License**.

You can customize this README file based on your specific project requirements, including any additional sections or information you want to include. Provide instructions on how to set up the project, configure dependencies, run tests, and contribute to the project.
