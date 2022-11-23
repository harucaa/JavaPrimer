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

public class Practice_08_01 {

	public static void main(String[] args) {
		Student8[] students;
		students = new Student8[2];
		Teacher8[] teachers;
		teachers = new Teacher8[2];

		students[0] = new Student8("Naohiro Tsuji", 3);
		students[1] = new Student8("Miku Hatsune", 6);
		for (Student8 student : students) {
			System.out.println("Name: " + student.getName());
			System.out.println("Grade: " + student.getGrade());
			System.out.println("Age: " + student.getAge());
			System.out.println();
		}

		teachers[0] = new Teacher8("山田太郎", "物理", 45);
		teachers[1] = new Teacher8("伊藤花子", "英語", 19);
		for (Teacher8 teacher : teachers) {
			System.out.println("氏名: " + teacher.getName());
			System.out.println("担当科目: " + teacher.getSubject());
			System.out.println("年齢: " + teacher.getAge());
			System.out.println();
		}

	}
}
