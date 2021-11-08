package Labs.Week6;
import java.util.*;
public class Stack { //remove public when this is in the same file as the main class for completing the lab
        int top;
        HashMap stackTemp;
        //Default Constructor creates a HashMap of Integers
        public Stack()
        {
            top = 0;
            stackTemp = new HashMap<Integer,Integer>();
        }
        //Constructor takes a parameter that defines the datatype to be stored in the stack.
        public Stack(String dataType)
        {
            top = 0;
            if (dataType.toLowerCase().equals("int") || dataType.toLowerCase().equals("integer") )
            {
                stackTemp = new HashMap<Integer, Integer>();
            }
            else if (dataType.toLowerCase().equals("string"))
            {
                stackTemp = new HashMap<Integer,String>();
            }
            else if (dataType.toLowerCase().equals("long"))
            {
                stackTemp = new HashMap<Integer,Long>();
            }
            else 
            {
                stackTemp = new HashMap<Object, Object>();
            }
        }
        
        public void push(int j) 
        {
            int top = stackTemp.size();
            stackTemp.put(top, j);
        }

        public void push(String j)
        {
            int top = stackTemp.size();
            stackTemp.put(top, j);
        }

        public void push(Long j)
        {
            int top = stackTemp.size();
            stackTemp.put(top, j);
        }
    
        public void pop()
        {
            int top = stackTemp.size();
            stackTemp.remove(top-1);
        }
    
        public Object peek()
        {
            int top = stackTemp.size();
            return stackTemp.get(top-1);
        }
    
        public void clear()
        {
            stackTemp.clear();
        }
    
        public String toString()
        {
            int top = stackTemp.size();
            String str = "";
            if (top > 0)
            {
                for (int i = 0; i < top; i++)
                {
                    if (str == "")
                    {
                        str += stackTemp.get(i);
                    }
                    else 
                    {
                        str += " " + stackTemp.get(i);
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
