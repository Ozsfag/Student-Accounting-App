package com.example.StudentAccountingApplications.events;

import com.example.StudentAccountingApplications.dto.Student;
import lombok.Getter;

@Getter
public class StudentCreatedEvent {
  private final Student student;

  public StudentCreatedEvent(Student student) {
    this.student = student;
  }
}
