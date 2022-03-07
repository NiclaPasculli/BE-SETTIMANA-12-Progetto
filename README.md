# BE-SETTIMANA-12-Progetto
Progetto Catalogo Libri
http://localhost:8080/swagger-ui.html

Passaggi :
Autenticazione POST/login/auth 
{
  "userName": "admin",
  "password": "admin"
}

copiare solo il token ed in incollarlo in AUTHORIZE

Per inserire un libro associando anche una categoria e/o un autore (questi già esistenti quindi quelli presenti in db) o crearne prima dei nuovi-- esempio :
POST/api/categoria
 {
  "nome": "HORROR",      -------------> CREA UNA CATEGORIA {   
      "id": 0                                                   "nome": "Horror",
}                                                                "id":11
                                                               }   

POST/api/autore

{
	"nome": "Gianni",							{
	cognome: "Bho",   --------------> CREA UN AUTORE    		"nome":"Gianni",
	"id": 0									"cognome":"Bho",
}											"id":10
										}

successivamente inserire un libro con autore e categoria appena creati.
POST/api/libro
{
  "titolo": "Ciao",
  "anno": 2020,
  "prezzo": 12.90,
  "autori": [
    {
      "nome": "Gianni",
      "cognome": "Bho",
      "id": 10
    }
  ],
  "categorie": [
    {
      "nome": "Horror",
      "id": 11
    }
  ],
  "id": 0
}

QUESTO CREA UN LIBRO 
{
  "titolo": "Ciao",
  "anno": 2020,
  "prezzo": 12.90,
  "autori": [
    {
      "nome": "Gianni",
      "cognome": "Bho",
      "id": 10
    }
  ],
  "categorie": [
    {
      "nome": "Horror",
      "id": 11
    }
  ],
  "id": 12
}
