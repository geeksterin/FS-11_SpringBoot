import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();

        arr.add(22);
        arr.add(21);
        arr.add(29);
        arr.add(16);
        arr.add(25);

        Stream<Integer> arrStream  = arr.stream();

        //print all numbers of arrayList

        for(int num : arr)
        {
            System.out.println(num);
        }

        System.out.println("-------------------");
        //print all the numbers in my arrStream

        //arrStream.forEach(num-> System.out.println(num));

        //System.out.println(arrStream);

        //Stream<Integer> sortedStream = arrStream.sorted();


        //sortedStream.forEach(num-> System.out.println(num));

        //System.out.println(sortedStream.count());


        //arrStream.sorted().forEach(num-> System.out.println(num));

      /* arrStream.forEach(num -> System.out.println(num));

        arrStream.forEach(num->{
            System.out.println("Mainak start");
            System.out.println(num);
            System.out.println("Mainak end");
            System.out.println();
        });*/

        //changing a stream does not change the source


        // map filter and reduce

        //double each element of the arrayList

       /* for(int index = 0; index < arr.size();index++)
        {
            arr.set(index,arr.get(index)*2);
        }*/


        // double each element in streams:

        /*Stream<String> streamString = arrStream.map(num -> "Mainak" + num);
        streamString.forEach(num-> System.out.println(num));*/


        //arrStream.map(num -> num*2).forEach(num-> System.out.println(num));

        //sort the above list in one line :

       // arrStream.map(num -> num*2).sorted().forEach(num-> System.out.println(num));


        //filtering on stream


        //print all odd numbers of the arraylist:

       /* for(Integer num : arr)
        {
            if(num%2==1)
            {
                System.out.println(num);
            }
        }*/


        //arrStream.filter(num->(num%2==1)).forEach(num-> System.out.println(num));


        //arrStream.filter(num->(num%2==1)).forEach(num-> System.out.println(num));


        //

        //todo :print in reverse

        System.out.println(arrStream.filter(num->num%2==1).
                map(num->num*num).
                reduce(0,(accumulator,num)->accumulator + num));


        //reduce

        //sum of all elements in the arrayList :

       /* Integer sum  = 0;

        for (Integer num : arr)
        {
            sum = sum + num;
        }

        System.out.println(sum);*/


        //Integer sum = arrStream.reduce(0,(accumulator,num)->accumulator + num);

        Integer product = arrStream.reduce(1,(accumulator,num)->accumulator * num);


        System.out.println(product);


    }
}