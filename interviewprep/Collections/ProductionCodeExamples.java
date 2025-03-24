package CollectionsAndGenerics;

import java.util.*;

public class ProductionCodeExamples {

    public static void main(String[] args) {
        //Example list of cricketers
        List<String> cricketers = Arrays.asList("Virat Kohli",
                "Rohit Sharma",
                "Jasprit Bumrah",
                "Ravindra Jadeja",
                "Sachin Tendulkar",
                "MS Dhoni",
                "Shubman Gill",
                "Rishabh Pant",
                "Pat Cummins",
                "Steve Smith",
                "Mitchell Starc",
                "Ricky Ponting",
                "Ben Stokes",
                "Joe Root",
                "James Anderson",
                "Babar Azam",
                "Shaheen Afridi",
                "Brian Lara",
                "Kagiso Rabada");




        // 1. sort alphabetically (natural ordering)
        Collections.sort(cricketers);
        System.out.println(cricketers);

        // 2. custom soring based on length of name
//        Collections.sort(cricketers, Comparator.comparingInt(String::length));
//        System.out.println(cricketers);

        // 3. sorting in descending order
//        cricketers.sort(Collections.reverseOrder());
//        System.out.println(cricketers);

        // 4. Binary Search
        // list should be sorted in ascending order
//        int index  = Collections.binarySearch(cricketers,"Babar Azam" );
//        System.out.println(index);

        // 5. Reversing the list
//        Collections.reverse(cricketers);
//        System.out.println(cricketers);

        // 6. shuffling the list
//        Collections.shuffle(cricketers);
//        System.out.println(cricketers);

        // 7. swapping
//        Collections.swap(cricketers,0,13);
//        System.out.println(cricketers);


        // 8. creating unmodifiable list
        List<String> unmodifiableList = Collections.unmodifiableList(cricketers);
//        unmodifiableList.set(0,"ave"); // cannot add this

        // 9. finding max and min using custom comparator
        String longestName = Collections.max(cricketers, Comparator.comparingInt(String::length));
        String shortestName = Collections.min(cricketers, Comparator.comparingInt(String::length));
        System.out.println(longestName+" & "+ shortestName);

        // 10. frequency of an element
         int freq = Collections.frequency(cricketers,"Virat Kohli");
        System.out.println("Freq of 'Virat Kohli': "+freq);

        // 11. Disjoint: check if 2 lists have nothing in common
        // true -  if nothing in common
        List<String> newCricketers = Arrays.asList(/*"Virat Kohli","Brian Lara"*/);
        boolean what = Collections.disjoint(cricketers,newCricketers);
        System.out.println(what);

        // 12. copying content from one list to another
        List<String> copyCricketers = new ArrayList<>(Collections.nCopies(cricketers.size(),""));
        Collections.copy(copyCricketers,cricketers);


        // 13. replacing all values with single value
//        Collections.fill(cricketers,"Test Fill");
//        System.out.println(cricketers);

        // 14. Synchronized Collection
        Collection<String> synColl = Collections.synchronizedCollection(new ArrayList<>(cricketers));
        System.out.println(synColl);




        // Comparator chaining
        record Book(String title, int pages){};
        List<Book> books =  Arrays.asList(
                new Book("The catcher in the eye",112),
                new Book("To Kill a mockingbird",281),
                new Book("1984",328),
                new Book("The Great Gatsby",180),
                new Book("Brave New World",268),
                new Book("The Hobbit",310),
                new Book("Animal Farm",112),
                new Book("Fahrenheit 451",158),
                new Book("The Alchemist",180)
        );


        books.sort(
                Comparator.comparing(Book::pages).thenComparing(Book::title,String.CASE_INSENSITIVE_ORDER)
        );

        System.out.println(books);
    }
}
