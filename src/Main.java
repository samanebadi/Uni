import Packages.base;
import Packages.uni;

public class Main {
    public static void main(String[] args) {

        uni.Major math = new uni.Major("Mathematics", 50);
        uni.Major cs = new uni.Major("Computer Science", 30);


        base.Person person1 = new base.Person("sara", "40311");
        base.Person person2 = new base.Person("reza", "40312");
        base.Person person3 = new base.Person("nima", "40313");
        base.Person person4 = new base.Person("negin", "40414");
        base.Person person5 = new base.Person("melika", "40415");


        uni.Student student1 = new uni.Student(person1.id, 2024, math.id);
        uni.Student student2 = new uni.Student(person2.id, 2024, math.id);
        uni.Student student3 = new uni.Student(person3.id, 2024, cs.id);


        for (uni.Student student : uni.Student.studentList) {
            base.Person person = base.Person.findByID(student.personID);
            if (person != null) {
                System.out.println("Student: " + person.name + ", Student ID: " + student.studentID);
            }
        }


        uni.Professor professor1 = new uni.Professor(person4.id, math.id);
        uni.Professor professor2 = new uni.Professor(person5.id, cs.id);


        for (uni.Professor professor : uni.Professor.professorList) {
            base.Person person = base.Person.findByID(professor.personID);
            if (person != null) {
                System.out.println("Professor: " + person.name + ", Professor ID: " + professor.id);
            }
        }


        uni.Course course1 = new uni.Course("Advanced Programming", 3);
        uni.Course course2 = new uni.Course("math", 3);
        uni.Course course3 = new uni.Course("Algorithms", 3);


        uni.PresentedCourse presentedCourse1 = new uni.PresentedCourse(course1.id, professor1.id, 2);
        uni.PresentedCourse presentedCourse2 = new uni.PresentedCourse(course2.id, professor1.id, 3);
        uni.PresentedCourse presentedCourse3 = new uni.PresentedCourse(course3.id, professor2.id, 1);


        presentedCourse1.addStudent(student1.id);
        presentedCourse1.addStudent(student2.id);

        presentedCourse2.addStudent(student1.id);
        presentedCourse2.addStudent(student2.id);
        presentedCourse2.addStudent(student3.id);

        presentedCourse3.addStudent(student3.id);


        uni.Transcript transcript1 = new uni.Transcript(student1.id);
        transcript1.setGrade(presentedCourse1.id, 19.5);
        transcript1.setGrade(presentedCourse2.id, 13.0);

        uni.Transcript transcript2 = new uni.Transcript(student2.id);
        transcript2.setGrade(presentedCourse1.id, 8.1);
        transcript2.setGrade(presentedCourse2.id, 12.8);

        uni.Transcript transcript3 = new uni.Transcript(student3.id);
        transcript3.setGrade(presentedCourse1.id, 14.2);
        transcript3.setGrade(presentedCourse2.id, 12.0);


        transcript1.printTranscript();
        System.out.println("GPA: " + transcript1.getGPA());

        transcript2.printTranscript();
        System.out.println("GPA: " + transcript2.getGPA());

        transcript3.printTranscript();
        System.out.println("GPA: " + transcript3.getGPA());
    }
}
