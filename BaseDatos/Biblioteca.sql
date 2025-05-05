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

CREATE TABLE VENDA (
    ID_VENDA NUMBER generated as identity primary key,
    DNI_CLIENT varchar2(9),
    ID_llibre number references llibre(ID),
    DATA_VENDA timestamp,
    preu number(38,2)
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


--• Consulta els noms dels llibres i el nom de la seva editorial.
Select titol, nom from llibre, editorial where llibre.id_editorial = editorial.id;
--• Repeteix la consulta anterior excloent l’editorial Planeta.
select titol, nom from llibre, editorial where llibre.id_editorial = editorial.id and editorial.nom != 'Planeta';
--• Consulta els noms dels llibres i el nom del seu autor.
select titol, nom from llibre ll, autor au, autor_llibre aull where ll.id = aull.id_llibre and aull.id_autor = au.id;
--• Repeteix la consulta anterior, però només mostrant aquells llibres d’un any anterior a 1950.
select titol, nom from llibre ll, autor au, autor_llibre aull where ll.id = aull.id_llibre and aull.id_autor = au.id and ll.an < 1950;
----1. Llista els llibres (títol) amb el seu gènere (nom).
select titol, nom_genere from llibre l, llibre_genere lg where l.id = lg.id_llibre;
--2. Llista els títols i autor (nom i llinatge) dels llibres d'autors espanyols.
select titol, nom, cognoms from llibre ll, autor au, autor_llibre al where ll.id = al.id_llibre and al.id_autor = au.id and a.nacionalitat = 'ESP';
--3. Llista els títols, el gènere (nom) i l'autor (nom i llinatges) de cada llibre. (Si un llibre té més d'un autor o gènere, el seu títol sortir repetit).
Select titol, nom_genere, nom, cognoms from llibre l, llibre_genere lg, autor a, autor_llibre al where l.id = lg.id_llibre and l.id = al.id_llibre and al.id_autor = a.id;
--4. Llista els llibres (títol) amb més d'un autor. (Pista: HAVING)
select titol from llibre ll, autor_llibre al where ll.id = al.id_llibre group by titol having count(*) > 1;
--5. Llista el nombre d'exemplars totals de l'autor "Federico García Lorca".
select sum(exemplars) from llibre l, autor a, autor_llibre al where l.id = al.id_llibre and al.id_autor = a.id and a.nom = 'Federico' and a.cognoms = 'García Lorca';
--6. Llista el nombre d'exemplars totals de cada autor.
select nom, cognoms, sum(exemplars) from llibre l, autor a, autor_llibre al where l.id = al.id_llibre and al.id_autor = a.id group by nom, cognoms;

--Amb JOIN
--1. Llista els autors (nom i llinatges) sense llibres.
select nom, cognoms from autor a left join autor_llibre al on a.id = al.id_autor where al.id_autor is null;
--2. Llista els llibres (títol) amb el seu gènere (nom).
select titol, nom from llibre l left join llibre_genere lg on l.id = lg.id_llibre left join genere g on lg.nom_genere = g.nom;
--3. Llista els llibres (títol) sense gènere.
select titol from llibre l left join llibre_genere lg on l.id = lg.id_llibre where lg.nom_genere is null;
--4. Llista els llibres (títol) sense autor.
select titol from llibre l left join autor_llibre al on l.id = al.id_llibre where al.id_llibre is null;
--5. Llista els títols i autor (nom i llinatge) dels llibres d'autors espanyols.
select titol, nom, cognoms from llibre l inner join autor_llibre al on l.id = al.id_llibre inner join autor a on al.id_autor = a.id where a.nacionalitat = 'ESP';
--6. Llista els títols, el gènere (nom) i l'autor (nom i llinatges) de cada llibre. (Si un llibre té més d'un autor o gènere, el seu títol sortir repetit). Mostra només els que tenen autor conegut i gènere.
select titol, nom_genere, nom, cognoms from llibre l inner join llibre_genere lg on l.id = lg.id_llibre inner join genere g on lg.nom_genere = g.nom inner join autor_llibre al on l.id = al.id_llibre inner join autor a on al.id_autor = a.id;
--8. Repeteix la consulta anterior, però també han de poder sortir els llibres sense gènere ni autor.
select titol, nom_genere, nom, cognoms from llibre l left join llibre_genere lg on l.id = lg.id_llibre left join genere g on lg.nom_genere = g.nom left join autor_llibre al on l.id = al.id_llibre left join autor a on al.id_autor = a.id;
--7. Llista els llibres (títol) amb més d'un autor. (Pista: HAVING)
select titol from llibre l inner join autor_llibre al on l.id = al.id_llibre group by titol having count(*) > 1;
--8. Llista el nombre d'exemplars totals de l'autor "Federico García Lorca".
select sum(exemplars) from llibre l inner join autor_llibre al on l.id = al.id_llibre inner join autor a on al.id_autor = a.id where a.nom = 'Federico' and a.cognoms = 'García Lorca';
--9. Llista el nombre d'exemplars totals de cada autor.
select nom, cognoms, sum(exemplars) from llibre l inner join autor_llibre al on l.id = al.id_llibre inner join autor a on al.id_autor = a.id group by nom, cognoms;

