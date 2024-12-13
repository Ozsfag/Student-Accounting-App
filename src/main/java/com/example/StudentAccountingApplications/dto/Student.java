package com.example.StudentAccountingApplications.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/** Represents a student with an ID, first name, last name, and age. */
@Getter
@ToString
public class Student {
  private final Long id;
  private final String firstName;
  private final String lastName;
  private final int age;

  @Builder
  private Student(Long id, String firstName, String lastName, int age) {
    if (firstName == null || firstName.isEmpty()) {
      throw new IllegalArgumentException("First name cannot be null or empty");
    }
    if (lastName == null || lastName.isEmpty()) {
      throw new IllegalArgumentException("Last name cannot be null or empty");
    }
    if (age < 0) {
      throw new IllegalArgumentException("Age cannot be negative");
    }
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }
}
