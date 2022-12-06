// CSV file reader
// to display CSV/rakuten_review.csv
// https://item.rakuten.co.jp/livelylife/a301523/
package fileRW;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class TargetCsvFile {
	File file;

	public TargetCsvFile(File file) {
		this.file = file;
	}

	void display(File file) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] arrayStr = line.split(",");
				for (String str : arrayStr) {
					System.out.println(str);
				}
				System.out.println();
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

class FileRead_CSV {
	public static void main(String[] args) {
		File file = new File("CSV/rakuten_review.csv");
		TargetCsvFile tf = new TargetCsvFile(file);
		tf.display(file);
	}
}
