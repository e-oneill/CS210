package Labs.Week6;
import java.util.*;
public class Stack { //remove public when this is in the same file as the main class for completing the lab
        static int top;
        static HashMap stack;
        //Default Constructor creates a HashMap of Integers
        public Stack()
        {
            top = 0;
            stack = new HashMap<Integer,Integer>();
        }
        //Constructor takes a parameter that defines the datatype to be stored in the stack.
        public Stack(String dataType)
        {
            top = 0;
            if (dataType.toLowerCase().equals("int") || dataType.toLowerCase().equals("integer") )
            {
                stack = new HashMap<Integer, Integer>();
            }
            else if (dataType.toLowerCase().equals("string"))
            {
                stack = new HashMap<Integer,String>();
            }
            else if (dataType.toLowerCase().equals("long"))
            {
                stack = new HashMap<Integer,Long>();
            }
            else 
            {
                stack = new HashMap<Object, Object>();
            }
        }
        
        public void push(int j) 
        {
            int top = stack.size();
            stack.put(top, j);
        }

        public void push(String j)
        {
            int top = stack.size();
            stack.put(top, j);
        }

        public void push(Long j)
        {
            int top = stack.size();
            stack.put(top, j);
        }
    
        public void pop()
        {
            int top = stack.size();
            stack.remove(top-1);
        }
    
        public Object peek()
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
