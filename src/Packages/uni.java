package Packages;

import java.util.ArrayList;
import java.util.HashMap;

public class uni {

    public static class Major {
        public int id;
        public static ArrayList<Major> majorList = new ArrayList<>();
        public String name;
        public final int capacity;
        public int numberOfStudents = 0;
        private static int idCounter = 1;

        public Major(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
            this.id = idCounter++;
            majorList.add(this);
        }

        public static Major findById(int id) {
            for (Major major : majorList) {
                if (major.id == id) {
                    return major;
                }
            }
            return null;
        }

        public void addStudent() {
            if (numberOfStudents < capacity) {
                numberOfStudents++;
            } else {
                System.out.println("The field " + name + " capacity is full.");
            }
        }
    }

    public static class Student {
        public int id;
        public static ArrayList<Student> studentList = new ArrayList<>();
        public int personID;
        public final int entranceYear;
        public int majorID;
        public String studentID;
        private static int idCounter = 1;

        public Student(int personID, int entranceYear, int majorID) {
            this.id = idCounter++;
            this.personID = personID;
            this.entranceYear = entranceYear;
            this.majorID = majorID;
            studentList.add(this);
            setStudentCode();
        }

        public static Student findById(int id) {
            for (Student student : studentList) {
                if (student.id == id) {
                    return student;
                }
            }
            return null;
        }

        public void setStudentCode() {
            Major major = Major.findById(majorID);
            if (major != null) {
                int majorSave = major.id;
                int studentSave = major.numberOfStudents + 1;
                this.studentID = String.format("%d%02d%02d", entranceYear % 1000, majorSave, studentSave);
            }
        }
    }

    public static class Professor {
        public int id;
        public static ArrayList<Professor> professorList = new ArrayList<>();
        public int personID;
        public int majorID;
        private static int idCounter = 1;

        public Professor(int personID, int majorID) {
            this.id = idCounter++;
            this.personID = personID;
            this.majorID = majorID;
            professorList.add(this);
        }

        public static Professor findById(int id) {
            for (Professor professor : professorList) {
                if (professor.id == id) {
                    return professor;
                }
            }
            return null;
        }
    }

    public static class Course {
        public int id;
        public static ArrayList<Course> courseList = new ArrayList<>();
        public String title;
        public int units;
        private static int idCounter = 1;

        public Course(String title, int units) {
            this.id = idCounter++;
            this.title = title;
            this.units = units;
            courseList.add(this);
        }

        public static Course findById(int id) {
            for (Course course : courseList) {
                if (course.id == id) {
                    return course;
                }
            }
            return null;
        }
    }

    public static class PresentedCourse {
        public int id;
        public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();
        public int courseID;
        public int professorID;
        public int capacity;
        public ArrayList<Integer> studentIDs = new ArrayList<>();
        private static int idCounter = 1;

        public PresentedCourse(int courseID, int professorID, int maxCapacity) {
            this.id = idCounter++;
            this.courseID = courseID;
            this.professorID = professorID;
            this.capacity = maxCapacity;
            presentedCourseList.add(this);
        }

        public static PresentedCourse findById(int id) {
            for (PresentedCourse presentedCourse : presentedCourseList) {
                if (presentedCourse.id == id) {
                    return presentedCourse;
                }
            }
            return null;
        }

        public void addStudent(int studentID) {
            if (studentIDs.size() < capacity) {
                studentIDs.add(studentID);
            } else {
                System.out.println("The capacity of this class is full!");
            }
        }
    }

    public static class Transcript {
        public int studentID;
        public HashMap<Integer, Double> transcript = new HashMap<>();

        public Transcript(int studentID) {
            this.studentID = studentID;
        }

        public void setGrade(int presentedCourseID, double grade) {
            if (transcript.containsKey(presentedCourseID)) {
                System.out.println("The score has already been recorded.");
            } else {
                transcript.put(presentedCourseID, grade);
            }
        }

        public void printTranscript() {
            System.out.println("Student ID: " + studentID);
            for (int courseID : transcript.keySet()) {
                System.out.println("Subject " + courseID + " grade: " + transcript.get(courseID));
            }
        }

        public double getGPA() {
            double totalUnits = 0;
            double weightedScore = 0;

            for (int courseID : transcript.keySet()) {
                Course course = Course.findById(courseID);
                if (course != null) {
                    weightedScore += transcript.get(courseID) * course.units;
                    totalUnits += course.units;
                }
            }

            return (totalUnits == 0) ? 0 : weightedScore / totalUnits;
        }
    }
}
