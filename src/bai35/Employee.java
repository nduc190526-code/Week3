package bai35;

import java.util.Scanner;

public class Employee {
     String Name;
     String dob;
     String Id;
    public Employee(String Id,String Name,String dob ){
        this.dob=dob;
        this.Id=Id;
        this.Name=Name;
    }
    public double calculateSalary(){
        return 0;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        scanner.nextLine();
        Employee[] dsNhanVien =new Employee[n];
        for(int i=0;i<n;i++){
            String line = scanner.nextLine();
            String[] parts =line.split("\"");
            String type=parts[0].trim();
            String name =parts[1];
            Scanner docSo= new Scanner(parts[2]);
            if (type.equals("F")) {
                double base = docSo.nextDouble();
                double bonus = docSo.nextDouble();
                double penalty = docSo.nextDouble();

                dsNhanVien[i] = new FulltimeEmployee("", name, "", base, bonus, penalty);

            } else if (type.equals("P")) {
                double hours = docSo.nextDouble();
                double rate = docSo.nextDouble();

                dsNhanVien[i] = new PartTimeEmployee("", name, "", hours, rate);
            }

        }
        for (Employee emp : dsNhanVien) {
            String loaiNV = "";
            if (emp instanceof FulltimeEmployee) {
                loaiNV = "Full-time";
            } else if (emp instanceof PartTimeEmployee) {
                loaiNV = "Part-time";
            }
            System.out.println(emp.Name + " - " + loaiNV + " - " + emp.calculateSalary());
        }
    }
}
class FulltimeEmployee extends Employee{
     double baseSalary;
     double bonus;
     double penalty;
public FulltimeEmployee(String Id,String Name,String dob,double baseSalary,double bonus,double penalty){
    super(Id,Name,dob);
    this.baseSalary=baseSalary;
    this.bonus=bonus;
    this.penalty=penalty;
}
@Override
    public double calculateSalary(){
    return baseSalary+(bonus-penalty);
}
}
class PartTimeEmployee extends Employee {
    double workingHours;
    double hourlyRate;
    public PartTimeEmployee(String id, String name, String dob, double workingHours, double hourlyRate) {
        super(id, name, dob);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary() {
        return workingHours * hourlyRate;
    }
}
