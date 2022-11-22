package task;

// 練習問題 #7（２） Practice_07_02.java

//
//   (オプション)
//    「0より小さい年齢」以外にも適当な正当性チェックを実装せよ。
//
//     例：月乃瀬という姓は実在しない、122歳より大きい年齢の人はいない…
//
//   (オプション)
//    コンソールにエラーメッセージを出力するのでなく、IllegalArgumentException例外をスローするようにせよ。

// main部分、先走ってリスト化して#9(1)の内容になってしまったので、元に戻すか。

// TODO 「1ファイルに1クラス」という指定があるので、ファイルを分割すること。
// Parson72.javaへ

class Person72 {
	public String name; // 姓名
	public int age; // 年齢
	public float height; // 身長
	public int numOfShoes; // 靴の数

	Person72() {
	}

	Person72(String name, int age, float height, int numOfShoes) {
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
		try {
			// if (this.name.contains("月乃瀬")) { // 月乃瀬を含む
			// if (this.name.endWith("月乃瀬")) { // 月乃瀬で終わる
			if (this.name.startsWith("月乃瀬")) { // 月乃瀬で始まる
				throw new IllegalArgumentException("エラー：月乃瀬さんなど、いない！");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("-->" + this.name);
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		try {
			if (this.age < 0) {
				throw new IllegalArgumentException("エラー：年齢は0歳以上でお願いします。");
			} else if (this.age > 122) {
				throw new IllegalArgumentException("エラー：年齢は122歳未満でお願いします。");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("-->" + this.name);
		}
	}

	public double getHeight() {
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

	public float calcShoesPerYear() {
		return (float) numOfShoes / (age + 1);
	}
}

public class Practice_07_02 {
	public static void main(String args[]) {
		Person72[] persons;
		persons = new Person72[4];

		persons[0] = new Person72("Naohiro Tsuji", 23, 170.0f, 99);
		persons[1] = new Person72("Taro Yamada", 153, 154.4f, 999);
		persons[1] = new Person72("Haruka Ohki", 19, 158.2f, 999);
		persons[2] = new Person72("大木月乃瀬", 15, 133.1f, 999);
		persons[3] = new Person72("月乃瀬晴加", 22, 162.8f, 2222);

		for (Person72 person : persons) {
			System.out.println();
			System.out.println("名前：" + person.getName());
			System.out.println("年齢：" + person.getAge());
			System.out.printf("一年あたりの靴の数：%.2f%n", person.calcShoesPerYear());
		}
	}
}
