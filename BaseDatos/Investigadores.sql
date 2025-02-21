CREATE TABLE INVESTIGADOR(
    DNI varchar2(9) primary key,
    nom varchar2(50),
    llinatge1 varchar2(50),
    llinatge2 varchar2(50),
    email varchar2(255),
    telefon varchar2(9),
	salari number(38,2),
    especialitat varchar2(20) check (especialitat in ('Biologia', 'Física', 'Informàtica', 'Infermeria', 'Medicina'))
);

CREATE TABLE PROJECTE(
    codi number generated as identity primary key,
    referencia varchar2(20) unique,
    descripcio varchar2(4000),
    tipus varchar2(1) check (tipus in ('D', 'I')),
    dni_responsable varchar2(9) not null,
    foreign key (dni_responsable) references investigador(DNI)
);

CREATE TABLE PARTICIPACIO(
    dni_investigador varchar2(9),
    codi_projecte number,
    percentatge number(3,2),
    foreign key (dni_investigador) references investigador(dni),
    foreign key (codi_projecte) references projecte(codi),
    primary key (dni_investigador, codi_projecte)
);

CREATE TABLE PROVEIDOR(
    nif varchar2(9) primary key,
    nom varchar2(255),
    observacions varchar2(255),
    cancelat varchar2(1) check (cancelat in ('S', 'N')),
    email varchar2(255),
    telefon varchar2(9),
    iban varchar2(24) unique
);

CREATE TABLE FACTURA(
    id number generated as identity primary key,
    nif_proveidor varchar2(9) not null,
    descripcio varchar2(255),
    data date,
    data_recepcio timestamp,
    codi_projecte number,
    foreign key (codi_projecte) references projecte(codi),
	foreign key (nif_proveidor) references proveidor(nif)
);

CREATE TABLE LINIA_FACTURA(
    id_factura number,
    num_linia number,
    descripcio varchar2(255),
    import_base number,
    import_iva number,
    primary key (id_factura, num_linia),
    foreign key (id_factura) references factura(id)
);

-- Insertar dades a la taula INVESTIGADOR
INSERT INTO INVESTIGADOR VALUES ('12345678A', 'Albert', 'Soler', 'Martí', 'albert.soler@gmail.com', '971234567', 2500.00, 'Informàtica');
INSERT INTO INVESTIGADOR VALUES ('23456789B', 'Berta', 'López', 'García', 'berta.lopez@hotmail.com', '971345678', 2300.00, 'Biologia');
INSERT INTO INVESTIGADOR VALUES ('34567890C', 'Carles', 'Sánchez', 'Pérez', 'carles.sanchez@yahoo.com', '971456789', 2400.00, 'Física');
INSERT INTO INVESTIGADOR VALUES ('45678901D', 'Diana', 'Gómez', 'Fernández', 'diana.gomez@gmail.com', '971567890', 2200.00, 'Medicina');
INSERT INTO INVESTIGADOR VALUES ('56789012E', 'Elena', 'Rodríguez', 'González', 'elena.rodriguez@hotmail.com', '971678901', 2100.00, 'Infermeria');
INSERT INTO INVESTIGADOR VALUES ('67890123F', 'Ferran', 'Martínez', 'López', 'ferran.martinez@yahoo.com', '971789012', 2600.00, 'Informàtica');
INSERT INTO INVESTIGADOR VALUES ('78901234G', 'Gemma', 'Pérez', 'Sánchez', 'gemma.perez@gmail.com', '971890123', 2500.00, 'Biologia');
INSERT INTO INVESTIGADOR VALUES ('89012345H', 'Hugo', 'García', 'Gómez', 'hugo.garcia@hotmail.com', '971901234', 2300.00, 'Física');
INSERT INTO INVESTIGADOR VALUES ('90123456I', 'Irene', 'Fernández', 'Rodríguez', 'irene.fernandez@yahoo.com', '971012345', 2400.00, 'Medicina');
INSERT INTO INVESTIGADOR VALUES ('01234567J', 'Jordi', 'González', 'Martínez', 'jordi.gonzalez@gmail.com', '971123456', 2200.00, 'Infermeria');

