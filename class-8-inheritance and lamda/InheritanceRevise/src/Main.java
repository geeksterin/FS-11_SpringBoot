// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        //Dog d1 = new Dog();
        Animal d1 = new Dog("Golden");

        d1.produceSound();
        //d1.getBreed(); //not possible as d1 ref is of animal class and it has no getBread method


        Dog d2 = new Dog("German");

        d2.produceSound();
        System.out.println(d2.getBreed());
        //System.out.println(d2.setBreed("Labra"));


        Male mard = new Male();
        mard.saySomething();

        Human mard2 = new Male();
        mard2.saySomething();



    }
}