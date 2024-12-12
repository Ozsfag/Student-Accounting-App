# Student Management System

A simple console application for managing student records using Spring Shell.

## Features

- Add new students
- List all students
- Delete students by ID
- Clear all students
- Event listeners for student creation and deletion
- Optional initialization of test data at startup

## Commands

- `add --first-name <firstName> --last-name <lastName> --age <age>`
- `list`
- `delete --id <id>`
- `clear`

## Configuration

The application can be configured through `application.yml`:

- `app.init-students`: Set to `true` to initialize test data at startup (default: true)

## Running the Application

### Docker:
- `$./gradlew bootJar`
- `docker build -t student-management .`
- `docker run -it student-management`