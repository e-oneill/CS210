package Labs.Week6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class QueueStack {
    public static void main(String[] args) 
    {
        Queue<Integer> queue1 = new LinkedList<Integer>();
        Queue<Integer>  queue2 = new LinkedList<Integer>();

        Scanner sc = new Scanner(System.in);
        int maxSize = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < maxSize; i++)
        {
            String command = sc.nextLine().toLowerCase();
            if (command.equalsIgnoreCase("pop"))
            {
                queue1.poll();
            }
            else if (command.equalsIgnoreCase("clear"))
            {
                queue1.clear();
            }
            else if (command.equalsIgnoreCase("peek"))
            {
                System.out.println(queue1.peek());
            }
            else
            {
                int var = Integer.parseInt(command.split(" ")[1]);
                queue2.addAll(queue1);
                queue1.clear();
                queue1.add(var);
                while (queue2.peek() != null)
                {
                queue1.add(queue2.poll());
                }
            }
        }
        if (queue1.peek() != null)
        {
        System.out.println(queue1.peek());
        }
        else
        {
            System.out.println("empty");  
        }
    }
}

