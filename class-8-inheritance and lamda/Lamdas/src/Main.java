// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        //using class overriding to call the sum method

        ITest i1 = new Test1();
        i1.sum(2,3,4);

        //Anonymous class : Its a class without No name;

        ITest i2 = new ITest()
        {
            @Override
            public int sum(int a, int b, int c) {
                return 2*(a+b+c);
            }
        };

        int ansAnonymous = i2.sum(2,3,4);
        System.out.println(ansAnonymous);


        System.out.println("## Lambda ##");

        //third way :

        //Only works in case of functional interface :

       /* ITest i3 = (int a , int b, int c)-> {

            return 3*(a+b+c);
        };*/


       /* ITest i3 = (a , b, c)-> {

            System.out.println("Inside lamda defined method");
            return 3*(a+b+c);
        };*/

        ITest i3 = (a , b, c)-> 3*(a+b+c);


        int ansLambda = i3.sum(1,2,3);
        System.out.println(ansLambda);

    }
}