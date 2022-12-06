package task;

public class Person83 {
	private String name; // 姓名
	private int age; // 年齢

	Person83() {
	}

	Person83(String name, int age) {
		setName(name);
		setAge(age);
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
