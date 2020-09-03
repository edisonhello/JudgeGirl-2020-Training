// vim: et:ts=2:sw=2:sts=2

import java.util.function.*;
import java.util.ArrayList;

public class Boss extends Person {
  public Boss(BiFunction<Integer, Integer, Integer> _Input,
              Consumer<String> _Output) {
    super(90, 700, 5, 20, 60, _Input, _Output);
  }

  public AttackResult Attack(int attack_type = 0) {
    switch (attack_type) {
      case 0: 
        return NormalAttack();
      case 1: 
        return Summon();
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
