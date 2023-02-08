public class Main {
    public static void main(String[] args) {
        DobleEnlace lista = new DobleEnlace();
        lista.addNode(
                new Node("A")
        );
        lista.addNode(
                new Node("B")
        );
        lista.addNode(
                new Node("C")
        );
        lista.addNode(
                new Node("D")
        );
        lista.addNodeAtHead(
                new Node("E")
        );
        lista.print();
        lista.deleteNode("C");
        System.out.println("-----");
        lista.print();
        lista.deleteNode("D");
        System.out.println("-----");
        lista.print();
    }
}