CREATE TABLE EDITORIAL(
    ID number generated as identity primary key,
    nom varchar2(50)
);

CREATE TABLE LLIBRE (
    ID number generated as identity primary key,
    titol varchar2(50),
    an number,
    exemplars number,
    ID_editorial number NOT NULL,
    ID_sequela_de number,
    foreign key (ID_editorial) references EDITORIAL(ID),
    foreign key (ID_sequela_de) references LLIBRE(ID)
);

CREATE TABLE AUTOR (
    ID number generated as identity primary key,
    nom varchar2(50),
    cognoms varchar2(50),
    data_naix date,
    nacionalitat varchar2(3)
);

CREATE TABLE AUTOR_LLIBRE(
    ID_autor number,
    ID_llibre number,
    primary key(ID_autor, ID_llibre),
    foreign key (ID_autor) references AUTOR(ID),
    foreign key (ID_llibre) references LLIBRE(ID)
);

CREATE TABLE GENERE(
    nom varchar2(50) primary key
);

CREATE TABLE LLIBRE_GENERE(
    ID_llibre number,
    nom_genere varchar2(50),
    foreign key (ID_llibre) references LLIBRE(ID),
    foreign key (nom_genere) references GENERE(nom),
    primary key (ID_llibre, nom_genere)
);

INSERT INTO EDITORIAL (nom) VALUES ('LaButxaca');
INSERT INTO EDITORIAL (nom) VALUES ('Letras hispánicas');
INSERT INTO EDITORIAL (nom) VALUES ('Planeta');
INSERT INTO EDITORIAL (nom) VALUES ('Anaya');

INSERT INTO GENERE VALUES ('Misteri');
INSERT INTO GENERE VALUES ('Poesia');
INSERT INTO GENERE VALUES ('Fantasia');
INSERT INTO GENERE VALUES ('Aventura');
INSERT INTO GENERE VALUES ('Filosofia');

INSERT INTO AUTOR(nom, cognoms, data_naix, nacionalitat) VALUES ('Federico', 'García Lorca', DATE'1898-06-05', 'ESP');
INSERT INTO AUTOR(nom, cognoms, data_naix, nacionalitat) VALUES ('Manuel', 'de Pedrolo i Molina', DATE'1918-04-01', 'ESP');
INSERT INTO AUTOR(nom, cognoms, data_naix, nacionalitat) VALUES ('Joanne', 'Rowling', DATE'1965-07-31', 'GBR');
INSERT INTO AUTOR(nom, cognoms, data_naix, nacionalitat) VALUES ('Stephen', 'King', DATE'1947-09-21', 'USA');
INSERT INTO AUTOR(nom, cognoms, data_naix, nacionalitat) VALUES ('Owen', 'King', DATE'1977-02-21', 'USA');
INSERT INTO AUTOR(nom, cognoms, data_naix, nacionalitat) VALUES ('Shigeru', 'Miyamoto', DATE'1952-09-16', 'JPN');
INSERT INTO AUTOR(nom, cognoms, data_naix, nacionalitat) VALUES ('Hidetaka', 'Miyazaki', DATE'1974-09-19', 'JPN');

--INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES (nomLlibre, any, nombreExemplars, (SELECT ID FROM EDITORIAL WHERE NOM = 'Letras hispánicas'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Bodas de sangre', 1933, 10, (SELECT ID FROM EDITORIAL WHERE NOM = 'Letras hispánicas'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Yerma', 1934, 0, (SELECT ID FROM EDITORIAL WHERE NOM = 'Letras hispánicas'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('La casa de Bernarda Alba', 1936, 12, (SELECT ID FROM EDITORIAL WHERE NOM = 'Letras hispánicas'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Poeta en Nueva York', 1940, 5, (SELECT ID FROM EDITORIAL WHERE NOM = 'Letras hispánicas'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Romancero gitano', 1928, 1, (SELECT ID FROM EDITORIAL WHERE NOM = 'Letras hispánicas'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('El Lazarillo de Tormes', 1554, 2, (SELECT ID FROM EDITORIAL WHERE NOM = 'Letras hispánicas'));

INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Mecanoscrit del segon origen', 1974, 1, (SELECT ID FROM EDITORIAL WHERE NOM = 'LaButxaca'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Totes les bèsties de càrrega', 1965, 5, (SELECT ID FROM EDITORIAL WHERE NOM = 'LaButxaca'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Joc brut', 1965, 2, (SELECT ID FROM EDITORIAL WHERE NOM = 'LaButxaca'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Trajecte final', 1981, 6, (SELECT ID FROM EDITORIAL WHERE NOM = 'LaButxaca'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Es vessa una sang fàcil', 1954, 5, (SELECT ID FROM EDITORIAL WHERE NOM = 'LaButxaca'));

INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Harry Potter i la pedra filosofal', 1997, 0, (SELECT ID FROM EDITORIAL WHERE NOM = 'Planeta'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial, id_sequela_de) VALUES ('Harry Potter i la cambra secreta', 1998, 7, (SELECT ID FROM EDITORIAL WHERE NOM = 'Planeta'), (SELECT ID FROM LLIBRE WHERE TITOL = 'Harry Potter i la pedra filosofal'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial, id_sequela_de) VALUES ('Harry Potter i el pres d''Azkaban', 1999, 6, (SELECT ID FROM EDITORIAL WHERE NOM = 'Planeta'), (SELECT ID FROM LLIBRE WHERE TITOL = 'Harry Potter i la cambra secreta'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial, id_sequela_de) VALUES ('Harry Potter i el calze de foc', 2000, 5, (SELECT ID FROM EDITORIAL WHERE NOM = 'Planeta'), (SELECT ID FROM LLIBRE WHERE TITOL = 'Harry Potter i el pres d''Azkaban'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial, id_sequela_de) VALUES ('Harry Potter i l''orde del Fènix', 2003, 4, (SELECT ID FROM EDITORIAL WHERE NOM = 'Planeta'), (SELECT ID FROM LLIBRE WHERE TITOL = 'Harry Potter i el calze de foc'));
INSERT INTO LLIBRE(titol, an, exemplars, id_editorial) VALUES ('Bellas durmientes', 2017, 3, (SELECT ID FROM EDITORIAL WHERE NOM = 'Planeta'));

INSERT INTO AUTOR_LLIBRE SELECT (SELECT id FROM AUTOR WHERE nom = 'Federico'), id FROM LLIBRE WHERE id_editorial = (SELECT id from EDITORIAL WHERE nom = 'Letras hispánicas') and titol != 'El Lazarillo de Tormes';
INSERT INTO AUTOR_LLIBRE SELECT (SELECT id FROM AUTOR WHERE nom = 'Manuel'), id FROM LLIBRE WHERE id_editorial = (SELECT id from EDITORIAL WHERE nom = 'LaButxaca');
INSERT INTO AUTOR_LLIBRE SELECT (SELECT id FROM AUTOR WHERE nom = 'Joanne'), id FROM LLIBRE WHERE id_editorial = (SELECT id from EDITORIAL WHERE nom = 'Planeta') and titol LIKE 'Harry%';
INSERT INTO AUTOR_LLIBRE SELECT (SELECT id FROM AUTOR WHERE nom = 'Stephen'), id FROM LLIBRE WHERE id_editorial = (SELECT id from EDITORIAL WHERE nom = 'Planeta') and titol NOT LIKE 'Harry%';
INSERT INTO AUTOR_LLIBRE SELECT (SELECT id FROM AUTOR WHERE nom = 'Owen'), id FROM LLIBRE WHERE id_editorial = (SELECT id from EDITORIAL WHERE nom = 'Planeta') and titol NOT LIKE 'Harry%';

INSERT INTO LLIBRE_GENERE SELECT id_llibre, 'Poesia' FROM AUTOR_LLIBRE WHERE id_autor = (SELECT id FROM AUTOR WHERE NOM = 'Federico');
INSERT INTO LLIBRE_GENERE SELECT id_llibre, 'Fantasia' FROM AUTOR_LLIBRE WHERE id_autor = (SELECT id FROM AUTOR WHERE NOM = 'Joanne');
INSERT INTO LLIBRE_GENERE SELECT id_llibre, 'Aventura' FROM AUTOR_LLIBRE WHERE id_autor = (SELECT id FROM AUTOR WHERE NOM = 'Manuel') AND rownum < 3;
INSERT INTO LLIBRE_GENERE SELECT id_llibre, 'Misteri' FROM AUTOR_LLIBRE WHERE id_autor = (SELECT id FROM AUTOR WHERE NOM = 'Manuel') AND id_llibre not in (SELECT id_llibre FROM LLIBRE_GENERE);

DELETE FROM LLIBRE_GENERE WHERE id_llibre = (SELECT ID FROM LLIBRE WHERE TITOL = 'Totes les bèsties de càrrega');
DELETE FROM LLIBRE_GENERE WHERE id_llibre = (SELECT ID FROM LLIBRE WHERE TITOL = 'Harry Potter i el calze de foc');
DELETE FROM LLIBRE_GENERE WHERE id_llibre = (SELECT ID FROM LLIBRE WHERE TITOL = 'Bellas durmientes');

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
