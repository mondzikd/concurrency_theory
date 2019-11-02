# Lab 1

- Napisac program BEZ SYNCHRONIZACJI, w ktorym mamy obiekt klasy Counter przechowywujący pewną zmienną całkowitą oraz dwie metody inkrementującą i dekrementującą.
Nastepnie jeden watek wywoluje na tym obiekcie metode inkrementująca 100000000 razy, drugi dekrementująca 100000000 razy.

- Czy wynik zawsze jest zero? Sprawdzić działanie na różnych systemach.

- Wprowadzić synchronizację do programu wykorzystujac slowo kluczowe "synchronized"
Mamy klika procesów produkujacych wiadomosci (szkielet kodu) i kilka konsumujacych wiadomosci (szkielet kodu) do/z jednoelementowego bufora. Zadaniem jest napisanie klasy Buffer z metodami put i take, tak, aby dostep byl synchronizowany uzywajac monitora Javy dla obiektu klasy Buffer. Kazda wiadomosc jest produkowana przez jednego producenta i konsumowana przez jednego, dowolnego konsumenta.

daczego przy sprawdzaniu warunku czy bufor jest pusty/pelny nalezy uzyc instrukcji while , a nie wystarczy instrukcja if.
