package Java9To23Features;

import java.util.Optional;

public class OptionalClass {

    String userNameById(int userId){
        if (userId == 0){
            return null;
        }
        else return "Jatin";
    }

    Optional<String> userNameByIdOptional(int userId){
        if(userId==0)
            return Optional.empty();
        else return Optional.ofNullable("Jatin");
    }

    public static void main(String[] args) {

        OptionalClass op = new OptionalClass();

        // without Optional
        String uNameWithoutOptional = op.userNameById(0);
        System.out.println("Without optional: "+uNameWithoutOptional); // will print null

        // so to handle null pointer exception or nulls, we can use Optional
        Optional<String> optionalRes = op.userNameByIdOptional(0);
        optionalRes.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("UserName not found")
        );
        optionalRes.map(String::toUpperCase).ifPresent(System.out::println);




    }
}
