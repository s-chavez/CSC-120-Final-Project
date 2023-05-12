# CSC120-FinalProject

## Deliverables:
 ## Your final codebase
    Completed and attached.
 ## Your revised annotated architecture diagram
    Completed and attached.
 ## Design Justification:
    Inspired by Pokémon GO, a game the both of us enjoy and play regularly, we wanted to make our own version. In our game, the main focus is on the evolution aspect where the objective is to try and train your Pokémon in battle until it’s strong enough to reach the final evolutionary stage. To accomplish this, we welcome the trainer (the user) to the game and ask them to pick a starter Pokémon based on its type. Next, we encourage the trainer to train their Pokémon by learning new attacks. If the trainer chooses to teach their Pokémon all four attacks, the XP increases by 50. Afterwards, the Pokémon is ready to battle a randomized opponent where they have an option to defend by using one of their two shields or counterattack. Only learned attacks are able to be used in battle. If the opponent reaches 0 XP first, the trainer’s Pokémon wins and gains 100 XP. If the trainer’s Pokémon reaches 0 XP first, it gains 15 XP for the experience. Once enough XP has been gained, the trainer can evolve their Pokémon to its first evolutionary stage and eventually, its second and final one. 
    Originally, we wanted to include all 18 types of Pokémon along with the option to train multiple Pokémon at once and build your battle team. The goal would’ve been to expand your team as much as possible and train them to their highest evolutionary stage. Ultimately, we decided to limit the types and trainer Pokémon to simplify the code and make the objective of the game clearer. 
## A map of your game's layout (if applicable)
    N/A
 ## \'cheatsheet.md`
    Completed and attached.
 ## \ Completed \`rubric.md`
    Completed and attached.
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
 Our overall approach was primarily working off our architecture diagram. We spent a lot of time discussing exactly what methods and attributes we wanted in each class and the relationship between the classes. We also commented what we wanted each method to do, which helped us break down the steps to creating more complicated commands like attack() and evolve(). 

 - What **new thing(s)** did you learn / figure out in completing this project?
 We knew from the beginning that we wanted to incorporate graphics with our project. After being introduced to the GUI in class, we researched more into how to implement it into our code. In doing so, we learned how to store user input from graphics in our program to be used in other methods and classes. Specifically, we were able to figure out how to use graphics to have the user pick their starter Pokémon and store that information in the attribute chosenStarter. Also, we learned how to implement a timer and time the user’s input.

 - Is there anything that you wish you had **implemented differently**?
 We have it organized so the Battle, Trainer, and Pokemon have aggregation relationships. The Battle has a Trainer and has a Pokemon. In one of our earlier assignments, we received feedback that working with interfaces would help our code as we tried making the Trainer and Pokémon classes into interfaces that the Battle class implements. We ultimately went back to using a aggregation relationship because this means the objects can still exist individually, but we are still interested in seeing if using interfaces would’ve helped us avoid some of the errors we were getting when we tried to access information from another class.

 - If you had **unlimited time**, what additional features would you implement?
 We initially had a heal method in the Pokémon class that would reset the Pokémon’s XP after a battle back to its original value; it would also add XP after the battle even if the Pokémon lost as it gains points for the experience. However, we had a lot of trouble figuring out how to set it so that it recognized if the Pokémon had trained or completed previous battles and would therefore have a higher XP. If we had unlimited time, we are confident that we could come up with a system that would take into account the pokémon’s XP with consideration to XP gained from training and previous battles. 

 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
The most helpful piece of feedback we received while working on our project was given to us by our classmate Robbie who suggested that we could use GUI to get the user input for their selected Pokémon. It ended up working and made the graphics much more interactive. On the demonstration day, Jordan said our project could update the user on the opponent’s XP and pokemon’s XP, which we ended up including in our project.

 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 If we would go back in time to give our past selves some advice about this project, we would probably say to keep on updating the architecture diagram as we go. Since we had to work on separate versions of the code, we ended up having repeats of the code since we didn’t realize the other person had already added it in a different class or method. If we had also updated the diagram as we went, it may have helped us avoid duplicates and the time we spent trying to figure out why things were printing twice. 


 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.
 Our bond as friends and lovers of the original Pokémon GO game really helped us to develop a healthy team dynamic. Our communication was clear and consistent, and we valued each other’s thoughts, ideas, and opinions throughout the entire project. We consciously avoided judging each other when one of us was stuck or couldn’t figure out how to code something as we both knew how it felt to be unsure of how to best approach something. We were also understanding of each other’s schedules and volunteered to take up additional responsibilities if the other person was unable to do so. Overall, we feel that this project is representative of our joint efforts and proof of our cohesiveness as a team. 