package task;

// 練習問題#6 Practice_06.java
//
// 問題（１）人間についての以下の情報を格納することのできるクラスを書いてみよ。
//  (クラスやフィールドには適切な名前を付けること。また、適切な型を用いること。)
//
//	姓名 String name
//	年齢 int age
//	身長 float height 
//	今までに買った/買い与えられた靴の数 int numOfShoes

// 同じファイル内では、publicクラスは実行するクラス一つだけでファイル名と一致。
// 同じファイル内に記述するときは、アクセス修飾無しclass Person {}にする。
// アクセス修飾無しでも同じプロジェクト内でアクセスでき、名前が衝突する。

//  TODO 「1ファイルに1クラス」という指定があるので、ファイルを分割すること。
//  Parson6.javaへ

class Person6 {
	// フィールド変数はpublicにしないと、他のクラスから見えない。
	public String name; // 姓名
	public int age; // 年齢
	public float height; // 身長
	public int numOfShoes; // 靴の数
}

//問題（２）
//   メインメソッドで先のクラスをインスタンス化せよ。
//   また、インスタンスのフィールドにアクセスし、
//   自分についての情報を代入せよ。(年齢・身長・靴の数については任意かつ自由に粉飾可とする)
//   コンソールに自分の名前を出力せよ。

// mainメソッドを持つ実装クラスは、ファイル名と同じにする必要がある。
public class Practice_06 {
	public static void main(String args[]) {
		Person6 p1 = new Person6();
		p1.name = "Naohiro Tsuji";
		p1.age = 20;
		p1.height = 170.0f;
		p1.numOfShoes = 99;

		System.out.println(p1.name);
		//		System.out.println(p1.age);
		//		System.out.println(p1.height);
		//		System.out.println(p1.numOfShoes);
	}
}
