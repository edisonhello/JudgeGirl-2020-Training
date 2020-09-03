// vim: et:ts=2:sw=2:sts=2

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.lang.NumberFormatException;

public class main {
  private static int InputInt(int l, int r) {
    while (true) {
      try {
        Scanner in = new Scanner(System.in);
        System.out.print("Input an integer between " + l + " and " + r + ": ");
        String resultStr = in.nextLine();
        int result = Integer.parseInt(resultStr);
        if (result < l || result > r) {
          System.out.print("This input seems out of range. ");
          continue;
        }
        return result;
      } catch (InputMismatchException e) {
        System.out.println("That doesn't seem like an integer.");
      } catch (java.lang.NumberFormatException e) {
        System.out.println("That doesn't seem like an integer.");
      }
    }
  }

  private static Random rand = new Random(7122);
  private static int RandomInt(int l, int r) {
    return rand.nextInt(r - l + 1) + l;
  }

  private static void Output(String s) {
    System.out.print(s);
  }

  public static void main(String[] args) throws Throwable {
    if (!(new Round(main::InputInt, main::RandomInt, main::Output, s -> {}, 
            Arrays.asList(new Player(main::InputInt, main::Output)), 
            Arrays.asList(new Soldier(main::RandomInt, s -> {})))).Play()) {
      Output("You dead!");
    }
  }
};
