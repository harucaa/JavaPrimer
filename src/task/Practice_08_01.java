package task;

//練習問題#8  Practice_08_01.java

// 問題（１）
//   練習#7のクラスPersonを継承し、
//
//   「学生」を表すクラスを作成せよ。
//      「学年」を表すフィールドを追加し、getter/setterを作成、
//      コンストラクタで必ず代入されるようにせよ。
//
//   「先生」を表すクラスを作成せよ。
//      「担当科目」を表すフィールドを追加し、getter/setterを作成、
//      コンストラクタで必ず代入されるようにせよ。
//      オーバーライドを使用して、条件文により20歳以下の年齢をエラーにせよ。
//
//  作成したこれらのクラスで実行を確認すること。
//
// main部分、先走ってリスト化して#9(1)の内容になってしまったので、元に戻すか。

public class Practice_08_01 {

	public static void main(String[] args) {
		Student81[] students;
		students = new Student81[2];
		Teacher81[] teachers;
		teachers = new Teacher81[2];

		students[0] = new Student81("Naohiro Tsuji", 3);
		students[1] = new Student81("Miku Hatsune", 6);
		for (Student81 student : students) {
			System.out.println("Name: " + student.name);
			System.out.println("Grade: " + student.grade);
			System.out.println("Age: " + student.age);
			System.out.println();
		}

		teachers[0] = new Teacher81("山田太郎", "物理", 45);
		teachers[1] = new Teacher81("大木晴加", "英語", 19);
		for (Teacher81 teacher : teachers) {
			System.out.println("氏名: " + teacher.name);
			System.out.println("担当科目: " + teacher.subject);
			System.out.println("年齢: " + teacher.age);
			System.out.println();
		}

	}
}
