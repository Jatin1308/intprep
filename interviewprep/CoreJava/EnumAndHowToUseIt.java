package CoreJava;

import java.sql.SQLOutput;

enum DayOfWeek{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}


public class EnumAndHowToUseIt {

    public static void main(String[] args) {
        DayOfWeek today = DayOfWeek.MONDAY;

        System.out.println("Today is: "+today);

        String op = switch(today) {
            case MONDAY -> {
                System.out.println("Checking for monday");
                yield "Its start of the week";
            }
            default ->"Just another day";
            };
        }
    }