DECLARE
    DNI_Client varchar2(9) := "11111111A" ;
    ID_llibre number := 1;
    exemplars number;

BEGIN
    SELECT exemplars INTO exemplars FROM LLIBRE WHERE ID = ID_llibre
    for idx in 1..exemplars LOOP
    INSERT INTO VENDA(DATA_VENDA,DNI_CLIENT,ID_LLIBRE,PREU) VALUES (SYSTIMESTAMP, CLIENT_DNI,LLIBRE_ID, 10);
    UPDATE LLIBRE SET exemplars = exemplars -1 WHERE ID LLIBRE_ID;

    END LOOP;

END;


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
El llibre amb ID 9 té 6 exemplars. S'ha sol·licitat elic_minar 4 exemplars.
Elic_minat exemplar. Exemplars: 5
Elic_minat exemplar. Exemplars: 4
Elic_minat exemplar. Exemplars: 3
Elic_minat exemplar. Exemplars: 2
Exemplars finals: 2

OUTPUT d'exemple (S'arriba a 0 exemplars):
El llibre amb ID 7 té 3 exemplars. S'ha sol·licitat elic_minar 5 exemplars.
Elic_minat exemplar. Exemplars: 2
Elic_minat exemplar. Exemplars: 1
Elic_minat exemplar. Exemplars: 0
No queden més exemplars. 2 exemplars han quedat sense elic_minar.
Exemplars finals: 0
*/
DECLARE
    v_id number := 8;
    v_exemplars number;
    v_nou_exemplars number := 5;
BEGIN
    SELECT exemplars INTO v_exemplars FROM LLIBRE WHERE ID = v_id;
    DBMS_OUTPUT.PUT_LINE('El llibre amb ID ' || v_id || ' té ' || v_exemplars || ' exemplars. S ha sol·licitat elic_minar ' || v_nou_exemplars || ' exemplars.');

    FOR i IN 1..v_nou_exemplars LOOP
        IF v_exemplars > 0 THEN
            v_exemplars := v_exemplars - 1;
            DBMS_OUTPUT.PUT_LINE('Elic_minat exemplar. Exemplars: ' || v_exemplars);
        ELSE
            DBMS_OUTPUT.PUT_LINE('No hi ha més exemplars. ' || v_nou_exemplars - i || ' exemplars han quedat sense elic_minar.');
            EXIT;
        END IF;
    END LOOP;

    UPDATE LLIBRE SET exemplars = v_exemplars WHERE ID = v_id;
    DBMS_OUTPUT.PUT_LINE('Exemplars finals:' || v_exemplars);
END;


/*1. Crea una funció GET_LLIBREsExempS_BY_AUTOR_ID que, donat un ID d'autor, retorni una NESTED
TABLE amb records dels llibres d'aquest autor.
Crida aquesta funció des d'un bloc anonim passant-li com a parametre un ID d'autor que tengui
llibres i mostra (DBMS_OUTPUT) els seus títols utilitzant alguna estructura iterativa.
*/

DECLARE
    TYPE t_llibresExemp IS TABLE OF LLIBRE%ROWTYPE;
    llibres t_llibresExemp;
    v_id_llibre number;

    FUNTION GET_LLIBREsExempS_BY_AUTOR_ID(mi_ID_Autor number) RETURN t_llibresExemp
    IS
        SELECT llibres BULK COLLECT INTO v_id_llibre FROM AUTOR_LLIBRE WHERE id_autor = mi_ID_Autor
        
BEGIN

    


END;




--ITERACIONS I COL·LECCIONS

/*1.Compta els exemplars totals d'un conjunt de llibres.
Utilitza un FOR LOOP per iterar sobre un rang d'IDs de llibres deterc_minat. El mínim i el màxim del rang han de venir donats per dues constants.
Comença a 0. Per cada iteració, agafa el nombre d'exemplars del llibre corresponent i suma-ho al recompte.
Al final de les iteracions, mostra el nombre d'exemplars total.
OUTPUT d'exemple:
Rang IDs: 3, 6
Recompte total: 20
*/
DECLARE 
    c_min CONSTANT NUMBER := 3;
    c_max CONSTANT NUMBER := 9;
    v_Exemplars NUMBER := 0;
    v_Aux NUMBER;
