package CollectionsAndGenerics;

/*
specially designed to work with enumeration

EnumSet:
Efficiency: EnumSet is implemented internally as a bit vector, which makes it very fast and efficient in terms of both time and space when compared to other Set implementations like HashSet or TreeSet.
Type-Safety: It can only contain elements of the specified enum type, ensuring type safety.
Iteration Order: Elements are maintained in their natural order (the order in which the enum constants are declared).
Null Handling: EnumSet does not allow null elements.


EnumMap:
Efficiency: EnumMap is implemented using arrays, which makes it very fast and memory-efficient compared to other Map implementations like HashMap or TreeMap.
Type-Safety: It ensures type safety by requiring the keys to be of the specified enum type.
Iteration Order: Entries are maintained in the natural order of their keys (the order in which the enum constants are declared).
Null Handling: EnumMap does not allow null keys, but it allows null values.
 */

import java.util.EnumMap;
import java.util.EnumSet;

enum Day{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumSetAndEnumMap {
    public static void main(String[] args) {

        EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Weekend: "+weekend);

        EnumSet<Day> workDays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        System.out.println("Workdays: "+workDays);

        EnumSet<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("All days: "+allDays);


        EnumMap<Day,String> activityMap = new EnumMap<>(Day.class);

        activityMap.put(Day.MONDAY,"Gym");
        activityMap.put(Day.TUESDAY, "Swimming");
        activityMap.put(Day.WEDNESDAY, "Running");

        for(Day day: Day.values()){
            System.out.println(day + ": "+activityMap.getOrDefault(day, "No activity"));
        }
    }
}