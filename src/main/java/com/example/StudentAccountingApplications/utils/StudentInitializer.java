package com.example.StudentAccountingApplications.utils;

import com.example.StudentAccountingApplications.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Initializes the application with predefined students when the application starts. This is
 * conditional on the 'app.init-students' property being set to true.
 */
@Component
@ConditionalOnProperty(name = "app.init-students", havingValue = "true")
@RequiredArgsConstructor
public class StudentInitializer implements ApplicationListener<ApplicationStartedEvent> {
  private final StudentService studentService;

  /**
   * Handles the application started event to add initial students.
   *
   * @param event the application started event
   */
  @Override
  public void onApplicationEvent(ApplicationStartedEvent event) {
    addInitialStudents();
  }

  /** Adds predefined students to the system. */
  private void addInitialStudents() {
    studentService.addStudent("John", "Doe", 20);
    studentService.addStudent("Jane", "Smith", 21);
    studentService.addStudent("Bob", "Johnson", 19);
  }
}
