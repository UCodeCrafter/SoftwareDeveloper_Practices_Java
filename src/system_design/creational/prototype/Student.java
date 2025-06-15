package system_design.creational.prototype;

public class Student implements Prototype {
	private long roleNo;
	private String name;
	private String section;
	private long age;
	private String address;
	
	public Student(long roleNo, String name, String section, long age, String address) {
		super();
		this.roleNo = roleNo;
		this.name = name;
		this.section = section;
		this.age = age;
		this.address = address;
	}
	
	public long getRoleNo() {
		return roleNo;
	}

	public String getName() {
		return name;
	}

	public String getSection() {
		return section;
	}

	public long getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public Student clone() {
		return new Student(this.roleNo, this.name, this.section, this.age, this.address);
		
	}
	
	
	
	

}
