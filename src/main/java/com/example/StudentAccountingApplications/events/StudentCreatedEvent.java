package com.example.StudentAccountingApplications.events;

import com.example.StudentAccountingApplications.dto.Student;
import lombok.Getter;

/**
 * Event representing the creation of a new student.
 */
@Getter
public class StudentCreatedEvent {
  private final Student student;

  /**
   * Constructs a new StudentCreatedEvent.
   *
   * @param student the student that was created
   */
  public StudentCreatedEvent(Student student) {
    this.student = student;
  }
}
