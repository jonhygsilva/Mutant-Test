# mutantDNAAnalysis
Api responsável por detectar através da sequência de DNA se o individuo é Mutante ou Humano.

* Um cadeia de DNA é representada por um array de Strings que representam cada linha de uma tabela quadrada
de (NxN) com a sequência de DNA.
* As letras da String só podem ser: (A, T, C, G), que representa cada base nitrogenada do DNA.
* Um DNA pertence a um mutante, se encontrar uma ou mais sequências de quatro
letras iguais nas direções horizontais, verticais ou nas diagonais.

A Api está hospedada em https://mutant-analisys.herokuapp.com

## endpoints:
### mutant (POST)
Endpoint responsável por validar se uma sequência de DNA é referente a um mutante ou a um humano. Se o DNA for de um mutante, o DNA é salvo na base de dados e será retornado o código HTTP 200-OK, caso contrário um HTTP 403-FORBIDDEN.

* Exemplo de uso:
````sh
curl --location --request POST 'https://mutant-analisys.herokuapp.com/mutant' \
--header 'Content-Type: application/json' \
--data-raw '{
    "dna": [
        "GTGACA",
        "GGGTGG",
        "TTAAGT",
        "AGGCGC",
        "CCGCTA",
        "TCACTG"
    ]
}'
````

* Exemplo de entrada:
````sh
{
    "dna": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"
    ]
}
````

## endpoints:
### stats (GET)

Endpoint responsável por verificar as estatísticas de verificações de DNA, que informar a quantidade de DNA’s mutante, quantidade de DNA’s humanos, e a proporção de mutantes para a população humana.
* Exemplo de uso:
````sh
curl --location --request GET 'https://mutant-analisys.herokuapp.com/stats'
````

* Exemplo de retorno:
````sh
{
    "count_mutant_dna": 8,
    "count_human_dna": 11,
    "ratio": 0.72
}
````
## pré requisitos:
 * Java 8
 * Gradle

## Como usar a API:
````sh
* gradlew build
* java -jar -Dserver.port=8080 ./application/build/libs/application-0.0.1-SNAPSHOT.jar
````