BEGIN
    FOR i IN c_min..c_max LOOP
        SELECT exemplars INTO v_Aux FROM LLIBRE WHERE ID = i;
        v_Exemplars := v_Exemplars + v_Aux;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Rang: ' || c_min || ', ' || c_max);
    DBMS_OUTPUT.PUT_LINE('Total: ' || v_Exemplars);
END;

/*2. Fes el mateix que a l'activitat anterior però havent guardat els exemplars de cada llibre dins un associative array.
Declara un associative array de NUMBER indexat per un NUMBER i introduieix els exemplars de cada llibre a l'índex que coincideixi amb la seva ID (només dels llibres demanats o de tots). Utilitza un bucle per fer-ho.
Utilitza un FOR LOOP per iterar sobre el rang d'IDs demanat (mínim i màxim), però aquesta vegada. En lloc de fer SELECT per fer el recompte, agafa la informació de l'associative array emplenat anteriorment.
Al final de les iteracions, mostra el nombre d'exemplars total.
OUTPUT d'exemple:
Rang IDs: 2, 4
Recompte total: 17
*/
DECLARE /* iterar sobre varray y sobre nasted table tambien se haria así */
    TYPE t_LlibresExemp IS TABLE OF LLIBRE%ROWTYPE INDEX BY PLS_INTEGER;
    llibres_array t_LlibresExemp;
    v_Exemplars NUMBER := 0;
    c_min CONSTANT NUMBER := 2;
    c_max CONSTANT NUMBER := 4;
    v_i PLS_INTEGER;
BEGIN
    FOR i IN c_min..c_max LOOP
        SELECT exemplars INTO llibres_array(i) FROM LLIBRE WHERE ID = i;
    END LOOP;

    WHILE v_i IS NOT NULL LOOP
    v_Exemplars := v_Exemplars + llibres_array(v_i);
    v_i := llibres_array.NEXT(v_i);
    END LOOP;

END;

/*3. Utilitzant el mateix mètode que a l'activitat anterior, crea un bloc anònim que, donat un rang d'IDs de llibres, mostri en pantalla els seus títols separats per comes.
Declara un associative array de VARCHAR2 indexat per un NUMBER i introdueix el titol de cada llibre a l'índex que coincideixi amb la seva ID.
Després, itera sobre l'associative array, només pel rang d'IDs demanat, i concatena els VARCHAR2 (títols dels llibres), separant-los per comes.
OUTPUT d'exemple:
Rang IDs: 2, 4
Títols: Yerma, La casa de Bernarda Alba, Poeta en Nueva York, 
*/
DECLARE /* iterar sobre varray y sobre nasted table tambien se haria así */
    TYPE t_LlibresExemp IS TABLE OF LLIBRE.TITOL%ROWTYPE INDEX BY PLS_INTEGER;
    llibres_array t_LlibresExemp;
    v_Exemplars NUMBER := 0;
    c_min CONSTANT NUMBER := 2;
    c_max CONSTANT NUMBER := 4;
    v_i PLS_INTEGER;
    v_titols VARCHAR2(4000);
BEGIN
    FOR i IN c_min..c_max LOOP
        SELECT TITOL INTO llibres_array(i) FROM LLIBRE WHERE ID = i;
    END LOOP;

    WHILE v_i IS NOT NULL LOOP
    v_titols := v_titols ||','|| v_Exemplars(v_i)
    v_i := llibres_array.NEXT(v_i);
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE(v_titols);

END;



