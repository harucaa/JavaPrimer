package task;

// 以下のコードの説明をする？
// 文字列の比較で、equalsと==や!=との違い。
//

public class Practice_01B {

	public static void main(String[] args) {

		String myName1 = "伊藤";
		String myName2 = "加藤";
		String myName3 = "加藤";

		if (myName2 == myName3) {
			System.out.println("== 一致");
		}

		if (myName2.equals(myName3)) {
			System.out.println("equals 一致");
		}

		myName2 = myName2 + "!";
		myName3 = myName3 + "!";

		if (myName2 == myName3) {
			System.out.println("== 一致");
		}

		if (myName2.equals(myName3)) {
			System.out.println("equals 一致");
		}

	}
}
