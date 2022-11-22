package fileRW;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class FileWrite_01 {
	public static void main(String[] args) {

		try{
			// 出力先ファイルの File オブジェクトを作成
			File file = new File("OUT/test.txt");

			//BufferedWriter オブジェクトを作成(第二引数が true で追記モード)
			//FileWriter オブジェクトを Bufferedwriter でラッピング
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

			// 文字列を出力
			bw.write("出力文字列1");
			bw.newLine();
			bw.write("出力文字列2");
			bw.newLine();

			//BufferedWriter オブジェクトをクローズ
			bw.close();

		} catch(IOException e) {
			System.out.println(e);
		}
	}
}
