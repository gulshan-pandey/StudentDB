# StudentDB-Manager

**StudentDB-Manager** is a Java-based application designed to manage student-related data. It provides functionalities to perform CRUD (Create, Read, Update, Delete) operations on a student database. The application uses JDBC for database connectivity and can be easily integrated with MySQL or other relational databases.

## Features

- **Add New Students:** Add student details like name, age, gender, and course.
- **Update Student Information:** Modify existing student records.
- **Delete Students:** Remove student records from the database.
- **View Student Details:** Retrieve and display all student records from the database.
- **Batch Insertion:** Efficiently insert multiple student records at once using batch processing.

## Technologies Used

- **Java**
- **JDBC**
- **MySQL** (or any other relational database)
- **Maven** (for dependency management)

## Getting Started

### Prerequisites

- Java 8 or higher
- MySQL or any other relational database
- Maven

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/gulshan-pandey/StudentDB-Manager.git
   cd StudentDB-Manager
   ```

2. **Set up the database:**

   - Create a MySQL database named `studentdb`.
   - Execute the SQL scripts provided in the `scripts/` directory to create the required tables.

3. **Configure the database connection:**

   - Update the `DBConnection.java` file with your MySQL database credentials.

4. **Build the project:**

   ```bash
   mvn clean install
   ```

5. **Run the application:**

   ```bash
   java -jar target/StudentDB-Manager-1.0.jar
   ```

## Usage

- The application starts in a command-line interface.
- Follow the on-screen prompts to add, update, delete, or view student records.

## Contributing

Contributions are welcome! Please fork this repository and create a pull request with your changes. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---
