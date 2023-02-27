public class Main {
    public static void main(String[] args) {
        BST tree =  new BST();
        Node a = new Node("David");
        Node b = new Node("Julian");
        Node c = new Node("Pablo");
        Node d = new Node("Juan");
        Node e = new Node("Isabella");
        Node f = new Node("Daniela");
        Node g = new Node("James");
        Node h = new Node("Sara");


        tree.add(a);
        tree.add(b);
        tree.add(c);
        tree.add(d);
        tree.add(e);
        tree.add(f);
        tree.add(g);
        tree.add(h);

        tree.inOrder();
        tree.delete("Isabella");
        System.out.println("*********");
        tree.inOrder();
    }
}