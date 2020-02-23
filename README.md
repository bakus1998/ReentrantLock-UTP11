# ZAD 1
Zrealizować klasyczny problem współbieżności Producent - Konsument za pomocą:

a. (7p) Locków (ReentrantLock, ...) oraz warunków (Condition). Proszę nie stosować gotowych blokujących kolejek, na to jest podpunkt b.
b. (3p) Blokujących kolejek (ArrayBlockingQueue, ...).


Problem:
Producent produkuje produkty i umieszcza je w buforze, a konsument pobiera je stamtąd w kolejności ich umieszczania.

Szczegóły:

Produkty są liczbami całkowitymi wygenerowanymi (wyprodukowanymi) losowo przez producenta.

Bufor jest obiektem klasy Buffer zawierającej między innymi metody int get() - pobierającą liczbę z bufora i put(int n) - wstawiającą liczbę do bufora. Bufor ma ograniczoną pojemność, podaną w momencie jego utworzenia (w szczególności, bufor może mieć pojemność większą niż 1). W danej chwili dostęp do bufora może mieć albo producent, albo konsument.

Producent jest obiektem klasy Producer (np. implementującej Runnable/Callable). Konstruktor Producer(Buffer b) tworzy nowy obiekt - producent, którego zadaniem jest produkowanie i umieszczanie produktu w buforze b. Przedefiniowana metoda run()/call() zawiera nieskońzoną pętlę: 1. Generuje losowo jedną liczbę całkowitą; 2. Umieszcza ją w buforze za pomocą metody put(int) lub czeka na zwolnienie miejsca (przez konsumenta) w przypadku pełngo bufora; 3. Zasypia na losowy wybrany czas z przedziału od 0 do 2s. 

Konsument jest obiektem klasy Consumer (np. implementującej Runnable/Callable). Konstruktor Consumer(Buffer b) tworzy nowy obiekt - konsument, którego zadaniem jest pobieranie produktu z bufora b i jego konsumowanie. Przedefiniowana metoda run()/call() zawiera nieskończoną pętlę: 1. Pobiera jedną liczbę z bufora za pomocą metody int get() lub czeka na nową liczbę (wstawioną przez producenta) w przypadku pustego bufora; 2. Konsumuje liczbę, czyli wyprowadza ją na konsolę; 3. Zasypia na losowy wybrany czas z przedziału od 0 do 2s.

Testowanie:

1. Utworzyć obiekt klasy Buffer
2. Utworzyć obiekty klas Producer, Consumer oraz uruchomić wątki (za pomocą wykonawcy) symulujące działanie producenta oraz konsumenta na danym buforze.
3. Program zakończy działanie po określonym czasie 15s.

W trakcie działania, program powinien wyprowadzać na zewnątrz jak najwięcej informacji, aby można było śledzić jego przebieg.
