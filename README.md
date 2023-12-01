# Gomoku

## Overview

Gomoku, also known as Five in a Row, is a classic strategy board game that
originated in East Asia. The objective is for the players to place their
Stones on the board in such a way that they achieve a row of five consecutive
Stones horizontally, vertically or diagonally.
\
This Gomoku implementation was made as the Final Project for the Object-Oriented
Programming class taken by me and my team at the [Colombian School of
Engineering Julio Garavito](https://www.escuelaing.edu.co/es/).

## Base Features

* Game Modes: We have Player vs Engine (PvE) and Player vs Player (PvP) modes.
* Game Types: The game offers three game types
  * Normal: The normal Gomoku gameplay.
  * QuickTime: You have a limited amount of time to win (think fast ;D)
  * Stone Limit: You only have a limited set of stones to win the game. Be smart.

## Added Features

In hopes of making the game more interesting (and to increase difficulty for us
poor students), it was decided to add some new features to the base gomoku game.

* Special Stones: There are special stones that have different effects on the
players and the game.
  * Normal Stone: Nothing special with this one.
  * Heavy Stone: This one counts as 2 stones.
  * Temporal Stone: This one is gone three turns after being placed on board.
* Special Tiles: They activate when any Stone is placed on them.
  * Mine: Obliterates all stones nearby.
  * Teleport: Teleports your stone somewhere across the board.
  * Golden: Grants you a shiny new Stone, if it's normal you have to play two
  Stones in your next turn.

## Get the game
We sadly don't have an official distributable binary or an installer.
But you can download and compile the game from source. All you need is the 
[JVM](https://www.oracle.com/java/technologies/downloads/) and [Git](https://git-scm.com/)
installed on your machine.
```bash
# 1. First let's clone the repo
git clone https://github.com/MiguelMahecha/Gomoku.git

# 2. cd into the created folder
cd ./Gomoku

# 3. Compile the program
javac -d bin -cp src ./src/presentation/GomokuGUI.java

# 4. Run
java -cp bin presentation.GomokuGUI
```

If you face an issue during this process please forgive us and let us know
through an issue, we'll fix it as soon as we can.

## Thanks
We had a lot of fun building this game, if you decide to play it we hope you
enjoy it.
\
We are planning to port the game to the web, enabling multiplayer functionality
along the way. You can follow that progress [here](www.github.com/MiguelMahecha).
