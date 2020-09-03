// vim: et:ts=2:sw=2:sts=2

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Round {
  private BiFunction<Integer, Integer, Integer> GetPlayer, GetEnemy;
  private Consumer<String> OutputPlayer, OutputEnemy;
  private ArrayList<Person> players;
  private ArrayList<Person> enemies;

  public Round(BiFunction<Integer, Integer, Integer> _GetPlayer, 
               BiFunction<Integer, Integer, Integer> _GetEnemy, 
               Consumer<String> _OutputPlayer, 
               Consumer<String> _OutputEnemy,
               List<Person> _players,
               List<Person> _enemies) throws Throwable {
    GetPlayer = _GetPlayer;
    GetEnemy = _GetEnemy;
    OutputPlayer = _OutputPlayer;
    OutputEnemy = _OutputEnemy;
    players = new ArrayList<Person>(_players);
    enemies = new ArrayList<Person>(_enemies);

    for (Person person : players) 
      person.RegistDeck(players, enemies);
    for (Person person : enemies) 
      person.RegistDeck(enemies, players);
  }

  public boolean Play() {
    while (true) {
      if (!PlayerAlive()) 
        return false;

      PlayerAttack();

      if (AllClear())
        return true;

      EnemyAttack();
    }
  }

  // <<<< public ==== private >>>>

  private boolean PlayerAlive() {
    for (Person player : players) {
      if (player.IsAlive()) 
        return true;
    }
    return false;
  }

  private void PlayerAttack() {
    for (Person player : players) {
      if (player.IsAlive())
        player.DoAttack();
    }
  }

  private boolean AllClear() {
    for (Person enemy : enemies) {
      if (enemy.IsAlive())
        return false;
    }
    return true;
  }

  private void EnemyAttack() {
    for (Person enemy : enemies) {
      if (enemy.IsAlive()) {
        enemy.DoAttack();
      }
    }
  }
}
