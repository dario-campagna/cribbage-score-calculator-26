Behaviors

- Parse the string representation of a Cribbage Hand
- Compute the score of a Cribbage Hand
  - Fifteen-twos
  - Pairs
  - Runs
  - Flush
- Print the score

Tests

- Parsing
  - ~~"5♥5♦5♠J♣5♣" -> Cribbage Hand with Hand Cards five of hearts, five of diamonds,... and a starter card 5 of clubs~~
  - ~~"5♥" -> Card with suit hearts~~
  - ~~"5♥" -> Card with rank 5~~
  - ~~"0♦" -> Card with rank 10~~
  - ~~"0♦" -> Card with suit diamonds~~
  - ~~"A♠" -> Card with rank Ace and suit spades~~
- Flush
  - "3♣7♣A♣K♣J♦" -> 4 points
  - "3♣7♣A♣K♣J♣" -> 5 points
  - "J♣7♥A♣K♦3♣" -> 1 points (one for his nob)
- Pairs
  - ~~"5♥5♦A♠2♣6♣" -> 2~~
  - ~~"A♥A♦A♠2♣6♣" -> 6~~
  - ~~"6♥Q♦Q♠Q♣Q♥" -> 12~~
- Fifteen Twos
  - ~~"5♥Q♦A♠7♣6♠" -> 2 points~~
  - ~~"A♥A♦2♠2♣3♣" -> 0 points (no combination sums to 15)~~
  - ~~"5♥0♦J♠2♣A♣" -> 4 points (5+10, 5+J)~~
  - ~~"K♥Q♦J♠0♣5♣" -> 8 points (each face card or ten with the 5)~~
  - ~~"A♥2♦3♠4♣5♣" -> 2 points (all five cards sum to 15)~~
  - ~~"5♥5♦5♠J♣5♣" -> 16 points (four 5+J and four 5+5+5)~~
- Runs
  - "J♦Q♥K♠A♣2♣" -> 3 (run of three)
  - "9♦0♥J♠A♣2♣" -> 3 (another run of three)
  - "0♦J♥Q♠A♣9♦" -> 4 (run of four)
- Multiple rules apply
  - "3♣7♣A♣K♣K♦" -> 6 points
  - "5♥Q♦Q♠7♣6♠" -> 9 points
  - "5♥5♦5♠J♣5♣" -> 29
  - ~~"7♥7♦8♠8♣A♥" -> 14 points (two pairs 4 + fifteen twos 10: four 7+8 and 7+7+A)~~
  - ~~"5♥5♦0♠A♣2♣" -> 6 points (one pair 2 + fifteen twos 4: two 5+10)~~