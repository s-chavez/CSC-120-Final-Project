import java.util.ArrayList;

/**
 * Represents a Trainer class
 */
public class Trainer extends Pokemon {

  /** Trainer's name inputted by the user */
  private static String name;
  /** Trainer's trainer_level */
  private int trainer_level;
  /** static ArrayList of attacks the Trainer has learned */
  private static ArrayList < String > learned_attacks = new ArrayList < > ();
  /** static ArrayList of distinct attacks the Trainer has learned */
  public static ArrayList < String > distinct_learned_attacks = new ArrayList < > ();
  /** static instance of Pokemon */
  public static Pokemon pokemon;
  /** The pokemon that belongs to the Trainer's XP */
  private static int pokemonXP;

  /**
   * Constructor for Trainer.
   * Sets name equal to user input and trainer level equal to 1.
   * Initializes learned_attacks ArrayList.
   */
  public Trainer() {
    System.out.println("Welcome new trainer!");
    System.out.println("Now, please enter your Trainer name: ");
    name = Input.getScanner().nextLine();
    System.out.println("Hope you enjoy, " + name + "!");
    this.trainer_level = 1;
    learned_attacks = new ArrayList < > ();
  }

  /**
   * Accessor for Trainer's name.
   * @return The Trainer's name
   */
  public static String getTrainerName() {
    return Trainer.name;
  }

  /**
   * Accessor for Trainer's level.
   * @return The Trainer's level.
   */
  public int getTrainerLevel() {
    return this.trainer_level;
  }

  /**
   * Accessor for the Pokemon's XP that belongs to the Trainer.
   * @return The Pokemon's XP
   */
  public int getPokemonXp() {
    return pokemon.getXp();
  }

  /**
   * Allows user to learn new attacks by typing in the name of the attack.
   * User's pokemon earns 50 XP if all attacks are learned.
   * Checks for duplicate learned attacks.
   */
  public static void learn() {
    ArrayList < String > full_attack_list = new ArrayList < > ();
    full_attack_list.add("punch");
    full_attack_list.add("kick");
    full_attack_list.add("slam");
    full_attack_list.add("blast");
    while (true) {
      System.out.println("Which of the following attacks would you like to learn: punch, kick, slam, blast");
      String learn_attack = Input.getScanner().nextLine();
      if (learn_attack.equalsIgnoreCase("punch")) {
        learned_attacks.add("punch");
      } else if (learn_attack.equalsIgnoreCase("kick")) {
        learned_attacks.add("kick");
      } else if (learn_attack.equalsIgnoreCase("slam")) {
        learned_attacks.add("slam");
      } else if (learn_attack.equalsIgnoreCase("blast")) {
        learned_attacks.add("blast");
      } else {
        System.out.println(learn_attack +
          " is not a valid attack. Please enter one of the following: punch, kick, slam, blast.");
        learn();
      }
      if (learned_attacks.containsAll(full_attack_list)) {
        try {
          pokemonXP = pokemon.getXp() + 50;
        } catch (NullPointerException e) {
          pokemonXP = pokemon.getXp();
        }
        System.out.println(
          "You have unlocked all possible attacks! Your pokemon has earned 50 XP. Your pokemon's XP is now" + pokemonXP);
        break;
      }
      if (learned_attacks.size() == 0) {
        System.out.println("You must learn at least one attack.");
        learn();
      }
      System.out.println("Do you want to continue learning attacks? Type Y for yes or N for no.");
      String userStopLearning = Input.getScanner().nextLine();
      if (userStopLearning.equalsIgnoreCase("Y")) {
        continue;
      } else if (userStopLearning.equalsIgnoreCase("N")) {
        break;
      } else {
        throw new RuntimeException("That was not a valid option. Please try again.");
      }
    }

    System.out.println("Here are the attacks you have learned:");
    for (int i = 0; i < learned_attacks.size(); i++) {
      if (!distinct_learned_attacks.contains(learned_attacks.get(i))) {
        distinct_learned_attacks.add(learned_attacks.get(i));
      }
    }
    for (int i = 0; i < distinct_learned_attacks.size(); i++) {
      System.out.println(distinct_learned_attacks.get(i));
    }
  }

  /**
   * Creates pokemon, calls chooseStarterType, asks if Trainer wants to learn new attacks.
   */
  public static void start() {
    System.out.println("Welcome new trainer! Please enter your Trainer name: ");
    name = Input.getScanner().nextLine();
    System.out.println("Hope you enjoy, " + name + "!");
    Pokemon myPokemon = new Pokemon();
    myPokemon.chooseStarterType();
    System.out.println("As a Trainer, learning new attacks is a great way to prepare for battle.");
    System.out.println("Enter Y to begin learning new attacks.");
    String user_learns = Input.getScanner().nextLine();
    if (user_learns.equalsIgnoreCase("Y")) {
      Trainer.learn();
    } else {
      System.out.println("That was not a valid option. Please try again.");
      Trainer.learn();
    }
  }

  /**
   * Main method used to test Trainer methods.
   * @param args The command line args
   */
  public static void main(String[] args) {
    start();
  }
}