-- Insertar dades a la taula PROJECTE
INSERT INTO PROJECTE (referencia, descripcio, tipus, dni_responsable) VALUES ('P001', 'Desenvolupament d''una aplicació web per a la gestió de projectes de recerca', 'D', '12345678A');
INSERT INTO PROJECTE (referencia, descripcio, tipus, dni_responsable) VALUES ('P002', 'Estudi de la biodiversitat marina a les Illes Balears', 'I', '23456789B');
INSERT INTO PROJECTE (referencia, descripcio, tipus, dni_responsable) VALUES ('P003', 'Anàlisi de les propietats òptiques dels materials nanoestructurats', 'I', '34567890C');
INSERT INTO PROJECTE (referencia, descripcio, tipus, dni_responsable) VALUES ('P004', 'Avaluació de l''efectivitat d''un nou tractament contra el càncer', 'I', '45678901D');
INSERT INTO PROJECTE (referencia, descripcio, tipus, dni_responsable) VALUES ('P005', 'Millora de la qualitat assistencial i la seguretat del pacient en els centres sanitaris', 'D', '56789012E');
INSERT INTO PROJECTE (referencia, descripcio, tipus, dni_responsable) VALUES ('P006', 'Creació d''un videojoc educatiu per a la difusió de la cultura i la història de Mallorca', 'D', '67890123F');
INSERT INTO PROJECTE (referencia, descripcio, tipus, dni_responsable) VALUES ('P007', 'Investigació de les causes i els efectes del canvi climàtic a la Mediterrània', 'I', '78901234G');
INSERT INTO PROJECTE (referencia, descripcio, tipus, dni_responsable) VALUES ('P008', 'Disseny i construcció d''un robot explorador per a missions espacials', 'D', '89012345H');
INSERT INTO PROJECTE (referencia, descripcio, tipus, dni_responsable) VALUES ('P009', 'Desenvolupament d''una vacuna contra la COVID-19', 'I', '56789012E');
INSERT INTO PROJECTE (referencia, descripcio, tipus, dni_responsable) VALUES ('P010', 'Avaluació de l''impacte de la pandèmia en la salut mental de la població', 'I', '56789012E');

-- Insertar dades a la taula PARTICIPACIO
INSERT INTO PARTICIPACIO VALUES ('12345678A', 1, 0.50);
INSERT INTO PARTICIPACIO VALUES ('67890123F', 1, 0.50);
INSERT INTO PARTICIPACIO VALUES ('23456789B', 2, 0.40);
INSERT INTO PARTICIPACIO VALUES ('78901234G', 2, 0.40);
INSERT INTO PARTICIPACIO VALUES ('90123456I', 2, 0.20);
INSERT INTO PARTICIPACIO VALUES ('34567890C', 3, 0.33);
INSERT INTO PARTICIPACIO VALUES ('89012345H', 3, 0.33);
INSERT INTO PARTICIPACIO VALUES ('01234567J', 3, 0.34);
INSERT INTO PARTICIPACIO VALUES ('45678901D', 4, 0.25);
INSERT INTO PARTICIPACIO VALUES ('12345678A', 5, 0.50);
INSERT INTO PARTICIPACIO VALUES ('67890123F', 5, 0.50);
INSERT INTO PARTICIPACIO VALUES ('23456789B', 6, 0.60);
INSERT INTO PARTICIPACIO VALUES ('78901234G', 6, 0.60);
INSERT INTO PARTICIPACIO VALUES ('90123456I', 6, 0.80);
INSERT INTO PARTICIPACIO VALUES ('34567890C', 7, 0.67);
INSERT INTO PARTICIPACIO VALUES ('89012345H', 7, 0.67);
INSERT INTO PARTICIPACIO VALUES ('01234567J', 7, 0.66);
INSERT INTO PARTICIPACIO VALUES ('45678901D', 8, 0.75);

