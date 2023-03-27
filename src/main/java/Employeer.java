import java.util.*;
public class Employeer {
    
    private String name;
    private double salary;
    public Employeer (){
    }
    public Employeer (String name,double salary){
        this.name = name;
        this.salary = salary;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
	}
    
    public static void main(String[] args) {
    	List<Employeer> employees = new ArrayList<>();
    	employees.add(new Employeer("小明", 2500));
    	employees.add(new Employeer("小军", 8000));
    	employees.add(new Employeer("小红", 100000));
    	for(Employeer e : employees){
            double suilv = 0;
            double shouru = e.getSalary() - 3500;
        	if(shouru <= 0)
				suilv = 0;
        	else if(shouru <= 1500)
				suilv = shouru * 0.03;
        	else if(shouru <= 4500)
				suilv = shouru * 0.1 - 105;
        	else if(shouru <= 9000)
				suilv = shouru * 0.2 - 555;
        	else if(shouru <= 35000)
				suilv = shouru * 0.25 - 1005;
        	else if(shouru <= 55000)
				suilv = shouru * 0.3  - 2755;
        	else if(shouru <= 80000)
				suilv = shouru * 0.35 - 5505;
        	else
				suilv = shouru * 0.45 - 13505;
        	System.out.println(e.getName() + "应该缴纳的个人所得税是：" + String.format("%.1f", suilv));
    	}


	}
}

