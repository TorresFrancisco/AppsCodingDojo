
public class SinglyLinkedList {
        public Node head;
        public SinglyLinkedList() {
            // su codigo aqui
            this.head = null;
        }
        //Los metodos de la SLL van aqui. Al principio,
        //les mostraremos cómo agregar nodos a la lista.
        public void add(int value) {
            Node newNode = new Node(value);
            if(head == null) {
                head = newNode;
            } else {
                Node runner = head;
                while(runner.next != null) {
                    runner = runner.next;
                }
                runner.next = newNode;
            }
        }    
        public void remove() {
            
        }
        public void printValues() {
            System.out.println(head.value);
            System.out.println(head.next.value);
            System.out.println(head.next.next.value);
            System.out.println(head.next.next.next.value);
        }
    }