-- Insertar dades a la taula PROVEIDOR
INSERT INTO PROVEIDOR VALUES ('A12345678', 'Amazon', 'Líder mundial en comerç electrònic', 'N', 'amazon@amazon.com', '900123456', 'ES1234567890123456789012');
INSERT INTO PROVEIDOR VALUES ('B23456789', 'Bauhaus', 'Especialista en productes per a la casa, el taller i el jardí', 'N', 'bauhaus@bauhaus.com', '900234567', 'ES2345678901234567890123');
INSERT INTO PROVEIDOR VALUES ('C34567890', 'Carrefour', 'Hipermercat amb gran varietat de productes', 'N', 'carrefour@carrefour.com', '900345678', 'ES3456789012345678901234');
INSERT INTO PROVEIDOR VALUES ('D45678901', 'Decathlon', 'Empresa dedicada a la venda i distribució d''articles esportius', 'N', 'decathlon@decathlon.com', '900456789', 'ES4567890123456789012345');
INSERT INTO PROVEIDOR VALUES ('E56789012', 'El Corte Inglés', 'Grup de distribució de diversos formats comercials', 'N', 'elcorteingles@elcorteingles.com', '900567890', 'ES5678901234567890123456');
INSERT INTO PROVEIDOR VALUES ('F67890123', 'Fnac', 'Distribuïdor de productes culturals i tecnològics', 'N', 'fnac@fnac.com', '900678901', 'ES6789012345678901234567');
INSERT INTO PROVEIDOR VALUES ('G78901234', 'Google', 'Gigant tecnològic que ofereix serveis d''internet', 'N', 'google@google.com', '900789012', 'ES7890123456789012345678');
INSERT INTO PROVEIDOR VALUES ('H89012345', 'HP', 'Empresa líder en el sector de la informàtica i la impress', 'N', 'hp@hp.com', '987654321','ES9890123456789012345678');
INSERT INTO PROVEIDOR VALUES ('I90123456', 'AstraZeneca', 'Implantació de xips 6G', 'N', 'astra@zeneca.com', '203020201', 'ES9890123456789012345638');
INSERT INTO PROVEIDOR VALUES ('J01234567', 'PsychoServices', 'Control mental', 'N', 'psycho@services.com', '543020201', 'ES0893123456789012345638');

INSERT INTO FACTURA (nif_proveidor, descripcio, data, data_recepcio, codi_projecte) VALUES ('A12345678', 'Material informàtic per al projecte P001', DATE'2020-01-01', DATE'2020-01-02', 1);
INSERT INTO FACTURA (nif_proveidor, descripcio, data, data_recepcio, codi_projecte) VALUES ('B23456789', 'Eines i maquinària per al projecte P002', DATE'2020-01-05', DATE'2020-01-06', 2);
INSERT INTO FACTURA (nif_proveidor, descripcio, data, data_recepcio, codi_projecte) VALUES ('C34567890', 'Aliments i begudes per al projecte P003', DATE'2020-01-10', DATE'2020-01-11', 3);
INSERT INTO FACTURA (nif_proveidor, descripcio, data, data_recepcio, codi_projecte) VALUES ('D45678901', 'Equipament esportiu per al projecte P004', DATE'2020-01-15', DATE'2020-01-16', 4);
INSERT INTO FACTURA (nif_proveidor, descripcio, data, data_recepcio, codi_projecte) VALUES ('E56789012', 'Material de papereria per al projecte P005', DATE'2020-01-20', DATE'2020-01-21', 5);
INSERT INTO FACTURA (nif_proveidor, descripcio, data, data_recepcio, codi_projecte) VALUES ('F67890123', 'Llicències de programari per al projecte P006', DATE'2020-01-25', DATE'2020-01-26', 6);
INSERT INTO FACTURA (nif_proveidor, descripcio, data, data_recepcio, codi_projecte) VALUES ('G78901234', 'Serveis de núvol per al projecte P007', DATE'2020-01-30', DATE'2020-01-31', 7);
INSERT INTO FACTURA (nif_proveidor, descripcio, data, data_recepcio, codi_projecte) VALUES ('G78901234', 'Serveis de núvol per al projecte P008', DATE'2020-01-30', DATE'2020-01-31', 8);
INSERT INTO FACTURA (nif_proveidor, descripcio, data, data_recepcio, codi_projecte) VALUES ('H89012345', 'Components electrònics per al projecte P008', DATE'2020-02-04', DATE'2020-02-05', 8);
INSERT INTO FACTURA (nif_proveidor, descripcio, data, data_recepcio, codi_projecte) VALUES ('I90123456', 'Material sanitari per al projecte P009', DATE'2020-02-09', DATE'2020-02-10', 9);

