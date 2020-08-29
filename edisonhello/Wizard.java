// vim: et:ts=2:sw=2:sts=2

public class Wizard extends Person {
  public Person() {
    super(90, 700, 5, 20, 60);
  }

  public AttackResult Attack(int attack_type = 0) {
    switch (attack_type) {
      case 0: 
        return NormalAttack();
      case 1: 
        return Thunder();
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
