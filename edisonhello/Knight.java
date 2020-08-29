// vim: et:ts=2:sw=2:sts=2

public class Knight extends Person {
  public Person() {
    super(270, 0, 100, 20, 40);
  }

  public AttackResult Attack(int attack_type = 0) {
    return NormalAttack();
  }

  // <<<< public ==== private >>>>

  private AttackResult NormalAttack() {
    return new AttackResult(0, AP, 0, 0);
  }
};
