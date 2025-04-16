package Java9To23Features;

import javax.swing.text.html.Option;
import java.util.Optional;


/**
 * Features are:
 *  1. Lambda expressions
 *  2. Stream API
 *  3. Functional Interfaces -> Runnable, Callable, Comparator, ActionListener, Supplier
 *  4. Default Methods
 *  5. Optional Class
 */
public class Java8Features {


    public static void main(String[] args) {



        //without optional
        String userNameWithoutOptional = Java8Features.findUserNameById(2);

        // with optional
        Optional<String> userNameWithOptional = Java8Features.findUserNameByIdOptionalExample(2);

        // legacy way
        if(userNameWithoutOptional != null){
            // some logic
            System.out.println("From null check if: "+userNameWithoutOptional);
        }

        // java 8 optional class example
        userNameWithOptional.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("UserNameNotFound")
        );

        userNameWithOptional.map(u -> u.toUpperCase()).ifPresent(System.out::println);
    }

    public static String findUserNameById(int id){

        if(id==0)
            return null;  // simulate database lookup
        else
            return "Aman";


    }

    public static Optional<String> findUserNameByIdOptionalExample(int id){

        if(id==0)
            return Optional.empty();  // simulate database lookup
        else
            return Optional.of("Aman");


    }
}
