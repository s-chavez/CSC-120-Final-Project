import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/**
 * Represents a Battle
 */
public class Battle {
  /** The number of shields the Trainer has */
  private int shields;
  /** The name of the Pokemon opponent */
  private static String opponentName;
  /** The number of experience points (XP) the opponent has */
  private static int opponentXP;
  /** The Trainer's pokemon */
  private static Pokemon pokemon;
  /** The name of the Trainer's pokemon*/
  private static String pokemonName;
  /** Hashtable listing opponent name and XP */
  private static Hashtable < String, Integer > opponent_list;
  /** Amount of damage caused by an attack  */
  private static int attackDamage;
  /** The XP of the Trainer's pokemon */
  private static int pokemonXP;

  /**
   * Constructor for Battle class.
   * Uses start() method from Trainer class to create Trainer.
   * Creates new Pokemon.
   * Sets Trainer's number of shields = 2.
   * Initializes list of Pokemon opponents.
   */
  public Battle() {
    Trainer.start();
    pokemon = new Pokemon();
    pokemonName = Pokemon.chosenStarter;
    pokemonXP = pokemon.getXp();
    this.shields = 2;
    Battle.opponent_list = new Hashtable < String, Integer > ();
  }

  /**
   * Accessor for Pokemon opponent's XP.
   * @return The Pokemon opponent's XP
   */
  public int getOpponentXP() {
    return opponentXP;
  }

  /**
   * Generates a random Pokemon opponent.
   * @return The random Pokemon opponent's XP
   */
  public static int generateOpponent() {
    opponent_list = new Hashtable < String, Integer > ();
    opponent_list.put("Pikachu", 100);
    opponent_list.put("Raichu", 250);
    opponent_list.put("Slowpoke", 150);
    opponent_list.put("Snorlax", 200);
    opponent_list.put("Eevee", 300);
    System.out.println("Generating an opponent...");
    Random random = new Random();
    int randomInt = random.nextInt(opponent_list.size());
    ArrayList < String > opponentNames = new ArrayList < > (opponent_list.keySet());
    String opponentName = opponentNames.get(randomInt);
    Battle.opponentName = opponentName;
    opponentXP = opponent_list.get(opponentName);
    System.out.println("Generated opponent: " + opponentName + " of XP " + opponentXP + ".");
    return opponentXP;
  }

  /**
   * Method allowing user to defend using a shield or state they have no shields left.
   * @return The number of shields the Trainer has
   */
  public int defend() {
    if (this.shields > 0) {
      this.shields -= 1;
      if (this.shields == 0) {
        System.out.print("You have no more shields left. ");
      }
    }
    return this.shields;
  }

  /**
   * When called, allows user to counterattack from the Trainer's learned responses. 
   * Times user response in order to calculate damage accordingly.
   */
  public void counter_attack() {
    System.out.println("Do you wish to counterattack? Type yes or no.");
    String counter_attack = Input.getScanner().nextLine();
    if (counter_attack.equalsIgnoreCase("yes")) {
      System.out.println("How would you like to attack? Here are your options: ");
      for (int i = 0; i < Trainer.distinct_learned_attacks.size(); i++) {
        System.out.println(Trainer.distinct_learned_attacks.get(i));
      }
      long startTime = System.currentTimeMillis();
      System.out.println("Please choose an attack. Type of the name of your attack to fight.");
      String chosenAttack = Input.getScanner().next();
      Input.getScanner().nextLine();
      long endTime = System.currentTimeMillis();
      long time = (endTime - startTime) / 1000;
      System.out.println("You took " + time + " seconds to type in your attack.");
      if (time <= 5) {
        attackDamage = 100;
        opponentXP -= 100;
      } else if (5 < time && time <= 10) {
        attackDamage = 50;
        opponentXP -= 50;
      } else {
        attackDamage = 25;
        opponentXP -= 25;
      }
      if (opponentXP <= 0) {
        opponentXP = 0;
      }
      System.out.println("Attacking " + opponentName + " with " + chosenAttack + " with " + attackDamage + " xp!");
      System.out.println(opponentName + " now has " + opponentXP + " XP.");
    } else if (counter_attack.equalsIgnoreCase("no")) {
      System.out.println("You have chosen not to counterattack. " + opponentName + "'s attack had 50 xp damage.");
      pokemonXP -= 100;
      System.out.println("Your pokemon " + pokemonName + " now has " + pokemonXP + " XP.");
      System.out.println(opponentName + " now has " + opponentXP + " XP.");
    } else {
      throw new RuntimeException("Not a valid option. You must start over.");
    }
  }

  /**
   * Creates battle between Trainer's pokemon and generated opponent.
   * Checks pokemon and opponent's XP.
   * Asks user if they want to use a shield use and calls defend().
   * If a shield is not used, program calls counterattack() 
   * Determines winner of Battle.
   * Asks user if they want to battle again or end the game.
   */
  public void attack() {
    generateOpponent();
    while (pokemonXP > 0 && opponentXP > 0) {
      System.out.println(opponentName + " is attacking! \n" + "You have " + this.shields + " shields left.");
      if (this.shields > 0) {
        System.out.println("Do you want to use a shield? (Type yes or no)");
        String shield_use = Input.getScanner().nextLine();
        if (shield_use.equalsIgnoreCase("yes")) {
          defend();
        } else {
          System.out.println("NO SHIELDS USED. You must counterattack. ");
          counter_attack();
        }
      } else {
        System.out.println("You have no shields left. You must counterattack.");
        counter_attack();
      }
      if (pokemonXP <= 0 || opponentXP <= 0) {
        break;
      }
    }
    if (pokemonXP <= 0) {
      System.out.println("Sorry, Trainer " + Trainer.getTrainerName() + ", you have lost the battle. ");
      System.out.println("Good effort! " + Pokemon.chosenStarter +
        " is stronger now but better luck next time. Your pokemon has gained 15 XP for their efforts.");
      pokemonXP += 15;
    } else {
      opponentXP = 0;
      System.out.println("Congratulations, Trainer " + Trainer.getTrainerName() + " you have won the battle!");
      pokemonXP += 100;
      System.out.println("As a reward, your pokemon has gained 100 XP! " + " Pokemon " + Pokemon.chosenStarter + " now has " +
        pokemonXP + " XP.");
    }
    System.out.println("Checking if your Pokemon " + Pokemon.chosenStarter + " can evolve...");
    try {
      pokemon.evolve(Pokemon.chosenStarter, pokemonXP);
    } catch (RuntimeException e) {
      System.out.println("Unfortunately, your Pokemon does not have enough XP to evolve. Battle to earn more XP!");
    }
  }

  /**
   * Starts battle by calling attack() method.
   */
  public static void startBattle() {
    Trainer.pokemon = new Pokemon();
    Battle myBattle = new Battle();
    myBattle.attack();
  }

  /**
   * Main method used to test methods in Battle class
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    Battle.startBattle();
  }
}