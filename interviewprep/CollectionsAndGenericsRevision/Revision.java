package CollectionsAndGenericsRevision;

import java.util.*;


enum Day{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

class Student implements Comparable<Student>{
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(other.getGrade(), this.getGrade());
    }

    @Override
    public String toString() {
        return name + ": " + grade;
    }
}
public class Revision {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 90));
        students.add(new Student("Charlie", 80));

        Collections.sort(students); // Sort using natural order defined in compareTo

        for (Student student : students) {
            System.out.println(student);
        }














        // EnumSet
//        EnumSet<Day> e = EnumSet.of(Day.SATURDAY,Day.SUNDAY);
//        EnumSet<Day> e = EnumSet.allOf(Day.class);
//        System.out.println(e.contains(Day.SATURDAY));



        // ArrayList & LinkedList
//        LinkedList<Integer> ll = new LinkedList<>();
//        ll.add(123);
//        ll.add(345);
//        System.out.println(ll);
    }
}
