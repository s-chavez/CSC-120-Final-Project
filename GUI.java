import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.lang.Thread;

/**
 * Represents graphical user interface for Pokemon battle game.
 * Extends Frame and implements ActionListener.
 */
public class GUI extends Frame implements ActionListener {
  /** User's chosen Pokemon type */
  public static String chosenType;
  /** Label for Welcome Message*/
  private JLabel messageLabel;
  /** Button used to select Pokemon */
  private JButton selectButton;
  /** Button used to scroll right */
  private JButton rightArrow;
  /** Button used to scroll left */
  private JButton leftArrow;
  /** Label for the image illustrating the Pokemon type */
  private JLabel pokemonLabel;
  /** Panel for messageLabel */
  private JPanel messagePanel;
  /** index of current Pokemon type image */
  private int index;
  /** ArrayList of the images of the Pokemon types */
  private ArrayList < String > pokemonImages;

  /**
   * Constructs a new GUI.
   */
  public GUI() {
    /** Make sure we have nice window decorations. */
    JFrame.setDefaultLookAndFeelDecorated(true);
    /** Create and set up the windows. */
    JFrame frame = new JFrame("Choose your Pokemon!");
    try {
      /** Quit program when window closes. */
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } catch (Exception e) {}
    /** How to arrange the window. */
    frame.getContentPane().setLayout(new BorderLayout());
    /** Sets background to new Color. */
    this.setBackground(new Color(193, 240, 251));

    /** Creates new JLabel. */
    pokemonLabel = new JLabel();
    /** Centers horizontal alignment of pokemonLabel. */
    pokemonLabel.setHorizontalAlignment(JLabel.CENTER);
    /** Centers vertical alignment of pokemonLabel. */
    pokemonLabel.setVerticalAlignment(JLabel.CENTER);
    /** Adds pokemonLabel to window. */
    add(pokemonLabel);

    /** Creates new JPanel. */
    messagePanel = new JPanel();
    /** Sets background of the panel. */
    messagePanel.setBackground(new Color(232, 189, 255));
    /** Sets size of the panel. */
    messagePanel.setSize(100, 100);

    /** Creates a new JLabel. */
    messageLabel = new JLabel();
    /** Adds text to the label. */
    messageLabel.setText("Welcome! Click the arrow button to choose your starter Pokemon and see their evolution.");
    /** Horizontally centers the label */
    messageLabel.setHorizontalAlignment(JLabel.CENTER);
    /** Sets the preferred label size. */
    messageLabel.setPreferredSize(new Dimension(700, 60));
    /** Sets the font, style, and size to the label's text. */
    messageLabel.setFont(new Font("Times New Roman", Font.ITALIC, 19));
    /** Adds the label to the panel. */
    messagePanel.add(messageLabel);
    /** Adds the panel to the North section of layout. */
    add(messagePanel, BorderLayout.NORTH);

    /** Creates new JButton. */
    selectButton = new JButton("Press here to choose this starter Pokemon.");
    /** Colors the background of the button. */
    selectButton.setBackground(new Color(220, 249, 168));
    /** Sets the preferred button size. */
    selectButton.setPreferredSize(new Dimension(100, 60));
    /** Sets the font, style, and size to the button's text. */
    selectButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
    /** Adds actionListener to button. */
    selectButton.addActionListener(this);
    /** Adds button to South section of layout. */
    add(selectButton, BorderLayout.SOUTH);

    /** Creates new JButton. */
    rightArrow = new JButton("►");
    /** Sets preferred size of button. */
    rightArrow.setPreferredSize(new Dimension(75, 100));
    /** Adds actionListener to button. */
    rightArrow.addActionListener(this);
    /** Sets font, style, and size to button's text. */
    rightArrow.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    /** Colors button's background. */
    rightArrow.setBackground(new Color(249, 206, 238));
    /** Adds button to East section of layout. */
    add(rightArrow, BorderLayout.EAST);

    /** Creates new Jbutton. */
    leftArrow = new JButton("◄");
    /** Sets preferred size of button. */
    leftArrow.setPreferredSize(new Dimension(75, 100));
    /** Adds actionListener to button. */
    leftArrow.addActionListener(this);
    /** Sets font, style, and size to button's text. */
    leftArrow.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    /** Colors button's background. */
    leftArrow.setBackground(new Color(249, 206, 238));
    /** Adds button to West section of layout. */
    add(leftArrow, BorderLayout.WEST);

    /** Adds Pokemon type images to ArrayList. */
    pokemonImages = new ArrayList < String > ();
    pokemonImages.add("DRAGON.png");
    pokemonImages.add("FAIRY.jpg");
    pokemonImages.add("FIRE.png");
    pokemonImages.add("GRASS.png");
    pokemonImages.add("NORMAL.jpg");
    pokemonImages.add("WATER.png");

    /** Calls DisplayImage() method to show the Pokemon type Image. */
    DisplayImage();
    /** Sets size of window. */
    setSize(800, 800);
    /** Displays window. */
    setVisible(true);
  }

  /**
   * Displays the Pokemon type Image.
   */
  public void DisplayImage() {
    ImageIcon smallerPokemonImage = new ImageIcon(new ImageIcon(this.pokemonImages.get(index)).getImage()
      .getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH));
    pokemonLabel.setIcon(smallerPokemonImage);

  }

  /**
   * Method allowing arrows to change and display Pokemon type images in arraylist by current index.
   * Once user selects Pokemon starter pack, chosenType is assigned based on user's choice.
   * @param evt The event caused by a user's action.
   */
  public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == rightArrow) {
      index++;
      if (index == pokemonImages.size()) {
        index = 0;
      }
    } else if (evt.getSource() == leftArrow) {
      index--;
      if (index < 0) {
        index = pokemonImages.size() - 1;
      }
    } else if (evt.getActionCommand().equals("Press here to choose this starter Pokemon.")) {
      String starter = pokemonImages.get(index);
      if (starter.equals("DRAGON.png")) {
        chosenType = "dragon";
      } else if (starter.equals("FAIRY.jpg")) {
        chosenType = "fairy";
      } else if (starter.equals("FIRE.png")) {
        chosenType = "fire";
      } else if (starter.equals("GRASS.png")) {
        chosenType = "grass";
      } else if (starter.equals("NORMAL.jpg")) {
        chosenType = "normal";
      } else {
        chosenType = "water";
      }
      System.out.println("You have chosen Pokemon Type: " + chosenType);
      selectButton.setText("Since you've pressed this button, minimize this window.");
    }
    DisplayImage();
  }

  /**
   * Accessor for user's chosen Pokemon type
   * @return chosenType The user's chosen Pokemon type
   */
  public String getChosenType() {
    return chosenType;
  }

  /**
   * Main method of PokePunch allowing user to start the entire game.
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    // new GUI();
    System.out.println("Welcome to PokePunch! It's time to start your journey.");
    System.out.println("Get ready for an interactive experience!");
    System.out.println("Soon, a new screen will appear with Pokemon for you to choose from.");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {}
    new GUI();
    System.out.println("Simply browse Pokemon types by clicking the arrow buttons.");
    System.out.println("Press the bottom button on the screen to select your Pokemon type.");
    while (chosenType == null) {
      try {
        Thread.sleep(150);
      } catch (InterruptedException e) {}
    }
    Battle.startBattle();
  }
}