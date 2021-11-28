package ExamPrep;
import java.util.*;
public class QueueHandling {
    public static void main(String[] args) {
        // Queue<String> queue = new LinkedList<String>();
        MyQueue queue = new MyQueue();

        Scanner sc = new Scanner(System.in);
        int queueEntries = 0;
        while (sc.hasNextLine())
        {
            String command = sc.nextLine();
            if (command.equalsIgnoreCase("REMOVE"))
            {
                queueEntries--;
                queue.remove();
            }
            else if (command.equalsIgnoreCase("EXIT"))
            {
                break;
            }
            else
            {
                String input = command.split(" ", 2)[1];
                queue.add(input);
                queueEntries++;
            }
        }
        // System.out.println()
        if (queueEntries > 0)
        {
            int mid = queueEntries / 2;
            if (queueEntries % 2 != 0)
            {
                mid++;
            }
            for (int i = 1; i < mid; i++)
            {
                queue.remove();
            }

            System.out.println(queue.remove());
        }
        else
        {
            System.out.println("Empty");
        }

    }

    
}

class MyQueue {
    String[] queue;
    int head;
    int end;

    public MyQueue() {
        queue = new String[100];
        head = 0;
        end = 0;
    }

    public String remove() {
        String output = queue[head];
        head++;
        return output;
    }

    public void add(String string) {
        queue[end] = string;
        end++;
    }
}
