# Project Development Plan  

**Game's name is Adventure.**  

## Features  

1. Dialogue between the system and the user;  

2. Мар reading;  

3. Мap drawing;  

4. Finding the shortest path;  

5. Checking the files (map validation);  

6. Battle with a monster.  

## Linked requirements  

**[1 feature]**  

- Requirement 3: The system is interactive via dialogues.

- Requirement 4: User can choose a map from a set. 

- Requirement 6: The starting point on the map is always the top left corner.   

- Requirement 9: The system moves the player towards the exit.   

- Requirement 10: After each step there’s a chance to encounter a monster.   

- Requirement 11: User can run away, which leads to the game over or engage in a fight.   

- Requirement 17: The system can consider the game lost, if the player lost all of his HP.    

- Requirement 18: The system can invoke an encounter at the end if the player didn’t meet any goblins along the map.    

- Requirement 19: The system can consider the game won, if the player is on the map exit. 

- Requirement 20: After the game ends, the user must be able to restart or exit the game.  

- Requirement 21: The system shuts down if the user chooses to exit the game.  

**[2 feature]**  

- Requirement 1: The map loads from the .txt file. 

**[3 feature]**  

- Requirement 2: The map is generated with ASCII symbols.   

- Requirement 8: the system can draw the shortest path.   

**[4 feature]**  

- Requirement 7: The system can find the shortest path to the exit, which is the edges of the map.   

**[5 feature]**  

- Requirement 5: The system should output an error if the file cannot be read. 

- Requirement 22: The system checks if the document is a map.  

- Requirement 23: The system checks the map for entry and exit, path.  

**[6 feature]**  

- Requirement 5: User has HP and attack stats. 

- Requirement 12: The system can show the current HP of the player and the monster.  

- Requirement 13: User can roll the dice.  

- Requirement 14: The system can roll the dice for the monster.  

- Requirement 15: The system can compare the results of the dice rolls, so the user or the monster can strike with a random damage.  

- Requirement 16: The attack stat affects the possible damage.  

## Linked classes  

**[1 feature]** 

### Class Main: 

``` 
MainUI:mainUI;  

function showMenu()   
input: none  
output: String   
the function shows options of menu 

``` 

 

### class MainUI   
``` 
GameUi:gameUI;  

function startGame()   
input: none  
output: none  
the function starts the application and initializes the game   

function exitGame()   
input: none  
output: none    
the function finishes the application   
 
function showRules()   
input: none   
output: String   
the function shows rules message   

``` 

### class GameUI  
``` 
Game:game;  
Player:player;  
GameMap:gameMap;   

function playerInit(String name)   
input: String name   
output: String name    
the function initializes Player for game. Return Player name and display welcome message for user   

function showMaps()   
input: none  
output: none   
the function shows maps for choosing   

function chooseMap()   
input: none  
output: none  
the function initializes map for game   

function showChosenMap()   
input: none  
output: none  
the function shows chosen map   

function showShortestPathOfChosenMap()   
input: none  
output: none  
the function shows shortest path of chosen map   
``` 
**[2 feature]** 

### class MapReader   
```
FileReader: fileReader;   
  
function getMap(String pathToFile)   
input: String   
output: String[][]   
the function reads txt file (chosen map) and writes it in string array, then return string array.   
``` 

**[3 feature]** 

### class GameMap   

```
Path:pathToListOfMaps;   
List:listOfMap;   
MapReader:mapReader;   
String[][]:gameMap;   
String[][]:gameMapWithShortPath;   
List:indexesOfShortPath;   
boolean:ifExistExitInMapGame;   
Int[]:current_pos   
  
function setGameMap(String pathToFile)   
input: String   
output: none  
the function initializes map(chosen) for game - gameMap   

function getListOfMaps(Path pathToListOfMaps)   
input: Path 
output: list   
Initialize list of Maps. Return List:listOfMap   
``` 

**[4 feature]** 

### class GameMap 

``` 
function findShortPath(String[][] gameMap)   
input: String[][]  
output: list 
the function finds short path in the game map(chosen map). Return List - indexesOfShortPath   
```

