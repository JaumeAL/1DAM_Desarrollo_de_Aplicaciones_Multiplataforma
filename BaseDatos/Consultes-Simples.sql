/* Exercici
Sobre l’esquema i dades de “U5_FabricantsProductes”:
1. Treu una llista amb el nom i el preu dels productes, ordenats de
més cars a més barats.
2. Obtén una llista amb el nom i el preu dels 3 productes més cars.
3. Selecciona el nom dels 3 productes més barats, però ignorant el
més barat de tots. És a dir, el 2n, 3r i 4t més barats.
4. Retorna el nom de tots els productes que tenguin “Impresora” en el
nom. 
 5. Treu una llista amb el número de productes per ID de fabricant.
6. Obtén una llista amb el preu promig per cada ID de fabricant.
7. Selecciona el nom i el preu de tots els productes, amb el preu sense
decimals (és a dir, arrodonit a 0 decimals).
8. Treu una llista amb el nom i el preu que tendria cada producte si
apliquéssim una pujada general del 10%.  */

CREATE TABLE fabricante (
  id NUMBER PRIMARY KEY,
  nombre VARCHAR2(100) NOT NULL
);

CREATE TABLE producto (
  id NUMBER PRIMARY KEY,
  nombre VARCHAR2(100) NOT NULL,
  precio NUMBER(10,2) NOT NULL,
  id_fabricante NUMBER NOT NULL,
  FOREIGN KEY (id_fabricante) REFERENCES fabricante(id)
);

INSERT INTO fabricante VALUES(1, 'Asus');
INSERT INTO fabricante VALUES(2, 'Lenovo');
INSERT INTO fabricante VALUES(3, 'Hewlett-Packard');
INSERT INTO fabricante VALUES(4, 'Samsung');
INSERT INTO fabricante VALUES(5, 'Seagate');
INSERT INTO fabricante VALUES(6, 'Crucial');
INSERT INTO fabricante VALUES(7, 'Gigabyte');
INSERT INTO fabricante VALUES(8, 'Huawei');
INSERT INTO fabricante VALUES(9, 'Xiaomi');

INSERT INTO producto VALUES(1, 'Disco duro SATA3 1TB', 86.99, 5);
INSERT INTO producto VALUES(2, 'Memoria RAM DDR4 8GB', 120, 6);
INSERT INTO producto VALUES(3, 'Disco SSD 1 TB', 150.99, 4);
INSERT INTO producto VALUES(4, 'GeForce GTX 1050Ti', 185, 7);
INSERT INTO producto VALUES(5, 'GeForce GTX 1080 Xtreme', 755, 6);
INSERT INTO producto VALUES(6, 'Monitor 24 LED Full HD', 202, 1);
INSERT INTO producto VALUES(7, 'Monitor 27 LED Full HD', 245.99, 1);
INSERT INTO producto VALUES(8, 'Portátil Yoga 520', 559, 2);
INSERT INTO producto VALUES(9, 'Portátil Ideapd 320', 444, 2);
INSERT INTO producto VALUES(10, 'Impresora HP Deskjet 3720', 59.99, 3);
INSERT INTO producto VALUES(11, 'Impresora HP Laserjet Pro M26nw', 180, 3);

SELECT NOMBRE, PRECIO FROM PRODUCTO ORDER BY PRECIO DESC;
SELECT NOMBRE, PRECIO FROM PRODUCTO ORDER BY PRECIO DESC FETCH FIRST 3 ROWS ONLY;
SELECT NOMBRE FROM PRODUCTO ORDER BY PRECIO ASC OFFSET 1 ROW FETCH FIRST 3 ROWS ONLY;
SELECT NOMBRE FROM PRODUCTO WHERE UPPER(NOMBRE) LIKE UPPER('%impresora%');

SELECT ID_FABRICANTE, COUNT(*) AS ID FROM PRODUCTO GROUP BY ID_FABRICANTE;
SELECT ID_FABRICANTE, AVG(PRECIO) FROM PRODUCTO GROUP BY ID_FABRICANTE;
SELECT NOMBRE, ROUND(PRECIO,0) FROM PRODUCTO;
SELECT NOMBRE, PRECIO*1.1 FROM PRODUCTO;

