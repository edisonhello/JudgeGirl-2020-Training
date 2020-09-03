// vim: et:ts=2:sw=2:sts=2

import java.util.function.*;
import java.util.ArrayList;

public class Player extends Person {
  public Player(BiFunction<Integer, Integer, Integer> _Input,
                Consumer<String> _Output) {
    super(500, 500, 70, 40, 10, _Input, _Output);
  }

  public AttackResult Attack() {
    return NormalAttack();
  }

  public AttackResult Attack(int attack_type) {
    switch (attack_type) {
      case 1: 
        return WaterBall();
      case 2:
        return FireBall();
      case 3: 
        return Enchance();
      case 4:
        return Freeze();
      default:
        return NormalAttack();
    }
  }

  public void Recover() {
    HP = 500;
    MP = 500;
    AP = 70;
    DF = 40;
    MDF = 10;
  }

  // <<<< public ==== private >>>>

  private AttackResult NormalAttack() {
    return new AttackResult(0, AP, 0, 0);
  }

  private AttackResult WaterBall() {
    if (MP < 50) 
      return NormalAttack();
    MP -= 50;
    return new AttackResult(1, 50, 1, 0);
  }

  private AttackResult FireBall() {
    if (MP < 50) 
      return NormalAttack();
    MP -= 50;
    return new AttackResult(1, 150, 0, 0);
  }

  private AttackResult Enchance() {
    if (MP < 40) 
      return NormalAttack();
    MP -= 40;
    return new AttackResult(0, 0, 0, 0);
  }

  private AttackResult Freeze() {
    if (MP < 100) 
      return NormalAttack();
    MP -= 100;
    return new AttackResult(0, 0, 0, 3);
  }
};
