package task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Practice_05_02h {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String srcDirName = "IN";
		String destDirName = "OUT";

		File destDir = new File(destDirName);

		File srcDir = new File(srcDirName);
		try {
			if (srcDir.exists()) {
				System.out.println("Files in" + srcDir + "/:");
			} else {
				throw new NullPointerException("no such director:" + srcDir);
			}
		} catch (NullPointerException e) {
			System.out.println(e);
			return;
		}

		String[] srcFiles = srcDir.list();
		int i = 1;
		for (String srcFile : srcFiles) {
			System.out.println(" " + i++ + ": " + srcFile);

		}
		System.out.println();

		try {
			destDir.mkdir();
			for (String srcFile : srcFiles) {
				BufferedReader br = new BufferedReader(new FileReader(new File(srcDirName + "/" + srcFile)));
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File(destDirName + "/" + srcFile)));
				String line;
				System.out.println("====" + srcDirName + "/" + srcFile + "======>>");
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					bw.write(line);
					bw.newLine();
				}
				System.out.println("<<======" + srcDirName + "/" + srcFile + "====\n");
				br.close();
				bw.close();
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
