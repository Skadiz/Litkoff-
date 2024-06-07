##	class Main 
    MainUI:mainUI;
```
function showMenu() 
input: none
output: String 
the function shows options of menu
```
##	class MainUI 
    GameUi:gameUI;
```
function startGame() 
input: none
output: none
the function starts the application and initializes the game 
```
```
function exitGame() 
input: none
output: none  
the function finishes the application 
```
```
function showRules() 
input: none 
output: String 
the function shows rules message 
```
##	class GameUI
    Game:game;
    Player:player;
    GameMap:gameMap; 
```
function playerInit(String name) 
input: String name 
output: String name  
the function initializes Player for game. Return Player name and display welcome message for user 
```
```
function restart() 
input: none 
output: none  
the function restart the game 
```
```
function showMaps() 
input: none
output: none 
the function shows maps for choosing 
```
```
function chooseMap() 
input: none
output: none
the function initializes map for game 
```
```
function showChosenMap() 
input: none
output: none
the function shows chosen map 
```
```
function showShortestPathOfChosenMap() 
input: none
output: none
the function shows shortest path of chosen map 
```
##	class Game 
    Player:player;
    Monster:monster;
    boolean:encounter; 
    boolean:decisionOfPlayerAboutEncounter; 
```
function makeStep() 
input: String - /n 
output: none 
the function moves the player on the map. Change the position of player at map. 
```
```
function isEncounter() 
input: int[][] 
output: boolean 
the function generates decision if there is a monster on this step 
```
```
function isBattleAccepted() 
input: none
output: boolean 
the function output the decision of player if he wants to fight against encounter. 
```
```
function fight(Player player, Monster monster) 
input: Player, Monster 
output: none 
the function decreases HP from Monster and Player 
```
```
function rollDice() 
input: none 
output: int value 
the function returns a random number (1-6) 
```
```
function checkHPOfPlayerAndMonster(Player player, Monster monster) 
input: Player, Monster 
output: none
the function compare remain HP of Monster and Player and make a conclusion of what do next: next step or fight again 
```
##	class GameMap 
	Path:pathToListOfMaps; 
	List:listOfMap; 
	MapReader:mapReader; 
	String[][]:gameMap; 
	String[][]:gameMapWithShortPath; 
	List:indexesOfShortPath; 
	boolean:ifExistExitInMapGame; 
	Int[]:current_pos 
```
function setGameMap(String pathToFile) 
input: String 
output: none
the function initializes map(chosen) for game - gameMap 
```
```
function getListOfMaps(Path pathToListOfMaps) 
input: none  
output: list 
Initialize list of Maps. Return List:listOfMap 
```
```
function findShortPath(String[][] gameMap) 
input: none 
output: none
the function finds short path in the game map(chosen map). Return List - indexesOfShortPath 
```
```
function isMapValid(String[][] gameMap) 
input:String[][] 
output:boolean 
the function validate the map. 
```
##	class MapReader 
	FileReader: fileReader; 
```
function getMap(String pathToFile) 
input: String 
output: String[][] 
the function reads txt file (chosen map) and writes it in string array, then return string array. 
```
##	class Player
    GameMap:GameMap;
	int:hp; 
	String:name; 
	Int:MonsterCount; 
```
function setName(String name) 
input: String 
output: none
the function set name for Player 
```
```
function getName() 
input: none 
output: none
the function return Player's name 
```
```
function getHP() 
input: none
output: none 
the function return Player's HP 
```
```
function decreaseHP(int damage) 
input:int 
output: none
the function decrease Player's HP 
```
##	class Monster
	int:hp; 
```
function getHP() 
input: 
output: 
the function return Monster's HP 
```
```
function decreaseHP(int damage) 
input:int 
output: 
the function decrease Monster's HP 
```