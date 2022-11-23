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

// main部分、リストではなく、配列。

public class Practice_07_02 {
	public static void main(String args[]) {
		Person72[] persons;
		persons = new Person72[4];

		persons[0] = new Person72("Naohiro Tsuji", 23, 170.0f, 99);
		persons[1] = new Person72("Miku Hatsune", 19, 158.2f, 999);
		persons[2] = new Person72("初音月乃瀬", 15, 133.1f, 999);
		persons[3] = new Person72("月乃瀬ミク", 22, 162.8f, 2222);

		for (Person72 person : persons) {
			System.out.println();
			System.out.println("名前：" + person.getName());
			System.out.println("年齢：" + person.getAge());
			System.out.printf("一年あたりの靴の数：%.2f%n", person.calcShoesPerYear());
		}
	}
}
