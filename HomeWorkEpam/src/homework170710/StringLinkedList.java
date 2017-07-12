package homework170710;

/**
 * Created by Ilya on 11.07.2017.
 */
public class StringLinkedList {

//    home task: В классе StringLinkedList
//    в toString сделать StringBuilder
//    реализовать remove(int index)


    Node first;  // null

    Node last;  // null

    int size;  // 0

    public void add(String value) {
        Node node = new Node(value, null);

        if (first == null) {
            first = node;
        }
        else {
            last.next = node;
        }

        last = node;

        size++;
    }

    public boolean remove(String value) {

        boolean result = false;

        Node current = first;

        Node prev = null;

        while (current != null) {
            if (current.value.equals(value)) {
                if (prev == null) {
                    first = current.next;
                }
                else {
                    prev.next = current.next;
                }
                size--;
                result = true;
                break;
            }
            prev = current;
            current = current.next;
        }

        if (first == null) {
            last = null;
        }

        return result;
    }

    public String remove(int index) {
        if (index >= size) {
            return null; //guard condition
        }
        Node current = first;
        Node prev = null;

        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        if (prev == null) {
            first = current.next;
        }
        else {
            prev.next = current.next;
        }
        size--;
        return current.value;
    }

    @Override
    public String toString() {
        // traverse DONE

        StringBuilder result = new StringBuilder("[");

        if (first != null) {
            result.append(first.value);

            Node current = first.next;

            while (current != null) {
                result.append(", ").append(current.value);
                current = current.next;
            }
        }

        result.append("]");

        return result.toString();
    }
}
