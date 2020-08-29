// vim: et:ts=2:sw=2:sts=2

public class Soldier extends Person {
  public Person() {
    super(150, 0, 60, 10, 0);
  }

  public AttackResult Attack(int attack_type = 0) {
    return NormalAttack();
  }

  // <<<< public ==== private >>>>

  private AttackResult NormalAttack() {
    return new AttackResult(0, AP, 0, 0);
  }
};
