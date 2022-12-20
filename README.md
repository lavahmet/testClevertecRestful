## Используемый стек
[Java 17](https://www.oracle.com/java/technologies/downloads/#java17)

[Gradle](https://docs.gradle.org/7.5/userguide/userguide.html)

[Spring Boot](https://spring.io/projects/spring-boot)

[Spring Data](https://spring.io/projects/spring-data)

[PostgreSQL](https://www.postgresql.org/docs/)
## Инструкцию по запуску
Запустить приложение и отправить GET запрос на http://localhost:8080/check  в формате json

```postma
//Пример
//Ввод
[
    {
        "id" : 1,
        "quantity" : 2
    },
    {
        "id" : 4,
        "quantity" : 100
    }
]
//id - это идентификатор товара
//quantity - это количество товара




//Вывод
                    CASH RECEIPT                   

QTY   DESCRIPTION           PRICE        TOTAL
----  -----------           -----        -----

2     Asado Roll            $ 50.0       $ 100.0
1000  Egg Pie               $ 200.0      $ 200000.0

-----------------------------------------------------

TOTAL                                    $ 400000.0
```
