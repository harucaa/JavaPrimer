package task;

// 練習問題#8  Practice_08_02.java

//
//   問題（２）
//   (オプション)
//     先生・学生を表すクラスをさらに継承し、
//     大学教授を表すクラス、高校教師を表すクラスなど
//     クラスを3つ作成せよ。
//
//  先生 --- 大学教授（学部, 学科）、高校教師（部活、ホームルーム）
//  生徒 --- 大学生（学籍番号、学部、学科）、高校生（部活、ホームルーム）
// 
// faculty, department, bukatsu, homeroom, studentId

// mainでは、各クラスのメンバー一名ずつを確認する。リスト化、マップ化は、#9で。

//TODO 「1ファイルに1クラス」という指定があるので、ファイルを分割すること。
//Professor.java, HighSchoolTeacher.java, UnivStudent.java, HighSchoolStudent.java

class Professor extends Teacher81 {
	public Professor() {
	}
}

class HighSchoolTeacher extends Teacher81 {
	public HighSchoolTeacher() {
	}
}

class UnivStudent extends Student81 {
	public UnivStudent() {
	}
}

class HighSchoolStudent extends Student81 {
	public HighSchoolStudent() {
	}
}

public class Practice_08_02 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}

// 情報学部：Faculty of Informatics
//   科学情報学科Department of Computer Science
//   行動情報科学科:Department of Behavior Informatics
//   社会情報学科：Department of Socio-Information Studies