Behaviors

- Parse the string representation of a Cribbage Hand
- Compute the score of a Cribbage Hand
  - Fifteen-twos
  - Pairs
  - Runs
  - Flush
- Print the score

Tests

- "5♥5♦5♠J♣5♣" -> Cribbage Hand with Hand Cards five of hearts, five of diamonds,... and a starter card 5 of clubs
- ~~"5♥" -> Card with suite hearts~~
- ~~"5♥" -> Card with rank 5~~
- ~~"0♦" -> Card with rank 10~~
~~- "0♦" -> Card with suite diamonds~~
- "A♠" -> Card with rank Ace and suite spades
- "5♥5♦5♠J♣5♣" -> 29
- "0♦J♥Q♠A♣9♦" -> 4