# language: es

Característica: Busqueda en dogpile
  Este feature se trata de hacer una busqueda o multiples busquedas en dogpile y revisar
  los resultados obtenidos de esas busquedas


  Esquema del escenario: Verificar que los resultados con texto relevante al titulo
    Dado Que el usuario entra en dogpile
    Cuando El usuario realiza una busqueda de: rock nacional
    Entonces El usuario deberia ver un texto: <texto>  relevante con el titulo: <titulo>

    Ejemplos:
      | titulo                         |  | texto                                           |
      | Argentine rock - Wikipedia     |  | Argentine Rock Nacional is                      |
      | Nacional Rock – Radio Nacional |  | NACIONAL ROCK. SOMOS EL ROCK.                   |
      | Rock.com.ar                    |  | Rock.com.ar es el sitio web independiente sobre |
      | Amazon.com: rock nacional      |  | 1-16 of over 1,000 results for "rock nacional"  |


