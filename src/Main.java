import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로길이 : ");
		int num1 = sc.nextInt();
		
		System.out.print("세로길이 : ");
		int num2 = sc.nextInt();
		
		for (int i = 0; i < num2; i++) {
			for (int j = 0; j < num1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}