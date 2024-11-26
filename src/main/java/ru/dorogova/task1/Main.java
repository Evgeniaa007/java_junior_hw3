package ru.dorogova.task1;

// Создайте класс Person с полями name и age. Реализуйте сериализацию и десериализацию этого класса в файл.

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Анна", 29);

        try(FileOutputStream fileOutputStream = new FileOutputStream("person.bin")){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person);
            System.out.println("Сериализация завершена успешно");
        } catch(IOException e){
            e.printStackTrace();
        }

        try(FileInputStream fileInputStream = new FileInputStream("person.bin")){
            ObjectInputStream objectOutputStream = new ObjectInputStream(fileInputStream);
            person = (Person)objectOutputStream.readObject();
            System.out.println("Десериализация завершена успешно.");
        } catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Имя: " + person.getName());
        System.out.println("Возраст: " + person.getAge());

    }



}
