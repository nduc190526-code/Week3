package bai31;
 class Employee extends Person{
    double salary;
    public Employee(){
        super("Nguyen Ngoc Duc");
        System.out.println("2. Employee is created");
    }
}
 class Manager extends Employee{
    public String department;
    public Manager(){System.out.println("3. Manager is created");}
}

public class Person {
    public String name;
    public String dob;

    public Person(String name) {
        this.name=name;
        System.out.println("1. Person is created");
        }
    public static void main(String[] args) {
        Manager m = new Manager();
    }
}


