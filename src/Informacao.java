import java.util.Scanner;

public class Informacao {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Informe uma string: ");
		String str = scanner.nextLine(); //trava a execucao do programa ate q informa um valor
		System.out.println(str);
		System.out.print("Informe um numero: ");
		int num = scanner.nextInt();
		System.out.println(num+20);
		
	}
}
