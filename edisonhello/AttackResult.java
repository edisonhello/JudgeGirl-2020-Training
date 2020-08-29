// vim: et:ts=2:sw=2:sts=2

public class AttackResult {
  public int damage;
  public int type; // 0 for normal, 1 for magic
  public int range; // 0 for single, 1 for all
  public int freeze_round;
  public AttackResult(int _type, int _damage, int _range, int _freeze_round) {
    type = _type;
    damage = _damage;
    range = _range;
    freeze_round = _freeze_round;
  }
};
