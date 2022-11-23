package task;

// 練習問題#9  Practice_09_01.java
//
//   問題（１）
//
//    練習#8のクラス(Teacher8)を使い、
//      先生を表すクラスのメインメソッドで、
//        先生を収納するListを作成し、適当な先生4名(架空可)のインスタンスを格納せよ。
//        Listをループし、4名全ての先生の名前と担当教科をコンソールに出力せよ。

import java.util.ArrayList;

public class Practice_09_01 {

	public static void main(String[] args) {
		ArrayList<Teacher8> teachers = new ArrayList<Teacher8>();

		teachers.add(new Teacher8("山田太郎", "物理", 45));
		teachers.add(new Teacher8("伊藤花子", "英語", 19));
		teachers.add(new Teacher8("井伊直弼", "国語", 33));
		teachers.add(new Teacher8("米津玄師", "化学", 58));

		for (Teacher8 teacher : teachers) {
			System.out.println("氏名: " + teacher.getName());
			System.out.println("担当科目: " + teacher.getSubject());
			//			System.out.println("年齢: " + teacher.age);
			System.out.println();
		}

	}
}
