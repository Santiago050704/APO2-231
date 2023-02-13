public class DobleEnlace {
    private Node head;
    private Node tail;

    public void addNode(Node node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
    }

    public void addNodeAtHead(Node node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            head.setPrevious(node);
            node.setNext(head);
            head = node;
        }
    }

    public void deleteNode(String name){
        deleteNode(head, name);
    }

    private void deleteNode(Node current, String name){
        if(current == null){
            return;
        }
        if(current.getName().equalsIgnoreCase(name)){
            //Eliminar
            if(current == head){
                head = head.getNext();
                head.setPrevious(null);
                return;
            }else if(current == tail){
                tail = tail.getPrevious();
                tail.setNext(null);
                return;
            }else{
                Node prev = current.getPrevious();
                Node next = current.getNext();
                prev.setNext(next);
                next.setPrevious(prev);
                return;
            }
        }
        deleteNode(current.getNext(), name);
    }

    //Activación
    public void print(){
        print(head);
    }

    //Recursivo
    public void print(Node current){
        if(current == null){
            return;
        }
        System.out.println(current.getName());
        print(current.getNext());
    }
}
