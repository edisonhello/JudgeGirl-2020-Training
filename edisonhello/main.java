// vim: et:ts=2:sw=2:sts=2

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
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
    // if (!Round1()) {
    //   Output("You dead at round 1!");
    //   return;
    // }
    // if (!Round2()) {
    //   Output("You dead at round 2!");
    //   return;
    // }
    if (!Round3()) {
      Output("You dead at round 3!");
      return;
    }
  }

  // <<<< public ==== private >>>>

  private static boolean Round1() throws Throwable {
    List<Person> player_list = Arrays.asList(
        new Player(main::InputInt, main::Output));
    List<Person> enemy_list = Arrays.asList(
        new Soldier(main::RandomInt, s -> {}),
        new Soldier(main::RandomInt, s -> {}),
        new Soldier(main::RandomInt, s -> {}),
        new Soldier(main::RandomInt, s -> {}),
        new Knight(main::RandomInt, s -> {}));
    Round round = new Round(main::InputInt, main::RandomInt, main::Output, s -> {}, player_list, enemy_list);
    return round.Play();
  }

  private static boolean Round2() throws Throwable {
    List<Person> player_list = Arrays.asList(
        new Player(main::InputInt, main::Output));
    List<Person> enemy_list = Arrays.asList(
        new Soldier(main::RandomInt, s -> {}),
        new Soldier(main::RandomInt, s -> {}),
        new Wizard(main::RandomInt, s -> {}),
        new Wizard(main::RandomInt, s -> {}));
    Round round = new Round(main::InputInt, main::RandomInt, main::Output, s -> {}, player_list, enemy_list);
    return round.Play();
  }

  private static boolean Round3() throws Throwable {
    List<Person> player_list = Arrays.asList(
        new Player(main::InputInt, main::Output));
    List<Person> enemy_list = Arrays.asList(
        new Boss(main::RandomInt, s -> {}));
    Round round = new Round(main::InputInt, main::RandomInt, main::Output, s -> {}, player_list, enemy_list);
    return round.Play();
  }
};
