package task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//# 練習問題#10 

//
//## 問題（１）
//  RaktenReview.java
//  楽天市場レビューのサンプルデータについて、
//  レビュー１つ分を表すのに適切なクラスを作成せよ。
//
//  Practice_10.java
//  メインメソッドでデータ(TSV形式)の全てを読み込み、全データを適切なListあるいはMapに収納せよ。
//
//## 問題（２）
//ラベル 評価ポイント(☆の数):特徴量(今はとりあえず1つだけ)=レビューの文字数
//1 0:12
//5 0:22
//2 0:18
//⋮
//
//ListあるいはMapに収納されたレビュー全てを、上のようなLIBSVM形式で書き出せ。

public class Practice_10 {

	public static ArrayList<RakutenReview> readReviews(String filename) {
		File file = new File(filename);
		ArrayList<RakutenReview> reviews = new ArrayList<RakutenReview>();
		BufferedReader bf;

		try {
			bf = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String line;
			while ((line = bf.readLine()) != null) {
				String review_info[] = line.split("\t");
				if (!(line.contains("score"))) {
					int score = Integer.parseInt(review_info[1]);
					int commentLength = review_info[2].length();
					RakutenReview review = new RakutenReview(score, commentLength);
					reviews.add(review);
				}
			}
			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return reviews;

	}

	public static void exportLIBSVM(String filename, ArrayList<RakutenReview> reviews) {
		File file = new File(filename);
		BufferedWriter bf;

		try {
			bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
			String line;
			for (RakutenReview review : reviews) {
				line = review.getScore() + " 0:" + review.getCommentLength();
				bf.write(line);
				bf.newLine();
			}
			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static void displayInfo(ArrayList<RakutenReview> reviews) {

		for (RakutenReview review : reviews) {
			System.out.print("星:" + review.getScore());
			System.out.print(" - " + review.getCommentLength() + "文字");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String srcFile = "pocket/rakuten_review.csv";
		String dstFile = "pocket/rakuten_review_LIBSVM.txt";

		ArrayList<RakutenReview> reviews = readReviews(srcFile);
		System.out.println(srcFile + " からデータを読込中です。");

		displayInfo(reviews);

		exportLIBSVM(dstFile, reviews);

		System.out.println("\n処理が終了しました。");

	}
}

//## 補足
//
//区切り文字(TSVなら\t)で区切られた文字列を分割するときには、String#splitを使う。
//
//正規表現を使う方法なんかもある。例によって自分で考えて好きにやろう。
//
//Stringからintに変換するときは、キャストでなくInteger#parseIntを使う。
//(doubleに変換するときも似たような感じ)
