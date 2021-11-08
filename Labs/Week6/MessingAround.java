package Labs.Week6;

public class MessingAround {
    public static void main(String[] args) {
       Stack stack = new Stack("int");
       Stack strStack = new Stack("String");
       stack.push(5);
       stack.push(4);
       System.out.println(stack.toString());
       System.out.println();
       strStack.push("Hello");
       strStack.push("World!");

       System.out.println(strStack.toString());
    }
}
