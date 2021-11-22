package Labs.Week8;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int num = Integer.parseInt(sc.nextLine());
        Link[] array = new Link[num];
        for (int i = 0; i < num; i++)
            {
                array[i] = new Link(Integer.parseInt(sc.nextLine()));
            }
            for (int i = 0; i < num; i++)
        {
            
            
            int select = sc.nextInt();
            int previous = sc.nextInt();
            int next = sc.nextInt();;
            if (previous != -1){
                array[select].previous = array[previous];
            }
            if (next != -1){
                array[select].next = array[next];
            }
            sc.nextLine();
        }
        if (num > 0 ) {
            list.first = array[0];
            list.last = array[num-1];
        }

            //region my input
            // String command = sc.nextLine();
            // if (command.equals("exit"))
            // {
            //     break;
            // }
            // if (command.split(" ", 4)[0].equalsIgnoreCase("insert") )
            // {
            //     if (command.split(" ", 4)[1].equalsIgnoreCase("head"))
            //     {
            //         int val = Integer.parseInt(command.split(" ", 3)[2]);
            //         list.insertHead(val);
            //     }
            //     else if (command.split(" ", 4)[2].equalsIgnoreCase("in"))
            //     {

            //     }
            //     else
            //     {
            //         int val = Integer.parseInt(command.split(" ", 3)[2]);
            //         list.insertEnd(val);
            //     } 
            // }
            // if (command.split(" ", 2)[0].equalsIgnoreCase("delete"))
            // {
            //     int val = Integer.parseInt(command.split(" ", 2)[1]);
            //     list.delete(val);
            // }
            // if (command.equals("display"))
            // {
            //     list.display();
            // }
            //endregion;

            System.out.println(search(list));
        // }


    }

    public static int search(LinkedList list)
    {
        Link current = list.first;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        // int links = 0;
        if (list.isEmpty())
        {
            return -1;
        }
        while (current != null)
        {
            if ((current != list.first && current.previous == null) || (current != list.last && current.next == null) )
            {
                return 0;
            }
            if (current.next == current.previous || current.next == current || current.previous == current)
            {
                return 0;
            }
            if (current.data < smallest)
            {
                secondSmallest = smallest;
                smallest = current.data;
            }

            current = current.next;
            
        }

        return secondSmallest;
    }
}

class LinkedList {
    public Link first;
    public Link last;

    public LinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first==null);
    }

    public void insertHead(int data) {
        Link newLink = new Link(data);

        newLink.next = first;
        newLink.previous = null;
        if (first != null)
        {
            first.previous = newLink;
        }
        
        first = newLink;
        
        
        if (newLink.next == null)
        {
            last = newLink;
        }
    }

    public void insertEnd(int data) {
        Link current = first;
        Link newLink = new Link(data);
        if (current != null)
        {
        while (current.next != null)
        {
            current = current.next;
        }
        
            current.next = newLink;
            newLink.previous = current;
        }
        else 
        {
            first = newLink;
        }
        
        last = newLink;

    }

    public void insertInOrder(int data)
    {
        Link previous = null;
        Link current = first;
        Link newLink = new Link(data);
        while (current.data < data && current != null)
        {
            previous = current;
            current = current.next;
        }
        if (previous == null)
        {
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current;
    }

    public Link deleteHead() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link deleteEnd() {
        Link temp = last;

        last = temp.previous;

        return temp;

    }

    public void display() {
        Link current = first;
        while(current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    public Link find(int val) {
        Link current = first;
        while (current != null) {
            if (current.data == val)
            {
                current.displayLink();
                return current;
            }
        }

        return null;
    }

    public Link delete(int val) {
        Link current = first;
        Link previous = first;
        while (current.data != val)
        {
            if (current.next == null)
            {
                return null;
            }
            else {
                previous = current;
                current = current.next;
            }
        }

        if (current == first) {
            first = first.next;
        }
        else {
            previous.next = current.next;
            current.previous = previous;
        }

        return current;
    }
}

class Link {
    public Link previous;
    public Link next;
    public int data;

    public Link(int data)
    {
        this.data = data;
    }

    public void displayLink() {
        System.out.println(this.data);
    }
}
