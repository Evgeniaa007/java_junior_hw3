package ru.dorogova.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;


public class StudentApp {

    public static final String FILE_JSON = "students.json";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void saveStudentsToFile(String fileName, Student student) {
        try {
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(fileName), student);
            System.out.println("Сериализация успешно завершена");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Student loadStudent(String fileName) {
        Student student = new Student();
        File file = new File(fileName);
        if (file.exists()) {
            try {
                student = objectMapper.readValue(file, Student.class);
                System.out.println("Десериализация завершена.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return student;
    }
}

