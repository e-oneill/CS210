package Labs.Week6;

public class MessingAround {
    public static void main(String[] args) {
       Stack stack = new Stack("int");
       Stack strxxx = new Stack("String");
       
       stack.push(5);
       stack.push(4);
       System.out.println(strxxx.toString());
       System.out.println(stack.toString());
       System.out.println();
       strxxx.push("Hello");
       strxxx.push("World!");

       System.out.println(strxxx.toString());
    }
}
