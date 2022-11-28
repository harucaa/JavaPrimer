package task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// 練習問題#8  Practice_08_02.java

//
//   問題（２）
//   (オプション)
//     先生・学生を表すクラスをさらに継承し、
//     大学教授を表すクラス、高校教師を表すクラスなど
//     クラスを3つ作成せよ。
//
//  先生 --- 大学教授（学部, 学科）、高校教師（部活、ホームルーム）
//  生徒 --- 大学生（学籍番号、学部、学科）
// 
// faculty, department, bukatsu, homeroom, studentId

// HashMapだとソートが謎の動き。数値によってダメな時がある。TreeMapが良さげ。

public class Practice_08_02 {

	public static void main(String[] args) {

		//		HashMap<Integer, UnivStudent> students = new HashMap<>();
		Map<Integer, UnivStudent> students = new TreeMap<>();

		students.put(20220804, new UnivStudent("Naohiro Tsuji", "工学部", "電子工学科", 2));
		students.put(20220105, new UnivStudent("Miku Hatsune", "情報学部", "行動情報学科", 1));
		students.put(20220103, new UnivStudent("Akito Shinonome", "情報学部", "情報科学学科", 3));
		students.put(20220203, new UnivStudent("Honami Mochizuki", "情報学部", "情報社会学科", 4));

		System.out.println("ID指定でアクセスして表示");
		int studentId = 20220105;
		System.out.println(studentId
				+ " : " + students.get(studentId).getName()
				+ " : " + students.get(studentId).getFaculty()
				+ " : " + students.get(studentId).getDepartment()
				+ " : " + students.get(studentId).getGrade());
		System.out.println();

		System.out.println("イテレーターで取り出す。"); // すでにソート済み
		Iterator<Map.Entry<Integer, UnivStudent>> itr = students.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<Integer, UnivStudent> student = itr.next();
			System.out.println(student.getKey()
					+ " : " + student.getValue().getName()
					+ " : " + student.getValue().getFaculty()
					+ " : " + student.getValue().getDepartment()
					+ " : " + student.getValue().getGrade());
		}
		System.out.println();

		// keyでソートしたい。以下、テスト。。
		// keyの値によって、ソートが成功するときとダメな時がある。TreeMapだとソート不要。

		System.out.println("キーでソートして昇順で表示"); //
		Object[] mapkey = students.keySet().toArray();
		Arrays.sort(mapkey);
		for (Integer nKey : students.keySet()) {
			System.out.println(nKey + " : " + students.get(nKey).getName());
		}
		System.out.println();

		//  お試し中
		Map<Integer, String> mMap = new TreeMap<Integer, String>();
		// Mapにデータを格納
		mMap.put(2, "apple");
		mMap.put(99, "orange");
		mMap.put(3, "pineapple");
		//		mMap.put(3, "strawberry");
		//		mMap.put(5, "melon");

		// キーでソートする
		Object[] mapkey2 = mMap.keySet().toArray();
		Arrays.sort(mapkey2);
		for (Integer nKey : mMap.keySet()) {
			System.out.println(nKey + " " + mMap.get(nKey));
		}
		System.out.println();

		// Listでソートの方法 Stringのソート　これは正しい
		Map<String, String> map = new HashMap<>();
		map.put("Nepal", "Kathmandu");
		map.put("United States", "Washington");
		map.put("India", "New Delhi");
		map.put("England", "London");
		map.put("Australia", "Canberra");
		List<String> keyList = new ArrayList<>(map.keySet());
		keyList.sort((s1, s2) -> s1.compareTo(s2));
		for (String key : keyList) {
			System.out.println("key: " + key + ", value: " + map.get(key));
		}
		System.out.println();

		// Listでソートの方法 Integerのソート
		Map<Integer, String> map2 = new TreeMap<>();
		map2.put(1, "Kathmandu");
		map2.put(4, "Washington");
		map2.put(3, "New Delhi");
		map2.put(99, "London");
		map2.put(5, "Canberra");
		List<Integer> keyList2 = new ArrayList<>(map2.keySet());
		keyList.sort((s1, s2) -> s1.compareTo(s2));
		for (Integer key : keyList2) {
			System.out.println("key: " + key + ", value: " + map2.get(key));
		}

	}
}

// 情報学部：Faculty of Informatics
//   科学情報学科Department of Computer Science
//   行動情報科学科:Department of Behavior Informatics
//   社会情報学科：Department of Socio-Information Studies