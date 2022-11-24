import java.util.Scanner;
public class Main {
    public static void main(String[] argv) {
        Scanner inputValue = new Scanner(System.in);
        Dni d = null;
        int num;
        char letter;
        boolean right = true;
        do {
            System.out.println("Please enter your DNI number:");
            num = inputValue.nextInt();
            System.out.println("Please enter the letter of your DNI:");
            letter = inputValue.next().charAt(0);
            try {
                d = new Dni(num,letter);
                right = true;
            } catch (NIFLetterException e) {

                System.out.println("WRONG Letter");
                right = false;
            } catch (Exception e) {

                System.out.println("WRONG NIF");
                right = false;
            }
        } while (!right);
        System.out.println("Ok");
    }
}