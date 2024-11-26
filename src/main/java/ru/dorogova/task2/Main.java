package ru.dorogova.task2;

import java.io.File;

import static ru.dorogova.task2.StudentApp.*;

public class Main {

    public static void main(String[] args) {
        File f = new File(FILE_JSON);

        Student student = new Student("Алекс", 22, 86.5);
        saveStudentsToFile(FILE_JSON, student);
        System.out.println(loadStudent(FILE_JSON));


    }

}
