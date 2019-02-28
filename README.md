# Snap!

This kata was inspired following a conversation down the pub with a friend of a friend. He mentioned the game of Snap
which I thought was a nice little coding exercise.

It's interesting from a TDD point of view as I had tried the 'Chicago' method (where I got stuck). Then I tried again
with the 'London' method (that mocks everything). This method proved far easier and helped drive the design. So it
reinforced to me what the London 'mockist' approach is good for, design.

# The Kata

You have a deck of 52 shuffled cards. There are 2 computer controlled players to simulate two real players. 
Each player turns a card. When a subsequent card is turned that matches the value of the previous card, the player with
the quickest reactions to say SNAP, wins the game.

The fun part of this kata is we want to see the computer controlled players in real time. We don't want instant feedback
when you run the app. We want some drama!
