package task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			File file = new File("C:\\pleiades\\2022-09\\workspace\\Program1\\src\\six\\test.txt");
			File filew = new File("C:\\pleiades\\2022-09\\workspace\\Program1\\src\\six\\write.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			BufferedWriter bw = new BufferedWriter(new FileWriter(filew, true));
			String data;
			while ((data = br.readLine()) != null) {
				System.out.println(data);

			}
			bw.write(data);
			bw.newLine();

			br.close();
			bw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
