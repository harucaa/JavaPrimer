package task;

// 以下のコードの説明をする？
// 文字列の比較で、equalsと==や!=との違い。
//

public class Practice_01 {

	public static void main(String[] args) {

		String myName = "伊藤";
		//		String myName = "加藤";
		//		String myName = "佐藤";
		//		String yourName = "佐藤";

		String[] studentNames = { "伊藤", "加藤", "佐藤" };

		System.out.println("my name is " + myName);

		for (int i = 0; i < studentNames.length; i++) {
			System.out.println(i + ":" + studentNames[i]);

			if (myName != studentNames[i]) {
				System.out.println("ありえない？");
			} else if (myName.equals(studentNames[i])) {
				System.out.println("同じ名前: " + myName);
			}
			System.out.println("");
		}
		System.out.println("end");

	}
}
