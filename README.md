# TarotAPI


The API REST is formed by 4 resources that allow us to make a card spread with both traditional tarot cards and your own customized cards, as well as playing some games with them.


### Card resource ###
| HTTP  | URI | Descripción |
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


### Recurso spread ###
| HTTP  | URI | Descripción |
| ------------- | ------------- | ------------- |
| GET | /lists  | Ver todas las listas de reproducción existentes. •	Es posible ordenar las listas por nombre con el parámetro de query “order”, que solo acepta dos valores, “name” o “-name”. •	También es posible filtrar las listas devueltas con dos parámetros de query: “isEmpty”, que devuelve listas sin canciones si vale “true” o listas con canciones si vale “false”; “name”, que devuelve las listas cuyo nombre coincida exactamente con el valor del parámetro. |
| GET | /lists/{spreadId} | Devuelve la lista con id=spreadId. Si la lista no existe devuelve un “404 Not Found”. |
| POST | /lists | Añadir una nueva lista de reproducción. Los datos de la lista (nombre y descripción) se proporcionan en el cuerpo de la petición en formato JSON. Las canciones de la lista no se pueden incluir aquí, para ello se debe usar  la operación POST específica para añadir una canción a una lista (a continuación). Si el nombre de la lista no es válido (nulo o vacío), o se intenta crear una lista con canciones, devuelve un error “400 Bad Request”. Si se añade satisfactoriamente, devuelve “201 Created” con la referencia a la URI y el contenido de la lista. |
| PUT | /lists | Actualiza la lista cuyos datos se pasan en el cuerpo de la petición en formato JSON (deben incluir el id de la lista).  Si la lista no existe, devuelve un “404 Not Found”. Si se intenta actualizar las canciones de la lista, devuelve un error “400 Bad Request”. Para actualizar las canciones se debe usar el recurso Card mostrado previamente. Si se realiza correctamente, devuelve “204 No Content”. |
| DELETE | /lists/{spreadId} | Elimina la lista con id=spreadId. Si la lista no existe, devuelve un “404 Not Found”. Si se realiza correctamente, devuelve “204 No Content”. |
| POST |  /lists/{spreadId}/{CardId} | Añade la canción con id=CardId a la lista con id=spreadId. Si la lista o la canción no existe, devuelve un “404 Not Found”. Si la canción ya está incluida en la lista devuelve un “400 Bad Request”. Si se añade satisfactoriamente, devuelve “201 Created” con la referencia a la URI y el contenido de la lista. |
| DELETE | /lists/{spreadId}/{CardId}  | Elimina la canción con id=CardId de la lista con id=spreadId. Si la lista o la canción no existe, devuelve un “404 Not Found”. Si se realiza correctamente, devuelve “204 No Content”.|


Una **lista de reproducción** tiene un _identificador, nombre, descripción y un conjunto de canciones_. La representación JSON de este recurso es:

```cpp
{
	"id":"p5",
	"name":"AISSspread",
	"description":"AISS spread",
	"Cards":[
		{
			"id":"s0",
			"title":"Rolling in the Deep",
			"artist":"Adele",
			"album":"21",
			"year":"2011"
		},

		{			
			"id":"s1",
			"title":"One",
			"artist":"U2",
			"album":"Achtung Baby",
			"year":"1992"
		}
		]
}

```
