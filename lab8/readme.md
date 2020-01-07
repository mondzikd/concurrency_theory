# Lab 8

## Zadanie 1
1. Wybrać duży zbiór tekstowy (ponad 100k zdań) i wprowadzić losowo 100 podwójnych spacji.
2. Przy pomocy jednego wątku napisać program liczący ilość słów (wykorzystać stream).
3. Wprowadzić równoległość przy liczeniu słów. Pomyśleć nad spliteratorem?

## Zadanie 2
Przy pomocy RecursiveTask zaimplementuj metodę sumowania tablicy liczb o długości co najmniej 10 mln liczb.

## Zadanie 3
Znajdź serwis internetowy dostępny po REST tak by w sposób synchroniczny zwracał jakąś pewną informację przykładowo cenę produktu ze sklepu. Napisz 2 programy, gdzie każdy z tych programów w tym samym czasie będzie chciał poznać cenę dla 200 produktów. Pierwszy program powinien nie wykorzystywać równoległości. Drugi program powinien wykorzystywać CompletableFuture i zwrócić szczególną uwagę na kwestie wykorzystania wątków.




