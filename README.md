# Tarot API 
![image](https://user-images.githubusercontent.com/100620336/168632774-d867f9f3-6a1b-4c06-80ad-9a0caa843964.png)





The API REST is formed by 4 resources that allow us to make a card spread with both traditional tarot cards and your own customized cards, as well as playing some games with them.


### Card Resource ###
| HTTP  | URI | Description |
| ------------- | ------------- | ------------- |
| GET |  /cards | Returns all the cards available. •	It is possible to order them with the query "order" depending on name, -name, suit and -suit •	It is also possible to filter them by the suit with the query "suit" depending on Major Arcana or Minor Arcana • Finally is possibloe to filter them by the name with the query "name" |
| GET | /cards/{id}  |  Return the card with id=CardId. If it does not exist it returns “404 Not Found”. |
| GET | /cards/dailyCard  |  Returns the card of the day, so we have the card that would be predicting our day. |
| POST | /cards| Add a new card, whose attributes have to be specified in the body of type JSON (not the id which is automatically generated). To add a card a password is needed bacause it is not intended for a non-admin user to create traditional tarot cards . If it is correctly added, it returns “201 Created” with a reference to the URI and the new Card body|
| POST | /cards/restore| Restores the cards to the original ones of the Tarot . If it is correctly restored, it returns “204 No Content” since we re-created all the cards again|
| PUT | /cards  | Updates the card with the attributes specified in the JSON body (card id must be included). To update a card a password is needed bacause is is not intended for a non-admin user to update traditional tarot cards . If the card does not exists the response returns “404 Not Found”. If it is corrected done it returns “204 No Content”. |
| DELETE | /cards/{id}  |  Deletes the card with the same id. If the card does not exist it returns “404 Not Found”. If the card is correctly deleted it returns “204 No Content”.|

Each **card** has an id, name, suit, upright description and reversed description. The structure of the JSON resource is:

```cpp
 {
        "id": "c31",
        "name": "Ten of Cups",
        "suit": "Minor Arcana-Cups",
        "upright": "Harmony, reunions, security, domestic bliss, found family",
        "reversed": "Dysfunctional family, broken home, instability, conflict, neglect"
 }
```


### Spread Resource ###
| HTTP  | URI | Description |
| ------------- | ------------- | ------------- |
| GET | /spreads  | Returns all the spreads available •	It is possible to filter them by name with the query "name" •	It is also possible to order them  with the query "order" which can receive name and -name |
| GET | /spreads/{id} | Returns the spread with the same id. If it does not exists it returns “404 Not Found”. |
| GET | /spreads/{id}/CardsOfSpread | Returns the cards of the spread with the specified id|
| GET | /spreads/{id}/CustomCardsOfSpread | Returns the custom cards of the spread with the specified id|
| POST | /spreads | Adds a new spread. The body of the JSON has to receive the name, type, description and number of cards(the id is automatically generated). If it is correctly done it returns “201 Created” with the URI reference and the new spread body |
| PUT | /spreads | Update the spread with the attributes specified in the JSON body (it must include the id of the spread). If it does not exists it returns “404 Not Found”. If it is correctly updated it returns “204 No Content”. |
| DELETE | /spreads/{id} | Deletes the spread with the specified id. If the spread does not exists is returns “404 Not Found”. If it is correctly done it returns “204 No Content”. |



A **spread** has an id, name, type, description, and number of cards. The structure of the JSON resource is:

```cpp
{
        "id": "s0",
        "name": "Five-Card Spread",
        "type": "Daily",
        "description": "Card 1 represents the present, Card 2 represents the past, Card 3 represents the future, Card 4 shows unseen influences affecting the 			situation, and Card 5 represents the potential for an alternate future",
        "numCards": 5
}

```
### CustomCard Resource ###
| HTTP  | URI | Description |
| ------------- | ------------- | ------------- |
| GET | /customs  | Returns all the custom cards avilable •	It is possible to filter them by name with the query "name"• Also we can filter by the suit with the query "suit" •	It is also possible to order them  with the query "order" which can receive name and -name • Finally we can also put a limit as well as an offset for filtering the results|
| GET | /customs/{id} | Returns the custom card with the same id. If it does not exists it returns “404 Not Found”. |
| POST | /customs | Adds a new custom card. The body of the JSON has to receive the name, upright description, reversed description and suit(the id is automatically generated). If it is correctly done it returns “201 Created” with the URI reference and the new custom card body |
| PUT | /customs | Updates the custom card with the attributes specified in the JSON body (it must include the id of the custom card).  If it does not exists it returns “404 Not Found”. If it is correctly updated it returns “204 No Content”. |
| DELETE | /customs/{id} | Deletes the custom card with the specified id. If the custom card does not exists is returns “404 Not Found”. If it is correctly done it returns “204 No Content”. |

Each **custom card** has an id, name, upright description ,reversed description and suit. The structure of the JSON resource is:
```
{
        "id": "cc1",
        "name": "Sponge Bob",
        "upright": "Careless, dumb decisions, sacandalous, selfish",
        "reversed": "Educational, obedient, smart decisions",
        "suit": "characters"
}
```
### Game Resource ###
| HTTP  | URI | Description |
| ------------- | ------------- | ------------- |
| GET | /games  | Returns all the games avilable •	It is possible to order them  with the query "order" which can receive name,  -name. origin, -origin • We can also filter them by players with the query "players"• We can filter them by the level with the query "level"• We can also filter by origin with the query "origin"•Finally we can filter the name with the query "name"|
| GET | /games/{id} | Returns the game with the same id. If it does not exists it returns “404 Not Found”. |
| POST | /games | Adds a new custom card. The body of the JSON has to receive the name, origin, number of players, deck description, rules, number of cards and difficulty (the id is automatically generated). If it is correctly done it returns “201 Created” with the URI reference and the new game body |
| PUT | /games | Updates the game with the attributes specified in the JSON body (it must include the id of the custom card).  If it does not exists it returns “404 Not Found”. If it is correctly updated it returns “204 No Content”. |
| DELETE | /games/{id} | Deletes the game with the specified id. If the game does not exists is returns “404 Not Found”. If it is correctly done it returns “204 No Content”. |

Each **game** has an id, name, origin, number of players, deck description, rules, number of cards and difficulty. The structure of the JSON resource is:
```
{
        "id": "g0",
        "name": "Partita",
        "origin": "Italy",
        "numPlayers": 4,
        "deckDescription": "Trumps from I to XXI, The Fool, Spades and Clubs: King, Queen, Cavalier, Valet, Ten to Seven, Diamonds and Hearts: King, Queen, Cavalier, Valet, Ace to Four",
        "rules": "Card strength\nTrumps:\nTrumps are the strongest and always take the trick when played. By strength they go from XXI(the strongest) to VI, and trump I, II, III, III and V are all of equal strength. In case that any of the trumps from I to V are played in the same trick, the last one played wins the trick.\n\nSuits:\nSuits go from strongest to weakest in this order:\n\nSpades and Clubs: King, Queen, Cavalier, Valet, Ten to Seven\nDiamonds and Hearts: King, Queen, Cavalier, Valet, Ace to Four\nThe Fool:\nThe Fool is an excuse. He can be played at any time as an excuse to not play a card. The team that played the Fool takes him into their trick pile.\n\nTeams, the game and the dealer\nPartita is played in fixed teams for an entire game. One game usually consists of four deals, but if you want you can change that, so that you can play the entire night in fixed teams.\n\nTeams are formed in regards to the dealer. Dealer of the next game is always the partner of the player who dealt the last hand of the previous game. The first dealer is chosen at random by card draw.\n\nThe deal\nEach player is dealt 13 cards and the dealer takes the last two, so he has 15 cards. The dealer then discards two cards into his teams trick pile. He can not discard Kings, Trump I or XXI and the Fool. He can only discard trumps if he has no other option, but he has to announce it and show them to the other players.\n\nGameplay\nThe game itself is played like any other tarot trick taking card game. The dealer leads the first trick and other players must follow suite, if they can’t, they have to play a trump, if they don’t have a trump, they can play any card(but it doesn’t win). The player that took the previous trick always leads the next trick. Play continues this way until players run out of cards.\n\nScoring\nScoring is done is done by counting two cards at a time. Each pair of cards is worth 1 point, plus the value of any court cards or the I and XXI of trumps that it might contain. Value of these cards is as follows:\n\nTrump XXI = 4 points\nTrump I = 4 points\nKings = 4 points\nQueens = 3 points\nCavaliers = 2 points\nValets = 1 point\nThe Fool is always counted separately and is worth 5 points.\n\nIf a team has an odd number of cards, the odd empty card is also worth 1 point.\n\nIf a team scored below 40 points, it gets a negative score equal to the difference between 40 and their score.\n\nIf a team scored above 40 points, it gets a positive score equal to the difference between 40 and their score.",
        "numCards": 54,
        "difficulty": "Easy"
}
```
