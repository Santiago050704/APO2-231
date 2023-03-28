package model;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentList {
    /*Objeto -> String: Serialización
    * String -> Objeto: Deserialización*/

    static String folder = "data"; //Se crea una carpeta con nombre data.
    static String path = "data/data.txt"; //Se crea un archivo data.txt que se guardará en data.
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
        File file = new File(path); //Crea un objeto de tipo File que representa un archivo o directorio en el sistema de archivos. El constructor
        //recibe un String que representa el path donde será creado el archivo.

        FileOutputStream fos = new FileOutputStream(file); //Crea un objeto que se utiliza para escribir datos en un archivo. El objeto
        //FileOutputStream se asigna a la variable fos, y luego se puede escribir datos en el archivo usando los métodos de la clase
        //FileOutputStream.

        Gson gson = new Gson();
        String data = gson.toJson(students);
        /*for(int i = 0; i < students.size(); i++){
            data += students.get(i).getName() + ":" + students.get(i).getCode() + ":" + students.get(i).getAge() + "\n";
            //Se añade el objeto estudiante por sus atributos a la variable data, separados por ":".
        }*/

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos)); //Se crea un objeto BufferedWriter para escribir en un
        //archivo llamado fos. OutputStreamWriter convierte los caracteres escritos en bytes. Es decir, OutputStreamWriter convierte los
        //caracteres escritos en bytes y los escribe en el objeto FileOutputStream llamado fos.

        writer.write(data); //Se usa el objeto writer para escribir en fos lo que se guardó en la variable data.

        writer.flush(); //Se utiliza para vaciar el búfer de salida del objeto writer. Así se asegura que cualquier byte que se haya
        //almacenado en el búfer de salida se escriba en el archivo file, envuelto por el objeto fos.

        fos.close(); //Asegura que cualquier recurso del sistema asociado con el objeto FileOutputStream se libere.
    }

    public void load() throws IOException {
        File file = new File(path);
        if(file.exists()){
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String content = "";
            String line = "";
            while((line = reader.readLine()) != null){
                /*System.out.println(line);
                String[] arr = line.split(":");
                System.out.println(Arrays.toString(arr));
                students.add(
                        new Student(arr[0], arr[1], Integer.parseInt(arr[2]))
                );*/
                content += line + "\n";
            }
            System.out.println(content);
            Gson gson = new Gson();
            Student[] array = gson.fromJson(content, Student[].class);
            /*for(Student s : array){
                students.add(s);
            }*/
            students.addAll(Arrays.asList(array)); //Agrega todo transformado en lista.
            fis.close();
            //System.out.println(students.size());
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
