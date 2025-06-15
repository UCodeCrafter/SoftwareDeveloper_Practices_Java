package system_design.creational.prototype;

public class MainClass {

	public static void main(String[] args) {
		Student student = new Student(1, "Uttam Modi","A" , 25, "Asansol-03");
		
		Student student2 = student.clone();
		
		System.out.println(student.hashCode() + " "+student.getName());
		System.out.println(student2.hashCode() + " "+student2.getName());
		if(student==student2)
			System.out.println("Both objects are same");
		else
			System.out.println("Both objects are not same");

	}

}
