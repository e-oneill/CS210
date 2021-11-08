package Labs.Week6;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntStack stack = new IntStack();
        int commands = Integer.parseInt(sc.nextLine());
        // System.out.println(stack.toString());
        for (int i = 0; i < commands; i++)
        {
            String command = sc.nextLine();

            if (command.toLowerCase().equals("pop"))
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

        System.out.println(stack.peek());

        
    }
}

class IntStack { 
    static int top;
    static HashMap<Integer,Integer> stack;

    public IntStack()
    {
        top = 0;
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
        stack.remove(top-1);
    }

    public int peek()
    {
        int top = stack.size();
        return stack.get(top-1);
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