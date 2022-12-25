package ASM2_Code;

import java.util.Scanner;

public class SendMessage {
    char Q[];
    int MAX = 250;
    int front, rear;


    SendMessage(int M) {
        MAX = M;
        Q = new char[MAX];
        rear = 0;
        front = -1;
    }

    int count() {
        if (front == rear)
            return 0;
        else
            return ((MAX - front) + rear) % MAX;
    }

    void enqueue(char e) {
        if (count() == MAX -1)
            System.out.println("Queue is full!");
        else {
            Q[rear] = e;
            rear = (rear + 1) % MAX;
            if (front == -1)
                front = 0;
        }
    }

    char dequeue() {
        char e = ' ';
        if (count() == 0)
            System.out.println("Queue is empty!");
        else {
            e = Q[front];
            front = (front + 1) % MAX;

        }
        return e;
    }

    String Transfer(String S1) {
        String S2 = "";
        int i = 0;
        int count = 0;
        char y;
        if (S1.length() == 0) {
            System.out.println("Empty string! Please input again!");
            return "";
        }
        else if (S1.length() > 250)
        {
            System.out.println("String over 250 characters. Please enter again");
            return "";
        }
        else {
            try {
                while(i < S1.length()) {
                    while(count() < MAX -1) {
                        y = S1.charAt(i);
                        enqueue(y);
                        i = i + 1;
                        if (i >= S1.length())  
                            break;
                    }

                    while(count() > 0) {
                        y = dequeue();
                        S2 = S2 + y;
                    }

                    count = count + 1;
                }

                System.out.println("Number times used buffer Q:" + count);
                return S2;
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
                return "";
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SendMessage Q = new SendMessage(11);
        String S1 = "";
        System.out.println("Enter string to transfer:" + "\nS1 = ");
        S1 = sc.nextLine();
        long start, end, time;
        start = System.currentTimeMillis();
        String S2 = Q.Transfer(S1);
        System.out.println("S2: " + S2);
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Executed time: " + time + " millisecond");
    }
}
