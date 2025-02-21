
CREATE TABLE customers (
id_customer NUMBER PRIMARY KEY,
name VARCHAR2(50) NOT NULL,
surname VARCHAR2(50) NOT NULL,
email VARCHAR2(100) UNIQUE NOT NULL,
address VARCHAR2(200) NOT NULL,
city VARCHAR2(50) NOT NULL,
postal_code VARCHAR2(10) NOT NULL,
phone VARCHAR2(20) NOT NULL
);

CREATE TABLE artists (
id_artist NUMBER PRIMARY KEY,
name VARCHAR2(100) NOT NULL,
country VARCHAR2(50) NOT NULL,
biography VARCHAR2(500) NOT NULL
);

CREATE TABLE genres (
id_genre NUMBER PRIMARY KEY,
name VARCHAR2(50) NOT NULL,
description VARCHAR2(500) NOT NULL
);

CREATE TABLE albums (
id_album NUMBER PRIMARY KEY,
title VARCHAR2(100) NOT NULL,
year NUMBER NOT NULL CHECK (year BETWEEN 1900 AND 2024),
price NUMBER NOT NULL CHECK (price >= 0),
stock NUMBER NOT NULL CHECK (stock >= 0),
artist NUMBER NOT NULL REFERENCES artists(id_artist),
genre NUMBER NOT NULL REFERENCES genres(id_genre)
);

CREATE TABLE sales (
id_sale NUMBER PRIMARY KEY,
customer NUMBER NOT NULL REFERENCES customers(id_customer),
album NUMBER NOT NULL REFERENCES albums(id_album),
sale_date DATE NOT NULL,
quantity NUMBER NOT NULL CHECK (quantity > 0),
total NUMBER NOT NULL
);

INSERT INTO customers VALUES (1, 'Anna', 'Garcia', 'anna@gmail.com', 'Carrer Major 10', 'Palma', '07001', '123456789');
INSERT INTO customers VALUES (2, 'Joan', 'Martinez', 'joan@hotmail.com', 'Avinguda Diagonal 20', 'Manacor', '07500', '987654321');
INSERT INTO customers VALUES (3, 'Maria', 'Lopez', 'maria@yahoo.com', 'Plaça Catalunya 30', 'Inca', '07300', '456789123');
INSERT INTO customers VALUES (4, 'David', 'Sanchez', 'david@gmail.com', 'Carrer Aragó 40', 'Alcúdia', '07400', '321654987');
INSERT INTO customers VALUES (5, 'Laura', 'Perez', 'laura@hotmail.com', 'Carrer Balmes 50', 'Sóller', '07100', '789456123');
INSERT INTO customers VALUES (6, 'Marc', 'Gomez', 'marc@yahoo.com', 'Carrer Gran Via 60', 'Llucmajor', '07620', '654321789');
INSERT INTO customers VALUES (7, 'Sara', 'Fernandez', 'sara@gmail.com', 'Carrer Muntaner 70', 'Calvià', '07184', '147258369');
INSERT INTO customers VALUES (8, 'Alex', 'Rodriguez', 'alex@hotmail.com', 'Carrer Mallorca 80', 'Pollença', '07460', '258369147');
INSERT INTO customers VALUES (9, 'Eva', 'Gonzalez', 'eva@yahoo.com', 'Carrer Valencia 90', 'Andratx', '07150', '369147258');

