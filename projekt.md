# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC4](#uc4): Przekazanie produktu

[Kupujący](#ac2):
* [UC2](#uc2): Złożenie oferty
* [UC3](#uc3): Dokonanie płatności za wygrany produkt
---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Złożenie oferty

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) wybiera produkt i zgłasza chęć złożenia oferty.
2. System wyświetla aktualnie najwyższą ofertę oraz minimalną kwotę przebicia  zgodnie z BR1.
3. [Kupujący](#ac2) podaje kwotę wyższą niż aktualna najwyższa oferta.
4. [Sprzedający](#ac1) weryfikuje poprawność kwoty zgodnie z BR1.
5. [Sprzedający](#ac1) informuje o pomyślnym złożeniu oferty i aktualizuje najwyższą ofertę.

**Scenariusze alternatywne:** 

4.A. Podano kwotę mniejszą niż aktualnie najwyższa oferta lub kwotę niepełną.
* 4.A.1. System informuje o błędnej kwocie i prosi o poprawienie.
* 4.A.2. [Sprzedający](#ac1) prosi [Kupującego](#ac2) o podanie poprawnej kwoty
* 4.A.3. Przejdź do kroku 3.

---

<a id="uc3"></a>
### UC3: Dokonanie płatności za wygrany produkt

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) wybiera wygrany produkt, za który chce dokonać płatności.
2. System wyświetla kwotę do zapłaty oraz dostępne opcje płatności.
3. [Kupujący](#ac2) wybiera opcję płatności i potwierdza chęć zapłaty.
4. System weryfikuje poprawność płatności oraz dostępność środków.
5. [Sprzedający](#ac1) potwierdza dokonanie płatności i informuje o pomyślnym zakończeniu transakcji.

**Scenariusze alternatywne:**

4.A. Płatność nie powiodła się (np. brak środków).
* 4.A.1. System informuje o nieudanej płatności i prosi o wybór innej metody.
* 4.A.2. Przejdź do kroku 2.

<a id="uc4"></a>
### UC4: Przekazanie produktu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Sprzedający](#ac1) potwierdza w systemie gotowość do przekazania produktu.
2. System wysyła powiadomienie do [Kupującego](#ac2) o możliwości odbioru produktu.
3. [Kupujący](#ac2) potwierdza odbiór produktu w systemie.
4. System finalizuje proces przekazania i oznacza transakcję jako zakończoną.

**Scenariusze alternatywne:**

2.A. Kupujący nie odbiera produktu w wyznaczonym terminie.

* 2.A.1. System wysyła przypomnienie o odbiorze.
* 2.A.2. Jeśli produkt nie zostanie odebrany w ciągu dodatkowego okresu, system oznacza transakcję jako nieudaną i informuje [Sprzedającego](#ac1).


## Obiewkty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujących](#ac2), który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | Kupujący | Sprzedający |
| ------------------------------------------------- | ------ | ------- | -------- | ----------- |
| UC1: Wystawienie produktu na aukcję               |    C   |    C    |    -     |      R      |
| UC2: Złożenie oferty                              |    U   |    R    |    C     |      -      |
| UC3: Dokonanie płatności za wygrany produkt                       |    R   |    R    |    U     |      R      |
| UC4: Przekazanie produktu                         |    R   |    U    |    R     |      U      |
