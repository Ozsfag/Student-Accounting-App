package com.example.StudentAccountingApplications.commands;

import com.example.StudentAccountingApplications.dto.Student;
import com.example.StudentAccountingApplications.services.StudentService;
import java.util.Collection;
import java.util.Objects;
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

  @ShellMethod(value = "Add new student", key = "add")
  public String addStudent(
      @ShellOption String firstName, @ShellOption String lastName, @ShellOption int age) {
    Student student = studentService.addStudent(firstName, lastName, age);
    return "Added student: " + student;
  }

  @ShellMethod(value = "List of all students", key = "list")
  public String listStudents() {
    Collection<Student> students = studentService.getAllStudents();

    if (students.isEmpty()) return "No students found";

    return students.stream().map(Student::toString).collect(Collectors.joining("\n"));
  }

  @ShellMethod(value = "Delete student by ID", key = "delete")
  public String deleteStudent(@ShellOption Long id) {
    Student student = studentService.deleteStudent(id);
    return Objects.nonNull(student) ? "Deleted student: " + student : "Student to found";
  }

  @ShellMethod(value = "Clear all students", key = "clear")
  public String clearStudents() {
    studentService.clearAll();
    return "All student have been removed";
  }
}
