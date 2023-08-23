// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static Integer helper(Integer x)
    {
        System.out.println("Inside helper");
        return 2*x;
    }
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        int x = 10;
        for (int i = 1; i <= x; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }

        if(2==3)//sample
        {
            System.out.println("if true");
        }
        else {
            System.out.println("if false");
        }


        Integer y = helper(10);
        System.out.println(y);
    }
}