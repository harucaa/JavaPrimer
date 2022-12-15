package task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//練習問題#5  Practice_05_02.java
//以下のようなことを行うプログラムを適当なクラスのメインメソッド内に実装せよ。
//
//（２）
//ディレクトリ中の複数ファイルから、別のディレクトリへの書き出し、及びコンソール出力。

public class Practice_05_02 {
	public static void main(String[] args) {
		String srcDirName = "IN";
		String destDirName = "OUT4";

		File destDir = new File(destDirName);

		File srcDir = new File(srcDirName);
		try {
			if (srcDir.exists()) {
				System.out.println("Files in " + srcDir + "/:");
			} else {
				throw new NullPointerException("no such directory: " + srcDir);
			}
		} catch (NullPointerException e) {
			System.out.println(e);
			return;
		}

		String[] srcFiles = srcDir.list();

		// 標準forで書くとこうなる。
		//		for (int i = 0; i < srcFiles.length; i++) {
		//			String srcFile = srcFiles[i];
		//			System.out.println((i + 1) + ":    " + srcFile);
		//		}

		// 拡張for文    srcFilesの中の(:)srcFileについて(for)、{処理する}と書けてわかりやすい。
		// 標準for文だと、コンピューター的。拡張for文は自然言語（英語）的。
		int i = 1;
		for (String srcFile : srcFiles) {
			System.out.println("  " + i++ + ":  " + srcFile);
		}
		//
		System.out.println();

		try {
			destDir.mkdir();
			for (String srcFile : srcFiles) {
				BufferedReader bReader = new BufferedReader(new FileReader(new File(srcDirName + "/" + srcFile)));
				BufferedWriter bWriter = new BufferedWriter(new FileWriter(new File(destDirName + "/" + srcFile)));
				String line;
				System.out.println("====" + srcDirName + "/" + srcFile + " ======>>");
				while ((line = bReader.readLine()) != null) {
					System.out.println(line);
					bWriter.write(line);
					bWriter.newLine();
				}
				System.out.println("<<======" + srcDirName + "/" + srcFile + " ====\n");
				bReader.close();
				bWriter.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File or directory not find!");
			System.out.println(e);
		} catch (IOException e) {
			System.out.println("I/O error!");
			System.out.println(e);
		}
	}
}
