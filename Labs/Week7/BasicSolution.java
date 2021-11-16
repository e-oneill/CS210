package Labs.Week7;
import java.util.Scanner;

public class BasicSolution {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        while (sc.hasNextLine())
        {
            String command = sc.nextLine();
            if (command.equalsIgnoreCase("Remove"))
            {
               q.remove();
            }
            else if (command.equalsIgnoreCase("Exit"))
            {
                break;
            }
            else
            {
                String str = command.split(" ",2)[1];
                q.insert(str);
            }
        }
        sc.close();
        System.out.println(q.printMid());
    }
}

class Queue {
    private String[] arr;
    private int head;
    private int rear;

    public Queue()
    {
        arr = new String[20];
        head = 0;
        rear = -1;
    }

    public Queue(int s) 
    {
        arr = new String[s];
        head = 0;
    }

    public boolean insert(String j)
    {
        isFull();
        arr[rear+1] = j;
        // head++;
        rear++;
        return true;
    }

    public boolean remove()
    {
        if (isEmpty()) return false;
        arr[head] = null;
        head++;
        return true;
    }

    public void growQueue() {
        String[] arr2 = arr;
        arr = new String[rear*2];
        for (int i = 0; i < arr2.length; i++)
        {
            arr[i] = arr2[i];
        }
    }

    public boolean isEmpty()
    {
        if (rear == -1)
        {
            return true;
        }
        return false;
    }

    public void isFull()
    {
        if (head == arr.length-1)
        {
            growQueue();
        }
    }

    public String printMid()
    {
        String output = "";
        int size = rear - head;
        // for (int i = head; i <= size; i++)
        // {
        //     output += "[" +  arr[i] + "] ";
        // }

        int mid = head + (size) / 2;
        output +=  arr[mid];
        return output;
    }

}
