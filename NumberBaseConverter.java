import java.util.*;
public class NumberBaseConverter {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit)
        {
            String num = sc.next();
            if (num.equals("-1"))
            {
                exit = true;
                continue;
            }
            
            int binaryNumber = Integer.parseInt(num, 2);

    
            // int num2 = (binaryNumber.length() + 7) & (-8);
            // if (num2 != binaryNumber.length())
            // {
            // output = String.format("%0" + (num2 - binaryNumber.toString().length() ) + "d%s",0,binaryNumber.toString());
            // }
    
            System.out.println("The decimal representation of " + num + " is " + binaryNumber);
            
            // System.out.println("The largest power of 2 that divides into " + num + " is " + result);
        }

    }
}
