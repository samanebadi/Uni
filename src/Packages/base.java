package Packages;

import java.util.ArrayList;

public class base {

    public static class Person {
        public int id;
        public static ArrayList<Person> personList = new ArrayList<>();
        public String name;
        public String nationalID;

        private static int idCount = 1; // Start IDs from 1

        public Person(String name, String nationalID) {
            this.id = idCount++;
            this.name = name;
            this.nationalID = nationalID;
            personList.add(this);
        }

        public static Person findByID(int id) {
            for (Person person : personList) {
                if (person.id == id) {
                    return person;
                }
            }
            return null;
        }

        public void displayPerson() {
            System.out.println("ID: " + id + ", Name: " + name + ", National ID: " + nationalID);
        }
    }
}