INSERT INTO artists VALUES (1, 'The Beatles', 'United Kingdom', 'The Beatles were an English rock band formed in Liverpool in 1960. They are regarded as the most influential band of all time.');
INSERT INTO artists VALUES (2, 'Bob Dylan', 'United States', 'Bob Dylan is an American singer-songwriter, author and visual artist. He is widely regarded as one of the greatest songwriters of all time.');
INSERT INTO artists VALUES (3, 'David Bowie', 'United Kingdom', 'David Bowie was an English singer-songwriter and actor. He was a leading figure in the music industry and is considered one of the most influential musicians of the 20th century.');
INSERT INTO artists VALUES (4, 'Pink Floyd', 'United Kingdom', 'Pink Floyd were an English rock band formed in London in 1965. They achieved international acclaim with their progressive and psychedelic music.');
INSERT INTO artists VALUES (5, 'The Rolling Stones', 'United Kingdom', 'The Rolling Stones are an English rock band formed in London in 1962. They are one of the most successful and enduring bands in rock history.');
INSERT INTO artists VALUES (6, 'Led Zeppelin', 'United Kingdom', 'Led Zeppelin were an English rock band formed in London in 1968. They are widely considered one of the most influential and innovative bands of the hard rock genre.');
INSERT INTO artists VALUES (7, 'Queen', 'United Kingdom', 'Queen are a British rock band formed in London in 1970. They are known for their diverse musical style and elaborate live performances.');
INSERT INTO artists VALUES (8, 'Michael Jackson', 'United States', 'Michael Jackson was an American singer, songwriter and dancer. He is regarded as one of the most significant cultural figures of the 20th century and one of the greatest entertainers of all time.');
INSERT INTO artists VALUES (9, 'Madonna', 'United States', 'Madonna is an American singer, songwriter and actress. She is known for her constant reinvention and versatility in music, fashion and film.');
INSERT INTO artists VALUES (10, 'Rise Against', 'United States', 'Punk rock from Chicago.');
INSERT INTO artists VALUES (11, 'CRIM', 'Spain', 'Punk rock des de Tarragona.');

INSERT INTO genres VALUES (1, 'Rock', 'Rock is a broad genre of popular music that originated as "rock and roll" in the United States in the late 1940s and early 1950s.');
INSERT INTO genres VALUES (2, 'Pop', 'Pop is a genre of popular music that originated in its modern form during the mid-1950s in the United States and the United Kingdom.');
INSERT INTO genres VALUES (3, 'Folk', 'Folk music is a genre of music that is transmitted orally, often reflecting the culture and history of a community or a nation.');
INSERT INTO genres VALUES (4, 'Jazz', 'Jazz is a genre of music that originated in the African-American communities of New Orleans, Louisiana, in the late 19th and early 20th centuries.');
INSERT INTO genres VALUES (5, 'Blues', 'Blues is a genre of music that originated in the Deep South of the United States in the late 19th and early 20th centuries.');
INSERT INTO genres VALUES (6, 'Soul', 'Soul is a genre of music that combines elements of rhythm and blues, gospel, jazz and other African-American musical traditions.');
INSERT INTO genres VALUES (7, 'Reggae', 'Reggae is a genre of music that originated in Jamaica in the late 1960s. It is characterized by a rhythmic style based on offbeat accents and influenced by ska, rocksteady and other Caribbean genres.');
INSERT INTO genres VALUES (8, 'Hip hop', 'Hip hop is a genre of music that originated in the Bronx, New York City, in the late 1970s. It is characterized by rhythmic spoken or chanted vocals, often accompanied by DJing, sampling, beatboxing and graffiti.');
INSERT INTO genres VALUES (9, 'Electronic', 'Electronic music is a genre of music that employs electronic musical instruments, digital instruments and circuitry-based music technology.');
INSERT INTO genres VALUES (10, 'Punk rock', 'Visca es punk cristo.');

INSERT INTO albums VALUES (1, 'Abbey Road', 1969, 20, 50, 1, 1);
INSERT INTO albums VALUES (2, 'Highway 61 Revisited', 1965, 15, 40, 2, 3);
INSERT INTO albums VALUES (3, 'The Rise and Fall of Ziggy Stardust and the Spiders from Mars', 1972, 18, 30, 3, 1);
INSERT INTO albums VALUES (4, 'Thriller', 1982, 25, 80, 8, 2);
INSERT INTO albums VALUES (5, 'Like a Virgin', 1984, 18, 60, 9, 2);
INSERT INTO albums VALUES (6, 'Rumours', 1977, 20, 40, 4, 1);
INSERT INTO albums VALUES (7, 'The Wall', 1979, 22, 50, 4, 1);
INSERT INTO albums VALUES (8, 'Born to Run', 1975, 15, 30, 6, 1);
INSERT INTO albums VALUES (9, 'Legend', 1984, 18, 70, 1, 7);
INSERT INTO albums VALUES (10, 'The Chronic', 1992, 20, 20, 3, 8);
INSERT INTO albums VALUES (11, 'Homework', 1997, 22, 10, 5, 9);
INSERT INTO albums VALUES (12, 'Nevermind', 1991, 25, 90, 2, 1);
INSERT INTO albums VALUES (13, 'Appeal to Reason', 2008, 15, 9, 10, 10);
INSERT INTO albums VALUES (14, 'Pare nostre que esteu a l''infern', 2008, 13, 4, 11, 10);


