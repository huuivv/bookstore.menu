package bookstore.presentation;

import java.util.Scanner;

// 콘솔 입출력
public class Console {
	private static Scanner sc = new Scanner(System.in);

	// 문자열을 입력한다.
	public static String nextLine() {
		return sc.nextLine().trim();
	}

	// 숫자를 입력한다.
	public static int nextInt() {
		int input = -1;
		try {
			input = Integer.parseInt(nextLine());
		} catch (NumberFormatException e) {
		}
		return input;
	}

	// 출력한다.
	public static void println(String str) {
		System.out.println(str);
	}

	// 출력한다.
	public static void println(Object obj) {
		System.out.println(obj);
	}

	// 입력 유도 메세지를 출력한다.
	public static void in(String str) {
		System.out.print(str+"\n▶  ");
	}
	
	// 에러를 출력한다.
	public static void err(String str){
		System.out.println("실패] "+str);
	}
}