-- Insertar dades a la taula LINIA_FACTURA
INSERT INTO LINIA_FACTURA VALUES (1, 1, 'Ordinador portàtil', 500, 105);
INSERT INTO LINIA_FACTURA VALUES (1, 2, 'Ratolí sense fils', 20, 4.2);
INSERT INTO LINIA_FACTURA VALUES (2, 1, 'Taladradora', 100, 21);
INSERT INTO LINIA_FACTURA VALUES (2, 2, 'Martell', 10, 2.1);
INSERT INTO LINIA_FACTURA VALUES (3, 1, 'Pa de motlle', 2, 0.42);
INSERT INTO LINIA_FACTURA VALUES (3, 2, 'Aigua mineral', 1, 0.21);
INSERT INTO LINIA_FACTURA VALUES (4, 1, 'Bicicleta', 200, 42);
INSERT INTO LINIA_FACTURA VALUES (4, 2, 'Casc', 50, 10.5);
INSERT INTO LINIA_FACTURA VALUES (5, 1, 'Bolígraf', 1, 0.21);
INSERT INTO LINIA_FACTURA VALUES (5, 2, 'Llibreta', 2, 0.42);
INSERT INTO LINIA_FACTURA VALUES (6, 1, 'Windows 10', 100, 21);
INSERT INTO LINIA_FACTURA VALUES (6, 2, 'Office 365', 50, 10.5);
INSERT INTO LINIA_FACTURA VALUES (7, 1, 'Google Drive', 20, 4.2);
INSERT INTO LINIA_FACTURA VALUES (7, 2, 'Gmail', 10, 2.1);
INSERT INTO LINIA_FACTURA VALUES (8, 1, 'Arduino', 30, 6.3);
INSERT INTO LINIA_FACTURA VALUES (8, 2, 'Raspberry Pi', 40, 8.4);
INSERT INTO LINIA_FACTURA VALUES (9, 1, 'Mascaretes', 5, 1.05);
INSERT INTO LINIA_FACTURA VALUES (9, 2, 'Guants', 3, 0.63);
INSERT INTO LINIA_FACTURA VALUES (10, 1, 'Sessió individual', 50, 10.5);
INSERT INTO LINIA_FACTURA VALUES (10, 2, 'Sessió grupal', 30, 6.3);

