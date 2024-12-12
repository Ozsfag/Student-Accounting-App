package com.example.StudentAccountingApplications.utils;

import com.example.StudentAccountingApplications.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.init-students", havingValue = "true")
@RequiredArgsConstructor
public class StudentInitilazer implements ApplicationListener<ApplicationStartedEvent> {
    private final StudentService studentService;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        studentService.addStudent("John", "Doe", 20);
        studentService.addStudent("Jane", "Smith", 21);
        studentService.addStudent("Bob", "Johnson", 19);
    }
}