--1. Crea un paquet LLIBRES_API que contengui (6 punts):
--• Un procediment “alta_llibre” per donar d’alta un llibre, donat, com a mínim, el seu
--títol, any, número d’exemplars i ID d’editorial. L’ID del llibre del que és seqüela
--també s’ha de poder indicar, però ha de ser un paràmetre opcional (amb valor per
--defecte NULL) i, si s’indica, el procediment ha de comprovar que hi ha un llibre amb
--aquell ID i aixecar una excepció si no és així. A més, si s’indica un número
--d’exemplars negatiu o una editorial que no existeix, també s’ha d’aixecar una
--excepció (diferent en cada cas).
--• Una funció “get_llibre_by_id” per obtenir la informació d’un llibre (record), donat el
--seu ID.
--• Una funció “get_llibres_by_genere” per obtenir tots els llibres (records) d’un gènere,
--donat l’ID del gènere. Els llibres han d’estar ordenats per títol.
--• Una funció “search_by_titol” per obtenir tots els llibres (records) que al títol tinguin
--el text indicat per paràmetre.
--Les funcions, procediments, tipus i excepcions necessaris han de formar part del mateix
--paquet.
CREATE OR REPLACE PACKAGE LLIBRES_API AS
    -- Excepcions
    ex_editorial_no_existeix EXCEPTION;
    ex_llibre_no_existeix EXCEPTION;
    ex_exemplars_negatius EXCEPTION;

    -- Procediments i funcions
    PROCEDURE alta_llibre(
        p_titol IN VARCHAR2,
        p_any IN NUMBER,
        p_exemplars IN NUMBER,
        p_id_editorial IN NUMBER,
        p_id_sequela_de IN NUMBER DEFAULT NULL
    );

    FUNCTION get_llibre_by_id(p_id IN NUMBER) RETURN LLIBRE%ROWTYPE;

    FUNCTION get_llibres_by_genere(p_genere IN VARCHAR2) RETURN SYS_REFCURSOR;

    FUNCTION search_by_titol(p_text IN VARCHAR2) RETURN SYS_REFCURSOR;
END LLIBRES_API;
/

CREATE OR REPLACE PACKAGE BODY LLIBRES_API AS
    PROCEDURE alta_llibre(
        p_titol IN VARCHAR2,
        p_any IN NUMBER,
        p_exemplars IN NUMBER,
        p_id_editorial IN NUMBER,
        p_id_sequela_de IN NUMBER DEFAULT NULL
    ) IS
        v_count NUMBER;
    BEGIN
        -- Comprovar si l'editorial existeix
        SELECT COUNT(*) INTO v_count FROM EDITORIAL WHERE ID = p_id_editorial;
        IF v_count = 0 THEN
            RAISE ex_editorial_no_existeix;
        END IF;

        -- Comprovar si el llibre seqüela existeix (si s'ha indicat)
        IF p_id_sequela_de IS NOT NULL THEN
            SELECT COUNT(*) INTO v_count FROM LLIBRE WHERE ID = p_id_sequela_de;
            IF v_count = 0 THEN
                RAISE ex_llibre_no_existeix;
            END IF;
        END IF;

        -- Comprovar si el número d'exemplars és negatiu
        IF p_exemplars < 0 THEN
            RAISE ex_exemplars_negatius;
        END IF;

        -- Inserir el llibre
        INSERT INTO LLIBRE (titol, an, exemplars, id_editorial, id_sequela_de)
        VALUES (p_titol, p_any, p_exemplars, p_id_editorial, p_id_sequela_de);
    END alta_llibre;

    FUNCTION get_llibre_by_id(p_id IN NUMBER) RETURN LLIBRE%ROWTYPE IS
        v_llibre LLIBRE%ROWTYPE;
    BEGIN
        SELECT * INTO v_llibre FROM LLIBRE WHERE ID = p_id;
        RETURN v_llibre;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE ex_llibre_no_existeix;
    END get_llibre_by_id;

    FUNCTION get_llibres_by_genere(p_genere IN VARCHAR2) RETURN SYS_REFCURSOR IS
        v_cursor SYS_REFCURSOR;
    BEGIN
        OPEN v_cursor FOR
        SELECT * FROM LLIBRE l
        JOIN LLIBRE_GENERE lg ON l.ID = lg.ID_LLIBRE
        WHERE lg.NOM_GENERE = p_genere
        ORDER BY l.TITOL;
        RETURN v_cursor;
    END get_llibres_by_genere;

    FUNCTION search_by_titol(p_text IN VARCHAR2) RETURN SYS_REFCURSOR IS
        v_cursor SYS_REFCURSOR;
    BEGIN
        OPEN v_cursor FOR
        SELECT * FROM LLIBRE WHERE LOWER(TITOL) LIKE '%' || LOWER(p_text) || '%';
        RETURN v_cursor;
    END search_by_titol;
END LLIBRES_API;
/



--2. Crea un trigger que guardi, a una taula LLIBRES_LOG, l’històric d’exemplars d’un llibre.
--Quan un llibre canvia de nombre d’exemplars, s’ha de guardar el nombre d’exemplars
--que tenia abans del canvi, dins aquesta nova taula, amb la data del moment en què es
--fa el canvi (és a dir, quan el llibre deixa de tenir aquell nombre d’exemplars) i l’ID del llibre.