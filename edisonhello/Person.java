// vim: et:ts=2:sw=2:sts=2

import java.util.function.*;
import java.util.ArrayList;

public abstract class Person {
  protected int HP, MP, AP, DF, MDF;
  protected int freezed_round;
  protected BiFunction<Integer, Integer, Integer> Input;
  protected Consumer<String> Output;
  protected ArrayList<Person> self_deck, enemy_deck;

  public Person(int _HP, int _MP, int _AP, int _DF, int _MDF, 
                BiFunction<Integer, Integer, Integer> _Input,
                Consumer<String> _Output) {
    HP = _HP;
    MP = _MP;
    AP = _AP;
    DF = _DF;
    MDF = _MDF;
    freezed_round = 0;
    Input = _Input;
    Output = _Output;
  }

  public boolean IsAlive() {
    return HP > 0;
  }
  public boolean IsDead() {
    return HP <= 0;
  }

  public abstract AttackResult Attack();
  public abstract AttackResult Attack(int attack_type);

  public void Attacked(AttackResult attack) {
    if (attack.freeze_round > 0) 
      freezed_round += attack.freeze_round;

    if (attack.type == 0) 
      HP -= attack.damage - DF;
    else 
      HP -= attack.damage - MDF;
  }

  public void PrintStatus() {
    System.out.print(GetStatus());
  }

  public String GetStatus() {
    return getClass().getName() + ": Status: HP: " + HP + " MP: " + MP + " AP: " + AP + " DF: " + DF + " MDF: " + MDF + (freezed_round > 0 ? "freeze remain " + freezed_round + " round(s)" : "") + "\n";
  }

  public void RegistDeck(ArrayList<Person> _self_deck, ArrayList<Person> _enemy_deck) {
    self_deck = _self_deck;
    enemy_deck = _enemy_deck;
  }

  public void DoAttack() {
    Output.accept("It's your turn!\n");
    PrintStatus();

    if (freezed_round > 0) {
      --freezed_round;
      Output.accept("Freezed. Remain: " + freezed_round + " rounds\n");
      return;
    }

    Output.accept("\nEnemies status: \n");
    int index = 0;
    for (Person enemy : enemy_deck) {
      if (enemy.IsAlive()) {
        ++index;
        Output.accept("  " + index + ". " + enemy.GetStatus());
      }
    }

    Output.accept("\nChoose your attack type (0 ~ 4): ");
    int attack_type = Input.apply(0, 4);
    AttackResult attack = Attack(attack_type);

    if (attack.range == 0) {
      Output.accept("\nChoose your target (1 ~ " + index + "): ");
      int target = Input.apply(1, index);
      index = 0;
      for (Person enemy : enemy_deck) {
        if (enemy.IsAlive()) {
          ++index;
          if (index == target) {
            enemy.Attacked(attack);
            Output.accept("  " + index + ". " + enemy.GetStatus());
          }
        }
      }
    } else {
      index = 0;
      for (Person enemy : enemy_deck) {
        if (enemy.IsAlive()) {
          ++index;
          enemy.Attacked(attack);
          Output.accept("  " + index + ". " + enemy.GetStatus());
        }
      }
    }

    Output.accept("\n\n");
  }
};
