# TaskForSolutionFactory
Задача: спроектировать и разработать API для системы опросов пользователей.\
Функционал для администратора системы: 
- авторизация в системе (регистрация не нужна)
- добавление/изменение/удаление опросов. Атрибуты опроса: название, дата старта, дата окончания, описание. После создания поле "дата старта" у опроса менять нельзя 
- добавление/изменение/удаление вопросов в опросе. Атрибуты вопросов: текст вопроса, тип вопроса (ответ текстом, ответ с выбором одного варианта, ответ с выбором нескольких вариантов)  \
Функционал для пользователей системы:  
- получение списка активных опросов 
- прохождение опроса: опросы можно проходить анонимно, в качестве идентификатора пользователя в API передаётся числовой ID, по которому сохраняются ответы пользователя на вопросы; один пользователь может участвовать в любом количестве опросов 
- получение пройденных пользователем опросов с детализацией по ответам (что выбрано) по ID уникальному пользователя  \
Использовать следующие технологии: Spring Framework. 


Запуск контейнера производится командой: docker-compose up \
Остановка контейнера производится командой: docker-compose stop 

Url: \
http://localhost:8082/surveys  - Добавление опроса. (Post метод) Пример json \
{
  "name": "Anketa3",
  "start": "2022-02-20",
  "finish": "2022-02-23",
  "description": "questionnaire collection"
} 

http://localhost:8082/surveys/  - Получение всех существующих опросов (Get метод). 

http://localhost:8082/surveys/status - Проверка на админство (Метод Post) . Пример json \
{
  "status": "Admin",
  "login": "Tamik",
  "password": "password"
} 

http://localhost:8082/surveys/{id} - Изменение опроса (Patch метод) Пример json \
{
  "name": "Anketa3",
  "start": "2022-02-20",
  "finish": "2022-02-23",
  "description": "questionnaire collection"
} 

http://localhost:8082/surveys/{id} - Удаление опроса (Delete метод) 

http://localhost:8082/survey/{idSurvey}/questions/  - Добавление вопроса.  (Метод Post) . Пример json \
{
  "question": "Gender?",
  "typeQuestion": "WITH_ONE_CHOICE",
  "answerOptionsList": [
    "man",
    "woman",
    "attackHelicopter"
  ]
} 

http://localhost:8082/survey/{idSurvey}/questions/{idQuestion}  - Изменение вопроса (Patch метод) Пример json \
{
  "question": "Gender?",
  "typeQuestion": "WITH_ONE_CHOICE",
  "answerOptionsList": [
    "man",
    "woman",
    "attackHelicopter"
  ]
}

http://localhost:8082/survey/{idSurvey}/questions/{idQuestion}  - Удаление вопроса (Delete метод)

http://localhost:8082/answer/{idSurvey}/{identifierUser}/result - Сохранение ответов на вопросы. Пример Json \
 [
    {
      "question": "Name and LastName?",
      "type": "TEXT",
      "answer": [
        "Kozhiev Taimyraz Kazbekovich"
      ]
    },
    {
      "question": "Gender?",
      "type": "WITH_ONE_CHOICE",
      "answer": [
        "man"
      ]
    },
    {
      "question": "hobby?",
      "type": "WITH_MULTIPLE_CHOICE",
      "answer": [
        "car",
        "sport",
        "eating food"
      ]
    }
  ]

http://localhost:8082/answer/result-surveys/{identifier} - Получение пройденых опросов 

http://localhost:8082/answer/{idSurvey}/result - Получение результатов опроса





