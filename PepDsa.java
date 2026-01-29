package DSAPep;
import java.util.Scanner;

class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no of rows: ");
        Integer a = sc.nextInt();

        for (int i = 0; i <= a; i++) {
            for (int j = i; j <= i; j++) {
                System.out.println("* ");
            }
            System.out.println();
        }

    }
}
