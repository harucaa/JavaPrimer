package task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//練習問題#5  Practice_05_01.java
//以下のようなことを行うプログラムを適当なクラスのメインメソッド内に実装せよ。
//
//（１）
//適当なテキストファイル1つを読み込み、
//内容をコンソールに出力する
//内容を適当な別のファイルに出力する

public class Practice_05_01 {

	public static void main(String[] args) {
		//		String fileToRead = "IN/test.txt";
		//		String fileToWrite = "OUT/test5.txt";

		@SuppressWarnings("resource")
		Scanner stdIn = new Scanner(System.in);
		System.out.println("Please input file names.");
		System.out.print("File to read in the IN directory: ");
		String srcFile = "IN/" + stdIn.next();
		System.out.print("File to write in the OUT directory: ");
		String destFile = "OUT/" + stdIn.next();

		try {
			BufferedReader bReader = new BufferedReader(new FileReader(new File(srcFile)));
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(new File(destFile)));
			String line;
			while ((line = bReader.readLine()) != null) {
				System.out.println(line);
				bWriter.write(line);
				bWriter.newLine();
			}
			bReader.close();
			bWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not find!");
			System.out.println(e);
		} catch (IOException e) {
			System.out.println("I/O error!");
			System.out.println(e);
		}
	}
}
