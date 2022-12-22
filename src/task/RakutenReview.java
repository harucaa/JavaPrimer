package task;

//# 練習問題#10 
//
//## 問題（１）
//  RaktenReview.java
//  楽天市場レビューのサンプルデータについて、
//  レビュー１つ分を表すのに適切なクラスを作成せよ。

public class RakutenReview {
	private int score;
	private int commentLength;

	public RakutenReview(int score, int commentLength) {
		this.score = score;
		this.commentLength = commentLength;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCommentLength() {
		return commentLength;
	}

	public void setCommentLength(int commentLength) {
		this.commentLength = commentLength;
	}
}