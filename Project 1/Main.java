import java.util.Scanner;

public class Main {
  static void Method() {
    System.out.println("You win!!");
  }
  public static void main(String[] args) {
    System.out.println("***Welcome to the GUESSING GAME!!***");
    System.out.println("I have a number between 1 and 100. Can you guess it?");
    System.out.println(" ");
    System.out.print("Enter your guess: ");
    Scanner userinputdirect = new Scanner(System.in);
    int userinput = userinputdirect.nextInt();
    int number = (int)(1+100*Math.random());

    do {
      if (userinput > number) {
        System.out.println("Too high, elbow nose!");
        System.out.println(" ");
        System.out.print("Enter your guess: ");
        userinput = userinputdirect.nextInt();

      } else if (userinput < number) {
        System.out.println("Too low, dimwit!");
        System.out.println(" ");
        System.out.print("Enter your guess: ");
        

        //Scanner newinput = new Scanner(System.in);
        userinput = userinputdirect.nextInt();
      }
      if (userinput == number) {
        Method();
      }
    } while (userinput != number);
	
  
}
}
