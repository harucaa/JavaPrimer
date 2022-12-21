package task;

public class Practice_06h {
	private String name;
	private int age;
	private float height;
	private int numOfShoes;

	private Practice_06h(String name, int age, float height, int numOfShoes) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.numOfShoes = numOfShoes;
	}

	public static void main(String[] args) {
		Practice_06h person = new Practice_06h("Haruka Oki", 20, (float) 167.2, 100);
		System.out.println(person.name);
		System.out.println(person.age);
		System.out.println(person.height);
		System.out.println(person.numOfShoes);

	}
}
