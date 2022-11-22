package task;

// 実技試験課題 #2
//課題:ファイル入出力

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// 0. 新しいクラスを作成し
//     mainメソッドを定義して、その中で以下を行うプログラムを作成せよ。
//
// 1. 適当に用意したテキストファイル1つを読み込む
//      File,FileReader, BufferedReaderを使うこと
// 2. そのテキストファイルの内容をコンソールに出力する。
// 3. そのテキストファイルの内容を適当な別のファイルに出力し保存する
//      File,FileWriter, BufferedWriterを使うこと

class Task_02 {

	public static void main(String[] args) {
		String file = "IN/test5.txt";
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(new File(file)));
			String line;
			while ((line = bReader.readLine()) != null) {
				System.out.println(line);
			}
			bReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File \"" + file + "\" not found.");
		} catch (IOException e) {
			System.out.println("Error occured in input/output operation.");
		}
	}
}
