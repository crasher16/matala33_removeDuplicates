package ex1;
import unit4.collectionsLib.Node;

public class matala33_removeDuplicates {
	
	// By: Idan Dror

    public static Node<Double> removeDuplicates(Node<Double> head) {
        if (head == null) return null;

        Node<Double> newHead = null;  
        Node<Double> newTail = null;

        Node<Double> current = head;
        while (current != null) {
            if (!contains(newHead, current.getValue())) {  
                Node<Double> newNode = new Node<>(current.getValue());
                if (newHead == null) {
                    newHead = newNode;
                    newTail = newHead;
                } else {
                    newTail.setNext(newNode);
                    newTail = newNode;
                }
            }
            current = current.getNext();
        }

        return newHead;
    }

    
    private static boolean contains(Node<Double> head, Double value) {
        Node<Double> tmp = head;
        while (tmp != null) {
            if (tmp.getValue().equals(value)) {
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    // ---------- helper methods ----------
    public static void printList(Node<Double> head) {
        Node<Double> tmp = head;
        for (; tmp != null; tmp = tmp.getNext())
            System.out.print(tmp.getValue() + " ");
        System.out.println();
    }

    public static Node<Double> createList(double[] arr) {
        Node<Double> head = null;
        Node<Double> tmp = null;

        for (int i = 0; i < arr.length; i++) {
            if (head == null) {
                head = new Node<Double>(arr[i]);
                tmp = head;
            } else {
                tmp.setNext(new Node<Double>(arr[i]));
                tmp = tmp.getNext();
            }
        }
        return head;
    }

    // -------------------- main tests ----------------
    public static void main(String[] args) {
        Node<Double> h1 = createList(new double[]{1.0, 2.0, 2.0, 3.0, 2.0, 4.0});
        printList(h1);
        Node<Double> noDupes = removeDuplicates(h1);
        printList(noDupes);
    }
}