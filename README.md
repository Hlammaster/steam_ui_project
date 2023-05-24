<h1 >Демопроект автоматизации UI на сайте <a href="https://store.steampowered.com/ ">Steam</a></h1>

![Steam_logo](images/logo/steam.jpg)

## :bookmark_tabs: Содержание 

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Реализованные проверки</a>

* <a href="#console">Запуск тестов из терминала</a>

* <a href="#jenkins">Запуск тестов в Jenkins</a>

* <a href="#allure">Allure отчеты</a>

* <a href="#allure_testops">Интеграция с Allure TestOps</a>

* <a href="#telegram">Уведомления в Telegram с использованием бота</a>

* <a href="#video">Пример прогона теста в Selenoid</a>

<a id="tools"></a>
## Технологии и инструменты

| Java                                                                                                      | IntelliJ Idea                                                                                                               | GitHub                                                                                                     | JUnit 5                                                                                                           | Gradle                                                                                                     | Selenide                                                                                                         | Selenoid                                                                                                                  | Allure                                                                                                                             |                                                                                                            Jenkins | Allure TestOps                                                                                                             |
|:----------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------:|----------------------------------------------------------------------------------------------------------------------------|
| <a href="https://www.java.com/"><img src="images/logo/java.png" width="50" height="50"  alt="Java"/></a>  | <a id ="tech" href="https://www.jetbrains.com/idea/"><img src="images/logo/idea.png" width="50" height="50"  alt="IDEA"/></a>| <a href="https://github.com/"><img src="images/logo/github.png" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="images/logo/junit5.png" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="images/logo/gradle.png" width="50" height="50"  alt="Gradle"/></a> | <a href="https://selenide.org/"><img src="images/logo/selenide.png" width="50" height="50"  alt="Selenide"/></a> | <a href="https://aerokube.com/selenoid/"><img src="images/logo/selenoid.png" width="50" height="50"  alt="Selenoid"/></a> | <a href="https://github.com/allure-framework"><img src="images/logo/allure.png" width="50" height="50"  alt="Allure"/></a> |  <a href="https://www.jenkins.io/"><img src="images/logo/jenkins.png" width="50" height="50"  alt="Jenkins"/></a>  | <a href="https://qameta.io/"><img src="images/logo/allure_testops.png" width="50" height="50"  alt="allure_testops"/></a>  |

<a id="cases"></a>
## :ballot_box_with_check: Реализованные проверки

- :small_blue_diamond: Параметризованный тест добавления игры в корзину 
- :small_blue_diamond: Проверка перехода по ссылкам из выпадающего списка 'COMMUNITY'
- :small_blue_diamond: Параметризиорванный тест выбора игр по жанрам 
- :small_blue_diamond: Параметризованный тест смены языка на Украинский, Английский, Русский
- :small_blue_diamond: Параметризированный тест поиска игр

<a id="console"></a>
## :computer: Запуск тестов из терминала
### Локальный запуск тестов

```
gradle clean test -Denv=local
```

### Запуск тестов на удаленном браузере

```
gradle clean test -Denv=remote
```

<a id="jenkins"></a>
## <img src="images/logo/jenkins.png" width="25" height="25"/></a> Запуск тестов в Jenkins

<a target="_blank" href="https://jenkins.autotests.cloud/job/Sukhinin_diplom_final/#">Сборка в Jenkins</a>
<p align="center">

<a href="https://jenkins.autotests.cloud/job/Sukhinin_diplom_final/#"><img src="images/screenshots/sborkaJenkins.png" alt="Jenkins"/></a>
</p>

<a id="allure"></a>
## <img src="images/logo/allure.png" width="25" height="25"/></a> Allure отчеты

### Основное окно

<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/allureMain.png">
</p>

### Тесты

<p align="center">
<img title="Allure Tests" src="images/screenshots/exampleTest.png">
</p>

<a id="allure_testops"></a>
## <img src="images/logo/allure_testops.png" width="25" height="25"/></a> Интеграция с Allure TestOps

### Тест кейсы

<p align="center">
<img title="Allure TestOps Overview Dashboard" src="images/screenshots/allure_testops_case.png">
</p>

<a id="telegram"></a>
## <img src="images/logo/telegram.png" width="25" height="25"/></a> Уведомления в Telegram с использованием бота

<p >
<img title="telegram bot" src="images/screenshots/telegramAlert.png">
</p>

<a id="video"></a>
## <img src="images/logo/selenoid.png" width="25" height="25"/></a> Пример прогона теста в Selenoid

> К каждому тесту в отчете прилагается видео.
<p align="center">
  <img title="Selenoid Video" src="images/video/results.gif">
</p>
