package UnnamedPatternsAndVariables;

public class UnnamedPatternsExample {

    record Employee(String id, String name, String joinDate, String isActive, String designation){};

    public static void main(String[] args) {
        Employee newEmployee = new Employee("101","Jatin","joinDate","Yes","DSE");

        if (newEmployee instanceof Employee)
        {
            System.out.println("Yes it is intance");
        }
    }
}
