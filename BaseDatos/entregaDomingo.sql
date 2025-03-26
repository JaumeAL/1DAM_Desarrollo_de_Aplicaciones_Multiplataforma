
/*1. Escriu un bloc anònim que, donat un ID de llibre, miri si el llibre és seqüela d'algun altre.
Si no ho és, mostra un missatge indicant-ho. Si ho és, mostra un missatge indicant que
el llibre és seqüela d'un altre, juntament amb el títol i l'autor d'aquest altre llibre.
Utilitza una variable que tengui com a valor inicial l'ID del llibre que s'ha de comprovar.
Recordau que podeu utilitzar IS NULL com a operador als IF i que teniu l'operador de concatenació ||

OUTPUT d'exemple (no és seqüela de cap altre llibre):
El llibre Bellas durmientes no és seqüela de cap altre.

OUTPUT d'exemple (és seqüela d'un altre):
El llibre Harry Potter i la cambra secreta i és seqüela de Harry Potter i la pedra filosofal.
*/
DECLARE
    v_id number := 5;
    v_titol varchar2(50);
    v_autor varchar2(50);
    v_seq number;
BEGIN
    SELECT titol, nom, cognoms INTO v_titol, v_autor FROM LLIBRE
    JOIN AUTOR_LLIBRE ON LLIBRE.ID = AUTOR_LLIBRE.ID_LLIBRE
    JOIN AUTOR ON AUTOR.ID = AUTOR_LLIBRE.ID_AUTOR
    WHERE LLIBRE.ID = (SELECT ID_SEQUELA_DE FROM LLIBRE WHERE ID = v_id);

    IF v_titol IS NOT NULL THEN
        DBMS_OUTPUT.PUT_LINE('El llibre ' || (SELECT TITOL FROM LLIBRE WHERE ID = v_id) || ' és seqüela de ' || v_titol || '.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('El llibre ' || (SELECT TITOL FROM LLIBRE WHERE ID = v_id) || ' no és seqüela de cap altre.');
    END IF;
END;
 

/*2. Escriu un bloc anònim que, donat un ID de llibre i un nombre, incrementi el nombre
d'exemplars del llibre en el nombre donat. Per exemple, si el llibre té 10 exemplars i
el nombre donat és 7, al final de l'execucució del bloc ha de tenir 17 exemplars.
Utilitza un FOR per incrementar els exemplars d'un amb un fins arribar al nombre desitjat.
NO podeu incrementar-ho tot de cop.
Imprimeix per pantalla un missatge a cada increment, a més dels valor inicial i final del
nombre d'exemplars del llibre.

OUTPUT d'exemple:
El llibre amb ID 9 té 6 exemplars. S'ha sol·licitat afegir-li 4 exemplars.
Afegit exemplar. Exemplars: 7
Afegit exemplar. Exemplars: 8
Afegit exemplar. Exemplars: 9
Afegit exemplar. Exemplars: 10
Exemplars finals: 10
*/
DECLARE
    v_id number := 8;
    v_exemplars number;
    v_nou_exemplars number := 5;
BEGIN
    SELECT exemplars INTO v_exemplars FROM LLIBRE WHERE ID = v_id;
    DBMS_OUTPUT.PUT_LINE('El llibre amb ID ' || v_id || ' té ' || v_exemplars || ' exemplars. S ha sol·licitat afegir-li ' || v_nou_exemplars || ' exemplars.');

    FOR i IN 1..v_nou_exemplars LOOP
        v_exemplars := v_exemplars + 1;
        DBMS_OUTPUT.PUT_LINE('Exemplat afegit .Exemplars: ' || v_exemplars);
    END LOOP;

    UPDATE LLIBRE SET exemplars = v_exemplars WHERE ID = v_id;
    DBMS_OUTPUT.PUT_LINE('Exemplars finals: ' || v_exemplars);
END;


/*3. Escriu un bloc anònim que, donat un ID de llibre i un nombre, decrementi el nombre
d'exemplars del llibre segons el nombre donat, però sense poder passar mai de 0 exemplars.
Per exemple, si el llibre té 2 exemplars i el nombre donat és 3, al final de l'execucució 
del bloc ha de tenir 0 exemplars, no -1.
Utilitza un FOR per decrementar els exemplars d'un amb un fins arribar al nombre desitjat
o 0, segons el cas.
NO podeu decrementar-ho tot de cop.
Imprimeix per pantalla un missatge a cada decrement, a més dels valor inicial i final del
nombre d'exemplars del llibre.
Si no s'han pogut decrementar les vegades previstes per haver arribat a 0, indica-ho.

OUTPUT d'exemple (No s'arriba a 0 exemplars):
El llibre amb ID 9 té 6 exemplars. S'ha sol·licitat eliminar 4 exemplars.
Eliminat exemplar. Exemplars: 5
Eliminat exemplar. Exemplars: 4
Eliminat exemplar. Exemplars: 3
Eliminat exemplar. Exemplars: 2
Exemplars finals: 2

OUTPUT d'exemple (S'arriba a 0 exemplars):
El llibre amb ID 7 té 3 exemplars. S'ha sol·licitat eliminar 5 exemplars.
Eliminat exemplar. Exemplars: 2
Eliminat exemplar. Exemplars: 1
Eliminat exemplar. Exemplars: 0
No queden més exemplars. 2 exemplars han quedat sense eliminar.
Exemplars finals: 0
*/
DECLARE
    v_id number := 8;
    v_exemplars number;
    v_nou_exemplars number := 5;
BEGIN
    SELECT exemplars INTO v_exemplars FROM LLIBRE WHERE ID = v_id;
    DBMS_OUTPUT.PUT_LINE('El llibre amb ID ' || v_id || ' té ' || v_exemplars || ' exemplars. S ha sol·licitat eliminar ' || v_nou_exemplars || ' exemplars.');

    FOR i IN 1..v_nou_exemplars LOOP
        IF v_exemplars > 0 THEN
            v_exemplars := v_exemplars - 1;
            DBMS_OUTPUT.PUT_LINE('Eliminat exemplar. Exemplars: ' || v_exemplars);
        ELSE
            DBMS_OUTPUT.PUT_LINE('No hi ha més exemplars. ' || v_nou_exemplars - i || ' exemplars han quedat sense eliminar.');
            EXIT;
        END IF;
    END LOOP;

    UPDATE LLIBRE SET exemplars = v_exemplars WHERE ID = v_id;
    DBMS_OUTPUT.PUT_LINE('Exemplars finals:' || v_exemplars);
END;