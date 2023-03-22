import model.Student;
import model.StudentList;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Student A = new Student("Alberto", "A111", 18);
        Student B = new Student("Benito", "A222", 19);
        Student C = new Student("Carlos", "A333", 20);
        Student D = new Student("Daniela", "A444", 21);

        StudentList studentList = new StudentList();
        studentList.getStudents().add(A);
        studentList.getStudents().add(B);
        studentList.getStudents().add(C);
        studentList.getStudents().add(D);

        //System.out.println(studentList.toString());

        studentList.save();
    }
}