public class ListaEnlazada {

    private Node head;

    public void addNode(Node node){
        if(head == null){
            head = node;
        }else{
            addNode(head, node);
        }
    }

    private void addNode(Node current, Node node){
        if(current.getNext() == null){
            current.setNext(node);
            return;
        }
        addNode(current.getNext(), node);
    }

    public void addNodeAtHead(Node node){
        node.setNext(head);
        head = node;
    }

    public void print(){
        print(head);
    }

    private void print(Node current){
        if(current == null){
            return;
        }
        System.out.println(current.getName());
        print(current.getNext());
    }



}
