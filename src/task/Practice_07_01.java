package task;

// 練習問題 #7（１） Practice_07_01.java

//
//   練習#6のPersonクラスのフィールド全てについて、
//     getter/setterを使うよう改良し、
//     年齢に0より小さな数字を代入しようとしたら、コンソールにエラーメッセージが出力されるようにせよ。
//
//   メインメソッド作成
//     コンソールに年齢を出力する際、getterで年齢を取得するようにせよ。
//     コンストラクタを利用して、インスタンス生成時に姓名・年齢・身長・靴の数が必ず代入されるようにせよ。
//
//   Personクラスにメソッド追加
//     生まれてから1年あたり平均いくつの靴を買った/買い与えられたかを計算するメソッドを実装せよ。
//     メソッドに引数を使わないこと

public class Practice_07_01 {
	public static void main(String args[]) {
		Person71 p1 = new Person71("Naohiro Tsuji", 23, 170.0f, 99);

		// 小数点以下２桁にフォーマットして出力、改行
		System.out.printf("一年あたりの靴の数：%.2f%n", p1.calcShoesPerYear());
	}
}
// 改行コードの機種依存を吸収する%n
//   Windows系OS:「\r\n(CR+LF)」
//   Unix系OS全般、Mac OS X:「\n(LF)」
//   古いMac OS:「\r(CR)」