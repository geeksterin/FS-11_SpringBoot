import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


public class Main {

    public static void helper() throws ClassNotFoundException{
        System.out.println("Mainak");

        throw new ClassNotFoundException("Mainak is mean!!!!");

    }
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        /*int x=1;
        try {
            System.out.println("Before divide");
              x = 10 / 5;

        }
        catch(NullPointerException e)
        {

            System.out.println("arithmetic exception caught");
        }
        finally
        {
            System.out.println(x);
            System.out.println("after divide");
        }*/


       // System.out.println("End of code");


        //multiple catch blocks:

       /* int []arr = new int[10];

        try{
            System.out.println(arr[20]);
        }
        catch(NullPointerException ex)
        {
            System.out.println("null exception");
        }
        catch(ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("array index out of bound in my case");

        }
        catch(Exception e)
        {
            System.out.println("caught exception");
        }


        System.out.println("End of code");*/

        try
        {
           // int x = 30/0;

            try
            {


                try
                {
                    int x = 30/0;
                    System.out.println(1);
                }
                catch(NullPointerException e2)
                {
                    System.out.println(2);
                }

            }
            catch(Exception e1)
            {
                System.out.println(3);
            }
        }
        catch(Exception e3)
        {
            System.out.println(4);
        }

        //throw new RuntimeException("Mainak is mean!!!!");

        /*try {
            helper();
        }catch(Exception e)
        {
            System.out.println("caught");
        }*/
    }
}