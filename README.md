# Tarot API 



The API REST is formed by 4 resources that allow us to make a card spread with both traditional tarot cards and your own customized cards, as well as playing some games with them, or obtain a card that represents your day.


### Card Resource ###
| HTTP  | URI | Description |
| ------------- | ------------- | ------------- |
| GET |  /cards | Returns all the cards available. •	It is possible to order them with the query "order" depending on name, -name, suit and -suit •	It is also possible to filter them by the suit with the query "suit" depending on Major Arcana or Minor Arcana • Finally is possibloe to filter them by the name with the query "name" |
| GET | /cards/{id}  |  Return the card with id=CardId. If it does not exist it returns “404 Not Found”. |
| GET | /cards/dailyCard  |  Returns the card of the day, so we have the card that would be predicting our day. |
| POST | /cards| Add a new card, whose attributes have to be specified in the body of type JSON (not the id which is automatically generated). To add a card a password is needed bacause is is not intended for a non-admin user to create traditional tarot cards . If it is correctly added, it returns “201 Created” with a reference to the URI and the new Card body|
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
| PUT | /spreads | Update the spread with the attributes specified in the JSON body (it must include the id of the spread).  If it does not exists it returns “404 Not Found”. If it is correctly updated it returns “204 No Content”. |
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
