import java.io.Serializable;
import java.util.Scanner;

public class Employee implements Serializable {
    private String name;
    private int empID;
    private double hourlyIncome;

    public Employee(){
        name = "";
        empID = 0;
        hourlyIncome = 0;

    }

    public void setName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter The name: ");
        name = input.next();

    }

    public void setEmpID() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter The EMP ID: ");
        empID = input.nextInt();

    }

    public String getName() {
        return name;
    }

    public int getEmpID() {
        return empID;
    }

    public double getHourlyIncome() {
        return hourlyIncome;
    }

    public void setHourlyIncome() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter The Hourly Income: ");
        hourlyIncome = input.nextDouble();
    }

    public Employee(String name, int empID, double hourlyIncome){
        this.name = name;
        this.empID = empID;
        this.hourlyIncome = hourlyIncome;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s (ID: %d ), Income: %f\n\n", name, empID, hourlyIncome);
    }
}
