package Labs.Week6;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntStack stack = new IntStack();
        int commands = Integer.parseInt(sc.nextLine());
        // System.out.println(stack.toString());
        for (int i = 0; i < commands; i++)
        // boolean processing = true;
        // while (processing)
        {
            String command = sc.nextLine();
            if (command.isEmpty())
            {
                // processing=false;
            }
            else if (command.toLowerCase().equals("pop"))
            {
                stack.pop();
            }
            
            else if (command.toLowerCase().equals("clear"))
            {
                stack.clear();
            }
            else if (command.toLowerCase().equals("peek"))
            {
                stack.peek();
            }
            else
            {
                int val = Integer.parseInt(command.split(" ")[1]);
                stack.push(val);
            }
            // System.out.println(stack.toString());  
        }

        sc.close();
        stack.peek();

        
    }
}

class IntStack { 
    private HashMap<Integer,Integer> stack;

    public IntStack()
    {
        stack = new HashMap<Integer, Integer>();
    }

    public void push(int j) 
    {
        int top = stack.size();
        stack.put(top, j);
    }

    public void pop()
    {
        int top = stack.size();
        if (top > 0)
        {
        stack.remove(top-1);
        }
    }

    public void peek() 
    {
        int top = stack.size();
        if (top > 0) 
        {
            System.out.println(stack.get(top-1));
        }
        else
        {
            System.out.println("empty");
        }
    }

    public void clear()
    {
        stack.clear();
    }

    public String toString()
    {
        int top = stack.size();
        String str = "";
        if (top > 0)
        {
            for (int i = 0; i < top; i++)
            {
                if (str == "")
                {
                    str += stack.get(i);
                }
                else 
                {
                    str += " " + stack.get(i);
                }
            }
        }
        else
        {
            str = "Stack is empty";
        }
        return str;
    }
}
