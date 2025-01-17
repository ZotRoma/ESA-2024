<h1>Лабораторная работа #2. Application using Spring Framework </h1>
<h2>Задание 1</h2>
<p>Был выбран Spring REST из-за множества функционала и большого количества документации</p>
<h2>Задание 2</h2>
<p>Все входные данные могут быть как в формате xml/json, так и в формате json. Все выходные данные могут быть представлены в форматах xml/json/html.</p>
<h2>Задание 3 - 6</h2>
<p>Примеры запросов</p>
<p>Больше запросов можно увидеть в папке httpRequest</p>

<p>Post: </p>

```
POST http://localhost:8080/LabRest_war/games
Content-Type: application/json
Accept: application/json

{

  "numberKillsRadiant": 15,
  "numberKillsDire": 16,
  "whoWin": "Dire",
  "time": 1323
}
```

<p>Put: </p>

```
PUT http://localhost:8080/LabRest_war/games
Content-Type: application/json

{
  "gameId" : 1,
  "numberKillsRadiant": 15,
  "numberKillsDire": 21,
  "whoWin": "Dire",
  "time": 1980
}
```

<p>Get: </p>

```
GET http://localhost:8080/LabRest_war/games
Content-Type: application/jsons
```

<p>Результат: </p>

```
{
  "games": [
    {
      "time": 2090,
      "numberKillsRadiant": 15,
      "numberKillsDire": 20,
      "whoWin": "Dire",
      "gameId": 102
    },
    {
      "time": 1234,
      "numberKillsRadiant": 12,
      "numberKillsDire": 21,
      "whoWin": "Radiant",
      "gameId": 103
    },
    {
      "time": 1423,
      "numberKillsRadiant": 32,
      "numberKillsDire": 33,
      "whoWin": "Radiant",
      "gameId": 202
    },
    {
      "time": 122,
      "numberKillsRadiant": 2,
      "numberKillsDire": 1,
      "whoWin": "Dire",
      "gameId": 252
    },
    {
      "time": 1980,
      "numberKillsRadiant": 15,
      "numberKillsDire": 21,
      "whoWin": "Dire",
      "gameId": 1
    },
    {
      "time": 1323,
      "numberKillsRadiant": 15,
      "numberKillsDire": 16,
      "whoWin": "Dire",
      "gameId": 352
    }
  ]
}
```

<p>Delete: <p>

```
DELETE http://localhost:8080/LabRest_war/games?id=302
Content-Type: application/json
```

<h2>Графическая демонстрация</h2>

![alt text](./image/image.png)
![alt text](./image/image-2.png)
![alt text](./image/image-3.png)
![alt text](./image/image-4.png)
![alt text](./image/image-5.png)
![alt text](./image/image-8.png)
![alt text](./image/image-9.png)
![alt text](./image/image-10.png)
<p>Можно увидеть, что все изменения произошли<p>


<p>Вывод все страниц<p>

![alt text](./image/image-11.png)
![alt text](./image/image-12.png)
![alt text](./image/image-13.png)