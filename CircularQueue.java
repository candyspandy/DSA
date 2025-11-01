public class CircularQueue {
    public final int max = 5;
    public int[] arr = new int[max];
    public int F = -1, R = -1;

    public void enqueue(int data) {
        if (F == -1) {
            F = R = 0;
            arr[R] = data;
        } else if (R + 1 == F || (F == 0 && R == max - 1)) {
            System.out.println("Queue Overflow!");
            return;
        } else {
            if (F != 0 && R == max - 1) {
                R = 0;
            } else {
                R++;
            }
            arr[R] = data;
        }
        System.out.println("Inserted: " + data);
    }

    public void dequeue() {
        if (F == -1) {
            System.out.println("Queue Underflow!");
            return;
        }
        int deleted = arr[F];
        arr[F] = -1; 
        if (F == R) {
            F = R = -1;
        } else if (F == max - 1) {
            F = 0;
        } else {
            F++;
        }
        System.out.println("Deleted: " + deleted);
    }

    public void display() {
        if (F == -1) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.print("Queue Elements: ");
        for (int i = 0; i < max; i++) {
            if (arr[i] != -1) System.out.print(arr[i] + "-> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();
        q.dequeue();
        q.dequeue();
        q.display();
        q.enqueue(60);
        q.enqueue(70);
        q.display();
    }
}
