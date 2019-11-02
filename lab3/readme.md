# Lab 3

- Przeanalizuj i przetestuj na swoich producentach i konsumentach monitor BoundedBuffer przeznaczony dla producentow i konsumentow.

- Drukarki
Grupa wątków P (ilosc N) korzysta z M drukarek N>M. Dzialanie wątku
  forever{
    Utworz_zadanie_do_druku();
    nr_drukarki=Monitor_Drukarek.zarezerwuj();
    drukuj(nr_drukarki);
    Monitor_Drukarek.zwolnij(nr_drukarki);
  }
Napisz monitor Monitor_Drukarek.

- Stolik dwuosobowy
Napisz monitor Kelner sterujacy dostepem do stolika dwuosobowego. Ze stolika korzysta N par osob. Algorytm osoby z pary o numerze j:
  forever{
    wlasne sprawy;
    Kelner.chce_stolik(j);
    jedzenie;
    Kelner.zwalniam();
  }
Stolik jest przydzielany parze w momencie gdy obydwie osoby tego zazadaja, zwalnianie nie musi byc jednoczesne.
