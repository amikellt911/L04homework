package cn.edu.zucc.reactivemvc.entity;


/**
 * @author longzhonghua
 * @data 2/20/2019 1:25 PM
 */


public class MVCUser {
    private long id;
    private String name;
    private int age;
    
    
	public MVCUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MVCUser(long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
