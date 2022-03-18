package shiyan;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;


class Employee implements Comparable{
	int salary=0 ;
	String name ;
	String date;
	Employee (String n, int s , String i) {
		this.salary=s ; 
		this.name=n ; 
		this.date=i;
	}
	public String getname ( ) {
		return name;
	}
	public String getdate () {
		return date;
	}
	@Override
	public int compareTo(Object o) {
	//TODO Auto-generated method stub
		Employee em=(Employee) o;
		return ( this.salary-em.salary) ;
	}
}


class NameComparator implements Comparator<Employee>{
	public int compare (Employee a, Employee b){

		String nameA = a.getname ( ) ;
		String nameB = b.getname ( ) ;
		return nameA. compareTo (nameB);
	}

}

class DataComparator implements Comparator<Employee>{
	public int compare (Employee a, Employee b){
		String dateA = a.getdate();
		String dateB = b.getdate();
		return dateA.compareTo (dateB);
	}
}


public class EmployeeTreeSet{
	public static void main (String[] args) {
		TreeSet<Employee>sortBySalary=new TreeSet<Employee>();
		Employee em0 , em1 , em2 , em3 , em4 , em5 , em6 , em7 , em8 , em9;
		em0=new Employee("张三",3000,"2020/4/29");
		em1=new Employee("李四",3200,"2020/12/6");
		em2=new Employee("王五",3400,"2020/10/15");
		em3=new Employee("花花",2800,"2020/11/26");
		em4=new Employee("李白",5000,"2020/5/3");
		em5=new Employee("杜甫",4500,"2019/12/13");
		em6=new Employee("蒲松龄",4000,"2020/8/7");
		em7=new Employee("成龙",15000,"2020/7/27");
		em8=new Employee("马云",10000,"2019/9/19");
		em9=new Employee("张华",3000,"2020/3/17");
		sortBySalary.add(em0);
		sortBySalary.add(em1);
		sortBySalary.add(em2);
		sortBySalary.add(em3);
		sortBySalary.add(em4);
		sortBySalary.add(em5);
		sortBySalary.add(em6);
		sortBySalary.add(em7);
		sortBySalary.add(em8);
		sortBySalary.add(em9);
		System.out.println("按工资排序");
		Iterator<Employee>es=sortBySalary.iterator();
		while (es.hasNext()){
			Employee ems=es.next();
			System.out.println(" "+ems.name +" "+ems. date+" "+ems.salary) ;
		}
		NameComparator comp = new NameComparator();
		SortedSet<Employee> sortByname = new TreeSet<Employee>(comp);
		sortByname.add(em0);
		sortByname.add(em1);
		sortByname.add(em2);
		sortByname.add(em3);
		sortByname.add(em4);
		sortByname.add(em5);
		sortByname.add(em6);
		sortByname.add(em7);
		sortByname.add(em8);
		sortByname.add(em9);
		System.out.println();
		System.out.println ("按姓名排序");
		Iterator<Employee>en=sortByname.iterator();
		while(en.hasNext()){
			Employee emn=en.next();
			System.out.println (" "+emn.name+" "+emn.date+" "+emn.salary) ;
		}
		DataComparator comp1 = new DataComparator();
		SortedSet<Employee> sortBydate = new TreeSet<Employee>(comp1) ;
		sortBydate.add(em0);
		sortBydate.add(em1);
		sortBydate.add(em2);
		sortBydate.add(em3);
		sortBydate.add(em4);
		sortBydate.add(em5);
		sortBydate.add(em6);
		sortBydate.add(em7);
		sortBydate.add(em8);
		sortBydate.add(em9);
		System.out.println();
		System.out.println("按雇佣日期排序");
		Iterator<Employee>da=sortByname.iterator();
		while(da.hasNext()){
			Employee dat=da.next();
			System.out.println(" "+dat.name+" "+dat.date+" "+dat.salary) ;
		}
	}
}

