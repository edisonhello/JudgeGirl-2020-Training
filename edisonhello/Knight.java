// vim: et:ts=2:sw=2:sts=2

import java.util.function.*;
import java.util.ArrayList;

public class Knight extends Person {
  public Knight(BiFunction<Integer, Integer, Integer> _Input,
                Consumer<String> _Output) {
    super(270, 0, 100, 20, 40, _Input, _Output);
  }

  public AttackResult Attack() {
    return NormalAttack();
  }

  public AttackResult Attack(int attack_type) {
    return NormalAttack();
  }

  // <<<< public ==== private >>>>

  private AttackResult NormalAttack() {
    return new AttackResult(0, AP, 0, 0);
  }
};
