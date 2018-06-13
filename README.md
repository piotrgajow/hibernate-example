# hibernate-example

Project showing basic features of Hibernate.
Projekt prezentujący podstawowe funkcjie Hibernate'a.

## Wstęp

1. Projekt do działania potrzebuje serwer bazy danych MySQL działający lokalnie na porcie 3306 (domyślny dla MySQL).
2. Aplikacja łączy się z bazą o nazwie `hibernate_example` logując się na użytkownika `root` bez hasła.

## Przykłady

Przykłady znajdują się na osobnych branchach. Na każdym branchu w pliku `src/main/resources/schema.sql` znajdują się zapytania SQL przygotowujące bazę danych (tabele i dane), które trzeba wykonać na bazie danych.

### Branch: [master](https://github.com/piotrgajow/hibernate-example/tree/master)
Bazowy projekt Hibernate. Zawiera niezbędne zależności Maven'a (`pom.xml`), konfigurację Hibernate (`src/main/resources/hibernage.cfg.xml`) oraz przygotowanie `SessionFactory` (`src/main/java/hibernate/HibernateHelper.java`)

### Branch: [entityBasics](https://github.com/piotrgajow/hibernate-example/tree/entityBasics)
Mapowanie encji przy pomocy adnotacji na przykładzie książki (`src/main/java/hibernate/entities/Book.java`). Plik `src/main/java/hibernate/examples/EntityManipulationExamples.java` zawiera przykłady manipulowania encjami (CRUD) - dodawanie, odczytywanie, aktualizowanie i usuwanie.

### Branch: [relation/one-to-one](https://github.com/piotrgajow/hibernate-example/tree/relation/one-to-one)
Relacja jeden do jednego na przykładzie książki i autora (zakładając, że książka ma tylko jednego - głównego - autora, a autor ma tylko jedną - pierwszą - książkę). Odpowniednie mapowanie `@OneToOne` w klasach `Book.java` i `Author.java` oraz przykład pobierania danych.

### Branch: [relation/many-to-one](https://github.com/piotrgajow/hibernate-example/tree/relation/many-to-one)
Relacja wiele do jednego na przykładzie książki i autora (zakładając, że książka ma tylko jednego - głównego - autora, a autor może mieć wiele książek). Odpowniednie mapowanie `@ManyToOne` i `@OneToMany` w klasach `Book.java` i `Author.java` oraz przykład pobierania danych.

### Branch: [relation/many-to-many](https://github.com/piotrgajow/hibernate-example/tree/relation/many-to-many)
Relacja wiele do wielu na przykładzie książki i autora (zakładając, że książka może mieć wielu autorów, a autor może mieć wiele książek). Odpowniednie mapowanie `@ManyToMany` w klasach `Book.java` i `Author.java` oraz przykład pobierania danych.

## Konfiguracja
Do pliku `hibernate.cfg.xml` można dodać więcej parametrów

- `hibernate.show_sql` - ustawia logowanie wysyłanych zapytań do bazy danych
    - `true` - włączone
    - `false` - wyłączone
    
- `hibernate.hbm2ddl.auto` - konfiguruje generowanie schematu bazy danych na podstawie mapowań
    - `validate` - waliduje zgodność bazy danych z mapowaniami
    - `update` - aktualizuje bazę
    - `create` - Usuwa istniejącą bazę i tworzy ją od nowa
    - `create-drop` - Jak przy `create`, ale dodatkowo usuwa bazę w momencie zamknięcia `SessionFactory`

## Uwagi
W przypadku pytań bądź uwag polecam zgłaszanie ich przy pomocy mechanizmu [GitHub issues](https://github.com/piotrgajow/hibernate-example/issues/new)
