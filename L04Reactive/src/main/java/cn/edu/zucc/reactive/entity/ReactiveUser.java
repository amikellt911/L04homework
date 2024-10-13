package cn.edu.zucc.reactive.entity;


public class ReactiveUser {
    private long id;
    private String name;

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
	public ReactiveUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReactiveUser(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "ReactiveUser [id=" + id + ", name=" + name + "]";
	}
    
}
