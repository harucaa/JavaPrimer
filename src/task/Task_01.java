package task;

// 実技試験課題 #1
// 問題：while文を用いて標準出力に数字の1から10までを順に出力するJavaプログラムを作成せよ。
// なお、以下の要件を満たして実装すること。

// 新規Javaクラスを定義する
//     メインメソッドを作成し、その中で
//         整数型の変数を定義する
//         while文を用いて10回ループさせ、
//             毎度変数をprint文で出力する

class Task_01 {
	public static void main(String[] args) {
		int i = 0;
		while (i < 10) {
			System.out.println(i++);
		}
	}
}
