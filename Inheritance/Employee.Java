class Employee{
    
    String name;
    String id;
    float salary;
    
    //constructor to assign values to the above instance variables
    public Employee(String name,String id,float salary){
        this.name=name;
        this.id = id;
        this.salary = salary;
    }
    
    public void displayEmployeeDetails(){
        System.out.println("the employee details are as follows: ");
        System.out.println("name: "+name);
        System.out.println("id: "+id);
        System.out.println("salary: "+salary);
    }
}
    
class Manager extends Employee{
    int TeamSize;
    public Manager(String name,String id,float salary,int TeamSize){
        super(name,id,salary);
        this.TeamSize = TeamSize;
    }
    
    @Override
    public void displayEmployeeDetails(){
        super.displayEmployeeDetails();
        System.out.println("TeamSize: " + TeamSize);
    }
    
}

class Developer extends Employee{
    String ProgrammingLanguage;
    public Developer(String name,String id,float salary,String ProgrammingLanguage){
        super(name,id,salary);
        this.ProgrammingLanguage = ProgrammingLanguage;
    }
    
    @Override
    public void displayEmployeeDetails(){
        super.displayEmployeeDetails();
        System.out.println("Programming Language: " + ProgrammingLanguage);
    }
    
}

class Intern extends Employee{
    String Intern;
    public Intern(String name,String id,float salary,String Intern){
        super(name,id,salary);
        this.Intern = Intern;
    }
    
    @Override
    public void displayEmployeeDetails(){
        super.displayEmployeeDetails();
        System.out.println("Intern: " + Intern);
    }
    
 }
     

class Main {
    public static void main(String[] args) {
         Employ
    }
}