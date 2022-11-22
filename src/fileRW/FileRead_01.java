// ファイルから1行ずつ読み込んでコンソールに表示する
package fileRW;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


class FileRead_01 {
	public static void main(String[] args) {
		try {
			File file = new File("IN\\test.txt");
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = bufferedReader.readLine()) != null){
				System.out.println(line);
			}
			bufferedReader.close();
		} catch (FileNotFoundException e){
			System.out.println("ファイルが無いよ！");
			System.out.println(e);
		} catch (IOException e){
			System.out.println(e);
		}
	}
}
