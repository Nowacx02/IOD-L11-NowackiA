Adam Nowacki 155838

Odpowiedzi na pytania:

Pytanie 3.1:
Testy przestałyby działać, ponieważ @BeforeAll wywołuje metodę tylko raz przed wszystkimi testami, podczas gdy @BeforeEach wywołuje ją przed każdym testem. Obiekt Calculator musiałby być tworzony przed każdym testem.

Pytanie 4.1:
Metoda z błędną asercją będzie oznaczona jako Failure, a metoda rzucająca wyjątek jako Error.

Pytanie 4.2:
JUnit oczekuje wyjątku typu AssertionError do oznaczenia testu jako Failure.

Pytanie 5.1:
Testowanie typu whitebox.

Pytanie 5.2:
4 możliwe ścieżki w metodzie calculate:
customer.isSubscriber() == true
customer.getLoyaltyLevel() == SILVER
customer.getLoyaltyLevel() == GOLD
customer.getLoyaltyLevel() == STANDARD.
















