import model.Student;
import model.StudentList;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static StudentList studentList = new StudentList();
    public static void main(String[] args) throws IOException {

        //Cargar la información
        studentList.load();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("1. Añadir\n2. Mostrar\n3. Salir\n");
            int option = Integer.parseInt(scanner.nextLine()); //Obtiene la opción y la transforma en entero.
            switch(option){
                case 1:
                    //Nombre++Code++Edad
                    System.out.println("Escriba la entrada con el formato Nombre++Code++Edad");
                    String input = scanner.nextLine(); 
                    String[] data = input.split("\\+\\+"); //Separa el input cada vez que encuentre un "++".
                    System.out.println(Arrays.toString(data)); //Convierte la cadena data en una cadena de texto que se puede imprimir en pantalla.
                    studentList.getStudents().add(
                            new Student(data[0], data[1], Integer.parseInt(data[2]))
                    ); //Se usa el método getStudents() para obtener la lista y después añadir un nuevo objeto de tipo Student a esa lista.
                    studentList.save();
                    break;
                case 2:
                    studentList.show();
                    break;
                case 3:
                    System.exit(0); //exit() es un método estático de la clase System que cierra el programa cuando se le pasa 0 como 
                    //argumento.
                    break;
            }
        }
    }
}