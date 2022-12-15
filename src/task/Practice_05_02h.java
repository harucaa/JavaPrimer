package task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Practice_05_02h {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String srcDirName = "IN";
		String destDirName = "OUT";

		File srcDir = new File(srcDirName);
		System.out.println("Files in" + srcDir + "/:");

		String[] srcFiles = srcDir.list();
		int i = 1;
		for (String srcFile : srcFiles) {
			System.out.println(" " + i++ + ": " + srcFile);

		}
		System.out.println();

		File destDir = new File(destDirName);

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
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
