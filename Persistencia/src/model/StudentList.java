package model;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentList {
    ArrayList<Student> students;

    public StudentList() {
        students = new ArrayList<Student>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void save() throws IOException {
        String path = "/C:/Users/svale/Documents";
        File file = new File(path + "/" + "data.txt");
        System.out.println(file.exists());

        File folder = new File(path);
        System.out.println(Arrays.toString(
                folder.list()
        ));

        File innerFolder = new File(path + "/Delta/Kappa");
        innerFolder.mkdirs();
        FileOutputStream fos = new FileOutputStream(file);

        String data = "";

        for(int i = 0; i < students.size(); i++){
            data += students.get(i).getName() + ":" + students.get(i).getCode() + ":" + students.get(i).getAge() + "\n";
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data);
        writer.flush();

        fos.close();
    }
}
