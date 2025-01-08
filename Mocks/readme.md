# Adam Nowacki 155838

## 2.1
Żeby sprawdzić poprawność interakcji metody loadExpenses z obiektem zastępczym bazy danych, należy użyć biblioteki Mockito. W pierwszej kolejności tworzymy zastępczy obiekt bazy danych i konfigurowujemy jego działanie, ustalając, jakie metody mają być wywoływane oraz jakie wartości mają zostać zwrócone. Po uruchomieniu metody loadExpenses, możemy skorzystać z narzędzia InOrder z Mockito, aby sprawdzić, czy metody connect, queryAll oraz close zostały wywołane w odpowiedniej kolejności.

## 5.1
Dla tej samej metody z różnymi argumentami kolejność oczekiwań ma znaczenie. Mockito sprawdza wywołania metod w dokładnie tej kolejności, w jakiej zostały określone oczekiwania. Dlatego ważne jest, aby deklaracje oczekiwań były zachowane w odpowiedniej kolejności, co pozwala uniknąć potencjalnych problemów i zapewnia prawidłowe działanie testów. Zmiana kolejności tych oczekiwań może prowadzić do nieprzewidywalnych rezultatów.
