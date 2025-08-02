import java.util.Scanner;

class Node {
    int val;
    Node next;

    Node(int v) {
        val = v;
        next = null;
    }
}

class Linked {
    Node head;

    Linked() {
        head = null;
    }

    void addFirst(int v) {
        Node newNode = new Node(v);
        newNode.next = head;
        head = newNode;
        System.out.println(v + " added at start");
    }

    void addLast(int v) {
        Node newNode = new Node(v);
        if (head == null) {
            head = newNode;
            System.out.println(v + " added at end (empty list)");
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println(v + " added at end");
    }

    void addAtPos(int v, int pos) {
        if (pos <= 0) {
            System.out.println("Invalid pos");
            return;
        }

        if (pos == 1) {
            addFirst(v);
            return;
        }

        Node newNode = new Node(v);
        Node temp = head;

        for (int i = 1; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("Position too big");
                return;
            }
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position too big");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println(v + " added at pos " + pos);
    }

    void removeFirst() {
        if (head == null) {
            System.out.println("Nothing to remove");
            return;
        }

        int removed = head.val;
        head = head.next;
        System.out.println(removed + " removed from start");
    }

    void removeLast() {
        if (head == null) {
            System.out.println("Nothing to remove");
            return;
        }

        if (head.next == null) {
            int removed = head.val;
            head = null;
            System.out.println(removed + " removed from end");
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        int removed = temp.next.val;
        temp.next = null;
        System.out.println(removed + " removed from end");
    }

    void removeAtPos(int pos) {
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        if (pos <= 0) {
            System.out.println("Invalid pos");
            return;
        }

        if (pos == 1) {
            removeFirst();
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("Invalid pos");
                return;
            }
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Invalid pos");
            return;
        }

        int removed = temp.next.val;
        temp.next = temp.next.next;
        System.out.println(removed + " removed from pos " + pos);
    }

    void show() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linked list = new Linked();

        System.out.print("Enter how many initial nodes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            int x = sc.nextInt();
            list.addLast(x);
        }

        int ch;
        do {
            System.out.println("\n1. Add at start");
            System.out.println("2. Add at end");
            System.out.println("3. Add at position");
            System.out.println("4. Remove from start");
            System.out.println("5. Remove from end");
            System.out.println("6. Remove from position");
            System.out.println("7. Print list");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Value: ");
                    list.addFirst(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Value: ");
                    list.addLast(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Value: ");
                    int v = sc.nextInt();
                    System.out.print("Pos: ");
                    int p = sc.nextInt();
                    list.addAtPos(v, p);
                    break;
                case 4:
                    list.removeFirst();
                    break;
                case 5:
                    list.removeLast();
                    break;
                case 6:
                    System.out.print("Pos: ");
                    list.removeAtPos(sc.nextInt());
                    break;
                case 7:
                    list.show();
                    break;
                case 0:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Wrong input");
            }

        } while (ch != 0);

        sc.close();
    }
}
