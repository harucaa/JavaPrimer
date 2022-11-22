package task;

// 実技試験課題 Task #03 (2022-11-10)
// to display IN/task.txt

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// 1. クラス作成
class TargetFile {
	// 1-a. File型のメンバー変数file
	File file;

	// 1-b. File型の変数を引数に取るコンストラクター
	public TargetFile(File file) {
		this.file = file;
	}

	// 1-c. ファイルの読み込み、表示を行うメソッド
	void display(File file) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが無いよ！");
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

class Task_03 {
	// 2. mainメソッドを定義
	public static void main(String[] args) {
		File file = new File("IN/task_03.txt");
		// 2-a. (1)で作成したクラスをnewで初期化
		TargetFile tf = new TargetFile(file);
		// 2-b. (1-c)で定義したメソッドを呼び出す。
		tf.display(file);
	}
}