INSERT INTO sales VALUES (1, 1, 1, DATE'2020-02-15', 2, 40);
INSERT INTO sales VALUES (2, 2, 1, DATE'2020-04-20', 1, 15);
INSERT INTO sales VALUES (4, 4, 1, DATE'2020-06-25', 8, 44);
INSERT INTO sales VALUES (4, 4, 4, DATE'2021-02-15', 2, 44);
INSERT INTO sales VALUES (5, 5, 1, DATE'2021-04-20', 1, 25);
INSERT INTO sales VALUES (6, 6, 6, DATE'2021-06-25', 4, 100);
INSERT INTO sales VALUES (7, 7, 7, DATE'2022-02-15', 2, 44);
INSERT INTO sales VALUES (8, 8, 8, DATE'2022-08-20', 3, 66);
INSERT INTO sales VALUES (9, 9, 8, DATE'2023-02-15', 1, 22);
INSERT INTO sales VALUES (10, 7, 10, DATE'2023-08-25', 2, 44);
INSERT INTO sales VALUES (11, 8, 11, DATE'2024-02-15', 3, 66);
INSERT INTO sales VALUES (12, 9, 11, DATE'2024-08-25', 1, 22);

--1: Mostra els noms i llinatges dels clients que hagin comprat algun album dels Beatles
select name, surname
from customer
where id_customer
join sales on customer.id_customer = sales.customer
join albums on sales.album = albums.id_album
join artists on albums.artist = artists.id_artist
where artists.name = 'The Beatles';

--2: Mostra el nom i el preu dels àlbums amb un estoc inferior a 10
select title, price
from albums
where stock < 10;
--3: Mostra el nom i la descripció dels gèneres que contenen la praula "rock".
select name, description
from genres
where description like '%rock%';
--4: Mostra el total de doblers gastat per cada client.
select name, surname, sum(total)
from customers
join sales on customers.id_customer = sales.customer
group by name, surname;
--5: Mostra el títol i l'any dels àlbums del gènere Pop.
select title, year
from albums a
join genres g on a.genre = g.id_genre
where g.name = 'Pop';
--6: Mostra el nom i la biografia dels artistes que han venut més de 10 àlbums.
select name, biography
from artists a
join albums al on a.id_artist = al.artist
join sales s on al.id_album = s.album
group by name , biography
having sum(quantity) > 10;
--7: Mostra el preu promig dels àlbums per cada gènere, ordenats de menor a major.
select g.name, avg(price)
from genres g
join albums a on g.id_genere = a.genre
group by g.name
order by avg(price);
--8: Mostra el nom i el cognom dels clients que no han fet cap compra.
select name ,surname
from customers c
left join sales s on c.id_customer = s.coustomer
where s.id_sale is null;
--9: Mostra el títol i el gènere dels àlbums que no s'han venut mai.
select title, name
from albums a
left join sales s on a.id_album = s.album
join genres g on a.genre = g.id_genre
where s.id_sale is null;
--10: Mostra el nom i el país dels artistes que no tenen cap àlbum al catàleg de la botiga.
select name, country
from artists a
left join albums al on a.id_artist = al.artist
where al.id_album is null;
--11: Mostra el nom i la descripció dels gèneres que no tenen cap àlbum al catàleg de la botiga.
select name, description
from genres g
left join albums a on g.id_genere = a.genre
where a.id_album is null;
--12: Mostra el total d'ingressos obtinguts per les vendes de cada gènere d'àlbum. S'ha de veure el nom del gènere i els seus ingressos. Si un gènere no ha venut res, ha de sortir 0.
select name, sum(total)
from genres g
left join albums a on g.id_genre = a.genre
left join sales s on a.id_album = s.album
group by name;
--13: Mostra el títol i l'artista (nom) de cada àlbum sense vendes, distingint si l'àlbum és del segle XX o del segle XXI.
select title, name, case when year < 2000 then 'XX' else 'XXI' end as segle
from albums a
left join sales s on a.id_album = s.album
join artists ar on a.artist = ar.id_artist
where s.id_sale is null;