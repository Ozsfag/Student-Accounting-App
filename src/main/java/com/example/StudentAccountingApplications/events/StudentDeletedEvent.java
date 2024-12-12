package com.example.StudentAccountingApplications.events;

import lombok.Getter;

@Getter
public class StudentDeletedEvent {
  private final Long studentId;

  public StudentDeletedEvent(Long studentId) {
    this.studentId = studentId;
  }
}