--CONSULTES:
--1.Obtén les dades de l'investigador que cobra més. (U6)
SELECT *
FROM INVESTIGADOR
ORDER BY salari DESC
FETCH FIRST 1 ROWS ONLY;
--2.Obtén el nom complet i el salari dels investigadors amb nom acabat per "a" i primer llinatge acabat per "z". Ordena els resultats per salari descendent. (U5)
Select nom, llinatge1, llinatge2, salari
from investigador
where nom like '%a' and llinatge1 like '%z'
order by salari desc;
--3.Calcula el salari promig dels investigadors segons la seva especialitat. Ha de sortir el nom de l'especialitat i el promig, i s'han d'ordenar per salari promig ASCENDENT. (U6, activitats)
Select especialitat, avg(salari)
from investigador
group by especialitat
order by avg(salari) asc;
--4.Obtén el DNI, nom i llinatges d'aquells investigadors que NO són responsables de cap projecte. (U7)
Select dni , nom, llinatge1, llinatge2
from investigador i
left join projecte p on p.dni_responsable = i.dni
where codi is null;
--5.Obtén els ingressos obtinguts (imports base) per cada proveidor, de les seves factures, però només si ha ingressat 100 euros o més. Una columna ha de mostrar el nom del proveïdor i l'altre el total d'ingressos. 
Select nom, sum(import_base)
from proveidor p    
join factura f on p.nif = f.nif_proveidor
join LINIA_FACTURA lf on f.id = lf.id_factura
group by nom
having sum(import_base) >= 100;
--6.Obtén el total d'IVA pagat per cada projecte. Una columna ha de mostrar la referència del projecte i l'altres l'IVA pagat. Si algun projecte no té factures, ha d'aparèixer un 0. (U7.1)
Select referencia, sum(import_iva)
from projecte p
left join factura f on p.codi = f.codi_projecte
left join LINIA_FACTURA lf on f.id = lf.id_factura
group by referencia;
--7. Obtén una llista d'investigadors (dni i nom complet) amb els projectes en que participen (referència i descripció) i el percentatge de participació entre projecte i investigador.
--Només hi han de sortir els investigadors que participen en algun projecte. El percentatge de participació ha d'estar entre 0 i 100. Ordena per nom complet de manera alfabètica.
select i.dni, i.nom || ' ' || i.llinatge1 || ' ' || i.llinatge2 as nom_complet, p.referencia, p.descripcio, percentatge
from investigador i
join participacio pa on i.dni = pa.dni_investigador
join projecte p on pa.codi_projecte = p.codi
where percentatge between 0 and 100
order by nom_complet;
--8. Obtén el nom i llinatges dels investigadors que participen en qualsevol projecte distingint per les següents àrees d'especialització: Ciències (Física i Biologia), Salut (Medicina i Infermeria) i Tecnologia (Informàtica). (U7.1)
select nom, llinatge1, llinatge2
from investigador
where especialitat in ('Física', 'Biologia');

--9. Obtén un llistat amb el cost de cada projecte (suma dels imports base i iva de les factures) que tengui factures i de cada investigador (cost anual en base al salari mensual) que participi a algun projecte.
--Columnes: tipus (Investigador o Projecte), identificador (DNI investigador o referència projecte) i cost (sou mensual extrapolat a tot l'any o import factures).
--Ordenació: cost descendent (U7, activitat 24/1 punt 7)
select 'Investigador' as tipus, dni as identificador, salari * 12 as cost
from investigador i
join participacio pa on i.dni = pa.dni_investigador
union
select 'Projecte' as tipus, referencia as identificador, sum(import_base + import_iva) as cost
from projecte p
join factura f on p.codi = f.codi_projecte
join LINIA_FACTURA lf on f.id = lf.id_factura
group by referencia
order by cost desc;
--10.Obtén el nom complet dels investigadors que participen en més d'un projecte. (U7)
select nom || ' ' || llinatge1 || ' ' || llinatge2 as nom_complet
from investigador i
join participacio pa on i.dni = pa.dni_investigador
group by nom, llinatge1, llinatge2
having count(codi_projecte) > 1;
--11.Obtén el nom complet dels investigadors que participen en projectes de tipus "D" i "I". (U7)
select nom || ' ' || llinatge1 || ' ' || llinatge2 as nom_complet
from investigador i
join participacio pa on i.dni = pa.dni_investigador
join projecte p on pa.codi_projecte = p.codi
where tipus in ('D', 'I');
--12.Obtén el nom complet dels investigadors que participen en projectes de tipus "D" i "I" i que no són responsables de cap projecte. (U7)
select nom || ' ' || llinatge1 || ' ' || llinatge2 as nom_complet
from investigador i
join participacio pa on i.dni = pa.dni_investigador
join projecte p on pa.codi_projecte = p.codi
where tipus in ('D', 'I')
and dni_responsable is null;
