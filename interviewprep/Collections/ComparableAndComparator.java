package CollectionsAndGenerics;


/*
    Comparable interface is used to define the natural ordering of objects
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


// For comparator we can either implement separate class or use lambda expressions
class NameComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}


// For comparable
class Student implements Comparable<Student>{

    private String name;
    private int grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student(String name, int grade){
        this.name=name;
        this.grade = grade;
    }



    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.grade,other.grade);
    }

    @Override
    public String toString(){
        return name + ": "+grade;
    }
}

public class ComparableAndComparator {
    public static void main(String[] args) {


    List<Student> students = new ArrayList<>();

        students.add(new Student("Alice",85));
        students.add(new Student("Bob",90));
        students.add(new Student("Charlie",80));

        /* using comparable*/
//        Collections.sort(students);

        /* using comparator  using class*/
        Collections.sort(students, new NameComparator());
        System.out.println(students);
        /* using comparator using lambda */
        Collections.sort(students, (s1,s2) -> Integer.compare(s2.getGrade(),s1.getGrade()));
        System.out.println(students);




    }

}


