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

class Teacher81 extends Person72 {
	String subject;

	public Teacher81() {
	}

	Teacher81(String name, String subject, int age) {
		setName(name);
		setSubject(subject);
		setAge(age);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setAge(int age) {
		if (age < 20) {
			System.out.print("20歳以上でないと先生にはなれないよ");
			System.out.println("-->" + this.name);
		}
		this.age = age;
	}
}
