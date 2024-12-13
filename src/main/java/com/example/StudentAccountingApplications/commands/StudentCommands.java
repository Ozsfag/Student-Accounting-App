package com.example.StudentAccountingApplications.commands;

import com.example.StudentAccountingApplications.dto.Student;
import com.example.StudentAccountingApplications.services.StudentService;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@Slf4j
@RequiredArgsConstructor
public class StudentCommands {
  private final StudentService studentService;

  /**
   * Adds a new student.
   *
   * @param firstName the first name of the student
   * @param lastName the last name of the student
   * @param age the age of the student
   * @return a message indicating the student was added
   */
  @ShellMethod(value = "Add new student", key = "add")
  public String addStudent(
      @ShellOption String firstName, @ShellOption String lastName, @ShellOption int age) {
    Student student = studentService.addStudent(firstName, lastName, age);
    log.info("Added student: {}", student);
    return "Added student: " + student;
  }

  /**
   * Lists all students.
   *
   * @return a string representation of all students
   */
  @ShellMethod(value = "List of all students", key = "list")
  public String listStudents() {
    Collection<Student> students = studentService.getAllStudents();

    if (students.isEmpty()) {
      log.info("No students found");
      return "No students found";
    }

    return students.stream().map(Student::toString).collect(Collectors.joining("\n"));
  }

  /**
   * Deletes a student by ID.
   *
   * @param id the ID of the student to delete
   * @return a message indicating the result of the deletion
   */
  @ShellMethod(value = "Delete student by ID", key = "delete")
  public String deleteStudent(@ShellOption Long id) {
    Optional<Student> student = studentService.deleteStudent(id);
    String message = student.map(s -> "Deleted student: " + s).orElse("Student not found");
    log.info(message);
    return message;
  }

  /**
   * Clears all students.
   *
   * @return a message indicating all students have been removed
   */
  @ShellMethod(value = "Clear all students", key = "clear")
  public String clearStudents() {
    studentService.clearAll();
    log.info("All students have been removed");
    return "All students have been removed";
  }
}
