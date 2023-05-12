import java.util.Scanner;

/** 
 * Represents a scanner 
 */
public class Input {

  /** Creates Scanner object. */
  public static Scanner scanner = new Scanner(System.in);

  /** Accessor for scanner. */
  public static Scanner getScanner() {
    return scanner;
  }

  /** Closes scanner. */
  public static void closeScanner() {
    scanner.close();
  }
}