This file will contain documentation for all commands available in your game.

## HOW TO START THE GAME: ## 
To start the game, run the GUI. The window will pop up where you can use the arrows to scroll through the images of pokemon, then press the button on the window to select this pokemon type. You will then be told to minimize the graphics window and follow the instructions on the terminal. 

POKEMON 
chooseStarterType(): choose your starter Pokémon by its type
evolve(): level up your Pokémon to its first or second evolution once it gains enough XP to evolve 

TRAINER
learn(): increase your Pokémon's XP and battle skills by learning new attacks
start(): start learning new attacks by calling this command to officially train your Pokémon 

BATTLE:
generateOpponent(): generate a randomized opponent to battle your Pokémon 
defend(): allows battle participant to protect themselves from an attack with a shield -- given two shields per battle
counter_attack(): attack your opponent with the moves you mastered from learn() to decrease their XP
attack(): this is where the actual 'battle' of the game is located
startBattle(): officially starts the battle by generating your opponent, initiating the battle, and giving you the options to defend and attack


# SPOILER ALERT
If your game includes challenges that must be overcome to win, also list them below.
The objective of the game is to find a randomly generated opponent. The user is asked whether or not they want to defend themselves (use shields) or counterattack. 
A shortcut to win: do not use any shield, counterattack the opponent every time when prompted to get their XP to 0 and ultimately win. 