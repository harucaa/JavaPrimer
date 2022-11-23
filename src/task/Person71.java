package task;

// 練習問題 #7（１） Practice_07_01.java

//
//   練習#6のPersonクラスのフィールド全てについて、
//     getter/setterを使うよう改良し、
//     年齢に0より小さな数字を代入しようとしたら、コンソールにエラーメッセージが出力されるようにせよ。
//
//   メインメソッド作成
//     コンソールに年齢を出力する際、getterで年齢を取得するようにせよ。
//     コンストラクタを利用して、インスタンス生成時に姓名・年齢・身長・靴の数が必ず代入されるようにせよ。
//
//   Personクラスにメソッド追加
//     生まれてから1年あたり平均いくつの靴を買った/買い与えられたかを計算するメソッドを実装せよ。
//     メソッドに引数を使わないこと

public class Person71 {
	private String name; // 姓名
	private int age; // 年齢
	private float height; // 身長
	private int numOfShoes; // 靴の数

	public Person71(String name, int age, float height, int numOfShoes) {
		setName(name);
		setAge(age);
		setHeight(height);
		setNumOfShoes(numOfShoes);
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
		if (this.age < 0) {
			System.out.println("エラー：年齢は０歳以上でお願いします。");
		}
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public int getNumOfShoes() {
		return numOfShoes;
	}

	public void setNumOfShoes(int numOfShoes) {
		this.numOfShoes = numOfShoes;
	}

	// 年齢プラス１歳で計算するので、ゼロ除算は発生しない。
	public float calcShoesPerYear() {
		return (float) numOfShoes / (age + 1);
	}
}
