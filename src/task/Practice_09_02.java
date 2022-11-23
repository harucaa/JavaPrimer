package task;

// 練習問題#9  Practice_09_02.java
//
//   問題（２）
//
//    練習#8のクラス(Student8)を使い、
//      学生を表すクラスのメインメソッドで、
//        学籍番号をキーに、学生を値に格納するMapを作成し、適当な学生4名(架空可)を格納せよ。
//        Mapから任意の学籍番号を持つ学生を取り出し、その名前と学年をコンソールに出力せよ。

import java.util.HashMap;

public class Practice_09_02 {

	public static void main(String[] args) {
		HashMap<Integer, Student8> students = new HashMap<>();

		students.put(20220100, new Student8("Naohiro Tsuji", 2));
		students.put(20220112, new Student8("Miku Hatsune", 6));
		students.put(20220116, new Student8("Akito Shinonome", 3));
		students.put(20220121, new Student8("Akito Shinonome", 3));

		int studentId = 20220100;
		System.out.print(studentId + ": " + students.get(studentId).getName());
		System.out.println("  学年：" + students.get(studentId).getGrade());

		studentId = 20220112;
		System.out.print(studentId + ": " + students.get(studentId).getName());
		System.out.println("  学年：" + students.get(studentId).getGrade());
	}
}
