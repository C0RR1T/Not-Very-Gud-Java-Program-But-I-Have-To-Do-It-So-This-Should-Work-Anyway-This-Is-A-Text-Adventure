import java.util.Scanner;

public class Console {
  private Scanner scanner;

  public Console() {
    this.scanner = new Scanner(System.in);

  }

  public void say(String msg) {
    System.out.println(msg);
  }

  public String input() {
    System.out.print("> ");
    return scanner.nextLine();
  }
}
