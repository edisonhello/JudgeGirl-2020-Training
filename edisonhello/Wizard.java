// vim: et:ts=2:sw=2:sts=2

import java.util.function.*;
import java.util.ArrayList;

public class Wizard extends Person {
  public Wizard(BiFunction<Integer, Integer, Integer> _Input,
                Consumer<String> _Output) {
    super(90, 700, 5, 20, 60, _Input, _Output);
  }

  public AttackResult Attack() {
    return NormalAttack();
  }

  public AttackResult Attack(int attack_type) {
    switch (attack_type) {
      case 1: 
        return Thunder();
      default: 
        return NormalAttack();
    }
  }

  // <<<< public ==== private >>>>

  private AttackResult NormalAttack() {
    return new AttackResult(0, AP, 0, 0);
  }

  private AttackResult Thunder() {
    if (MP < 100)
      return NormalAttack();
    MP -= 100;
    return new AttackResult(1, 250, 0, 0);
  }
};
