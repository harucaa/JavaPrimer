// ファイルから1行ずつ読み込んでコンソールに表示する
// try-catchを外してみたら、コンパイルエラーになる。
// FileReader(file)では、FileNotFoundException
// bufferedReader.readLine(), bufferedReader.close()では、IOException


package fileRW;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


class FileRead_02 {
	public static void main(String[] args) {
		File file = new File("IN/test.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = bufferedReader.readLine()) != null){
			System.out.println(line);
		}
		bufferedReader.close();
	}
}
