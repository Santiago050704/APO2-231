public class Main {

    public static void main(String[] args) {

        ListaEnlazada lista = new ListaEnlazada();
        lista.addNode(
                new Node("Alejandro")
        );
        lista.addNode(
                new Node("Miguel")
        );
        lista.addNode(
                new Node("Samuel")
        );
        lista.addNodeAtHead(
                new Node("Sebastian")
        );
        lista.print();


    }


}