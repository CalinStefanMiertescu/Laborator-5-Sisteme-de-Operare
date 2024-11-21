Utilizarea unui obiect mapat în memorie pentru a facilita comunicarea între două procese care numară de la 1 până la 1000 în memorie astfel:

- citesc memoria;
- dau cu banul (random(2)) cât timp cade 2 scriu în memorie următorul număr;
- eliberează semaforul.

Semaforul este necesar pentru ca memoria este "teren neutru" care poate fi modificat/citit simultan de ambele procese. Procesele sunt văzute ca aplicații individuale de sistemul de operare.