**[5 feature]** 

### class GameMap 

``` 

function isMapValid(String[][] gameMap)   
input:String[][]   
output:boolean   
the function validate the map.   

``` 

**[6 feature]** 

### class Game   

``` 
Player:player;  
Monster:monster;  
boolean:encounter;   
boolean:decisionOfPlayerAboutEncounter;   

function makeStep()   
input: String - /n   
output: none   
the function moves the player on the map. Change the position of player at map.   

function isEncounter()   
input: int[][]   
output: boolean   
the function generates decision if there is a monster on this step   

function isBattleAccepted()   
input: none  
output: boolean   
the function output the decision of player if he wants to fight against encounter.   

function fight(Player player, Monster monster)   
input: Player, Monster   
output: none   
the function decreases HP from Monster and Player   

function rollDice()   
input: none   
output: int value   
the function returns a random number (1-6)   

function checkHPOfPlayerAndMonster(Player player, Monster monster)   
input: Player, Monster   
output: none  
the function compare remain HP of Monster and Player and make a conclusion of what do next: next step or fight again   
``` 

 

 

## Testing strategy  

**[1 feature]**  

- Requirement 3: We will start system and check dialogues.  

- Requirement 4: We will enter every map from the set to check if all work. 

- Requirement 6: We will go through every map and check the start. 

- Requirement 9: We will enter the game to see how player moves to exit. 

- Requirement 10: We will start the game and check the randomizer.  

- Requirement 11: We will check if “run away“ works and if it cause the game over. 

- Requirement 17: We will loose all player’s hp during the game to see if the game ends. 

- Requirement 18: We will manualy enter the chance of every spot to 0, end check if the encounter comes at the end of map. 

- Requirement 19: We will enter the end of map and check is there is a Winner message. 

- Requirement 20: After we check R19, we will check if restart works. 

- Requirement 21: We will choose the exit and check if system shuts down. 

**[2 feature]**  

- Requirement 1: We will check if system loads the map from txt. 

**[3 feature]**  

- Requirement 2: We will check for symbols in map generetor. 

- Requirement 8: We will check if drawing map is the similar as algorythm in R7. 

**[4 feature]**  

- Requirement 7: We will check if the map is shortest through counting manualy.    

**[5 feature]**  

- Requirement 5: We will check if there is an error after the non-readable file. 

- Requirement 22: We will check if there is an error to the different from the map document. 

- Requirement 23: We will check if there is an error if map has no exit and entry.  

**[6 feature]**  

- Requirement 5: We will check if an User instance has an HP.  

- Requirement 12: We will check in console if the system shows user and monster HP. 

- Requirement 13: We will check the function of rolling the dice to user. 

- Requirement 14: We will check the function of rolling the dice to monster. 

- Requirement 15: We will check if function of comprataion is working well. 

- Requirement 16: We will check if all stats affect correctly to the damage. 

## User journey  

**[1 feature]**  

User sees all the messages in console and writes commands.  

**[2 feature]**  

User enters the name of the file with a map.  

**[3 feature]**  

User sees a read map in the console.  

**[4 feature]**  

User sees an map with the shortest path.  

**[5 feature]**  

User would see, if the read map did not pass the validation.  

**[6 feature]**  

User rolls numbers and sees message (win,lose,roll again).  

**User Journey scheme**  

![User Journey](https://git.syberry.com/syberry-academy/syberry-academy-season-8/liftoff/crew-4922-i/-/raw/Task468957/documentation/user-journey.png)

## Responsible person for feature  

**[1 feature]** Volodymyr Boiko(deadline 14/10)  

**[2 feature]** Roman Gulievich (deadline 14/10)  

**[3 feature]** Roman Gulievich (deadline 14/10)  

**[4 feature]** Vsevolod Kurochka(deadline 14/10)  

**[5 feature]** Roman Gulievich (deadline 14/10)  

**[6 feature]** Volodymyr Boiko (deadline 14/10)  