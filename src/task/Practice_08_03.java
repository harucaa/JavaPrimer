package task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

// 練習問題#8  Practice_08_03.java

//練習問題 #8のあとの「お題」
//
//Person83.java
//人間クラスPerson83を作る。年齢と氏名を持つ。
//コンストラクタ、getter/setterを持つ。
//
//Student83.java
//Person83を継承した学生クラスStudent83を作る。年齢と氏名を継承。
//コンストラクタ、getter/setterを持つ。
//
//Practice_08_03.java
//指定ファイル（student_info83.csv）から学生の情報（カンマ区切り）を学生クラスに読み込む。
//学籍番号をキーにして学生クラスのデータをリストに収容。
//リストを空白区切りに変更、コメントを付けてファイル（.txt）に出力。

//元の出題
//  指定ファイルを読み込み、
//  各行ごとが学生の情報を表していると仮定
//  カンマ区切りで　学籍番号　年齢　氏名
//  ArrayListに格納
//
//  学生クラスと、その親クラスとして人間クラスを作成
//  それぞれにメンバー変数と getter/setter を作成
//
//  リストをファイルに出力
//    空白区切りにしてみる
//    コメントもつける（コメントをメンバー変数に追加。）

public class Practice_08_03 {

	public static ArrayList<Student83> openFile(String fileName) {
		ArrayList<Student83> students = new ArrayList<Student83>();
		File file = new File(fileName);
		BufferedReader bf;
		try {
			bf = new BufferedReader(new FileReader(file));
			String line;
			while ((line = bf.readLine()) != null) {
				String student_info[] = line.split(",");
				String studentId = student_info[0];
				int age = Integer.parseInt(student_info[1]);
				String name = student_info[2];
				Student83 student = new Student83(studentId, age, name);
				String comment;
				if (student_info.length == 4) {
					comment = student_info[3];
					student.setComment(comment);
				}
				students.add(student);
			}
			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return students;
	}

	public static void SaveInfo(String fileName, ArrayList<Student83> students) {
		File file = new File(fileName);
		BufferedWriter bf;
		try {
			bf = new BufferedWriter(new FileWriter(file));
			String line;
			for (Student83 student : students) {
				line = student.getStudentId() + " "
						+ "\"" + student.getName() + "\" "
						+ student.getAge() + " "
						+ "\"" + student.getComment() + "\"";
				bf.write(line);
				bf.newLine();
			}
			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	// HashMapだったら、studentIdをキーにして検索できる。  students.contains(studentId)
	// ここでは、forループを回し、getStudentId()でArrayListから取り出して比較している。
	public static void AddComment(String fileName, ArrayList<Student83> students) {
		File file = new File(fileName);
		BufferedReader bf;
		try {
			bf = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String line;
			// コメントファイルの各行をカンマ区切りで読み込み、
			while ((line = bf.readLine()) != null) {
				String studentComment[] = line.split(",");
				// インスタンス化してある各学生について、
				for (Student83 student : students) {
					if (student.getStudentId().equals(studentComment[0])) {
						// コメントファイルに学籍番号が一致するエントリーがあったら、コメント更新
						String curComment;
						String addComment;

						// コメント + 追加コメント-> "コメント、追加コメント"
						// コメント + 追加コメント"" or 追加エントリーなし-> "コメント"
						// null + 追加コメント-> "追加コメント"
						// null + 追加コメント"" or 追加エントリーなし-> "-なし-"
						//						
						// 元のコメントがnullの場合、空文字に
						if (student.getComment() == null) {
							curComment = "";
						} else {
							curComment = student.getComment();
						}
						// 追加コメントエントリーがある場合
						if (studentComment.length == 2) {
							// 各エントリーは、学籍番号,コメント の形式
							addComment = studentComment[1];
						} else {
							// エントリーはあるけどコメントがない
							addComment = "";
						}
						String sep = "";
						if (curComment != "") {
							if (addComment != "") {
								sep = "、";
							} else {
								sep = "";
							}
						} else {
							if (addComment == "") {
								// 追加エントリーにコメントが無く、さらに元のコメントもない場合、
								curComment = "-なし-";
							}
						}
						student.setComment(curComment + sep + addComment);
					}
				}
			}
			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static void PrintInfo(ArrayList<Student83> students) {
		for (Student83 student : students) {
			System.out.print("学籍番号: " + student.getStudentId());
			System.out.print("  年齢: " + student.getAge());
			System.out.println("  氏名: " + student.getName());
			System.out.println("コメント: " + student.getComment());
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String srcFile = "IN/student_info83.csv";
		String dstFile = "OUT/student_info83.txt";
		String cmtFile = "IN/student_comment83.csv";

		ArrayList<Student83> students = openFile(srcFile);
		System.out.println(srcFile + " からデータを読込中です。");
		PrintInfo(students);
		AddComment(cmtFile, students);
		System.out.println("コメントを " + cmtFile + " から読み込み、追加します。");
		PrintInfo(students);
		System.out.println("コメント付きで " + dstFile + " に保存します。");
		SaveInfo(dstFile, students);
		System.out.println("処理が終了しました。");
	}

}

// 情報学部：Faculty of Informatics
//   科学情報学科Department of Computer Science
//   行動情報科学科:Department of Behavior Informatics
//   社会情報学科：Department of Socio-Information Studies