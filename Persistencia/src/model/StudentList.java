package model;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentList {

    static String folder = "data";
    static String path = "/C:/Users/svale/Documents/data/data.txt";
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
        File file = new File(path);
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

    public void load() throws IOException {

        File file = new File(path);
        if(file.exists()){
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String content = "";
            String line = "";
            while((line = reader.readLine()) != null){
                System.out.println(line);
                String[] arr = line.split(":");
                System.out.println(Arrays.toString(arr));
                students.add(
                        new Student(arr[0], arr[1], Integer.parseInt(arr[2]))
                );
                content += line + "\n";

            }
            System.out.println(students.size());
            //System.out.println(content);
        }else{
            File f = new File(folder);
            if(!f.exists()){
                f.mkdirs();
            }
            file.createNewFile();
        }

    }

    public void show(){
        for(Student s : students){
            System.out.println(s.getName());
        }
    }
}
