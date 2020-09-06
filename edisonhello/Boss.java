// vim: et:ts=2:sw=2:sts=2

import java.util.function.*;
import java.util.ArrayList;
import java.util.Random;

public class Boss extends Person {
  private static Random random_generator = new Random(7122);
  public Boss(BiFunction<Integer, Integer, Integer> _Input,
              Consumer<String> _Output) {
    super(1000, 300, 90, 40, 40, _Input, _Output);
  }

  public AttackResult Attack() {
    return NormalAttack();
  }

  public AttackResult Attack(int attack_type) {
    switch (attack_type) {
      case 1: 
        return Summon();
      default:
        return NormalAttack();
    }
  }

  // <<<< public ==== private >>>>

  private AttackResult NormalAttack() {
    return new AttackResult(0, AP, 0, 0);
  }

  private AttackResult Summon() {
    if (MP < 50)
      return NormalAttack();
    MP -= 50;
    int summon_type = random_generator.nextInt(3);
    switch (summon_type) {
      case 0:
        return new AttackResult(new Wizard(Input, Output));
      case 1:
        return new AttackResult(new Knight(Input, Output));
      case 2:
        return new AttackResult(new Soldier(Input, Output));
    }
    return new AttackResult(0, 0, 0, 0);
  }
};
