// vim: et:ts=2:sw=2:sts=2

public abstract class Person {
  public int HP, MP, AP, DF, MDF;
  private int freezed_round;
  public Person(int _HP, int _MP, int _AP, int _DF, int _MDF) {
    HP = _HP;
    MP = _MP;
    AP = _AP;
    DF = _DF;
    MDF = _MDF;
    freezed_round = 0;
  }

  public abstract AttackResult Attack(int attack_type);
};
