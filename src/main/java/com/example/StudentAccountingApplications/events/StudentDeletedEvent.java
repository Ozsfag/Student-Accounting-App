package com.example.StudentAccountingApplications.events;

import lombok.Getter;

/**
 * Event representing the deletion of a student.
 */
@Getter
public class StudentDeletedEvent {
  private final Long studentId;

  /**
   * Constructs a new StudentDeletedEvent.
   *
   * @param studentId the ID of the student that was deleted
   */
  public StudentDeletedEvent(Long studentId) {
    this.studentId = studentId;
  }
}
