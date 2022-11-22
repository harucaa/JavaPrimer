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

class Person6 {
	// フィールド変数はpublicにしないと、他のクラスから見えない。
	public String name; // 姓名
	public int age; // 年齢
	public float height; // 身長
	public int numOfShoes; // 靴の数
}
