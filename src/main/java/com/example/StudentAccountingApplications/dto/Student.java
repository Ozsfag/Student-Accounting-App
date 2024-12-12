package com.example.StudentAccountingApplications.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
  private Long id;
  private String firstName;
  private String lastName;
  private int age;
}
