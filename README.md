# Example using Spring Webflux with Kotlin coroutines, Kotlin DSL and R2DBC

## MySQL - Database
```
create table movies
(
    id        int auto_increment
        primary key,
    title     varchar(255) not null,
    director  varchar(255) not null,
    year      varchar(4)   not null,
    metascore int          not null,
    constraint movies_title_uindex
        unique (title)
);
```
## SQL Inserts Sample
```
INSERT INTO movies.movies (id, title, director, year, metascore) VALUES (1, 'O Senhor dos Anéis: A Sociedade do Anel', 'Peter Jackson', '2001', 92);
INSERT INTO movies.movies (id, title, director, year, metascore) VALUES (2, 'Conta Comigo', 'Rob Reiner', '1986', 75);
INSERT INTO movies.movies (id, title, director, year, metascore) VALUES (3, 'Deadpool', 'Tim Miller', '2016', 65);
INSERT INTO movies.movies (id, title, director, year, metascore) VALUES (4, 'De Volta para o Futuro', 'Robert Zemeckis', '1985', 87);
INSERT INTO movies.movies (id, title, director, year, metascore) VALUES (5, 'Batman: O Cavaleiro das Trevas', 'Christopher Nolan', '2008', 84);
INSERT INTO movies.movies (id, title, director, year, metascore) VALUES (6, 'Os Goonies', 'Richard Donner', '1985', 62);
INSERT INTO movies.movies (id, title, director, year, metascore) VALUES (7, 'Interestelar', 'Christopher Nolan', '2014', 74);
INSERT INTO movies.movies (id, title, director, year, metascore) VALUES (8, 'Casa Comigo?', 'Anand Tucker', '2010', 33);
INSERT INTO movies.movies (id, title, director, year, metascore) VALUES (9, 'De Volta para o Futuro II', 'Robert Zemeckis', '1989', 57);
INSERT INTO movies.movies (id, title, director, year, metascore) VALUES (10, 'O Senhor dos Anéis: As Duas Torres', 'Peter Jackson', '2002', 87);
INSERT INTO movies.movies (id, title, director, year, metascore) VALUES (11, 'O Poderoso Chefão', 'Francis Ford Coppola', '1972', 100);
```

## Endpoints
```
curl --request POST \
  --url http://localhost:8080/movies \
  --header 'Content-Type: application/json' \
  --data '{
	"title": "O Poderoso Chefão",
	"director": "Francis Ford Coppola",
	"year": "1972",
	"metascore": "100"
}'
```

```
curl --request GET \
  --url http://localhost:8080/movies
```

```
curl --request GET \
  --url http://localhost:8080/movies/3
```
