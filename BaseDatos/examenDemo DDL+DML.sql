CREATE TABLE CLIENT (
  	DNI VARCHAR2(9) PRIMARY KEY,
  	NOM VARCHAR2(50) NOT NULL,
  	ADRESA VARCHAR2(100) NOT NULL,
  	CP VARCHAR2(5) NOT NULL
);

CREATE TABLE CAMIO (
  	MATRICULA VARCHAR2(7) PRIMARY KEY,
  	MODELO VARCHAR2(50) NOT NULL,
  	POTENCIA NUMBER(4,2) NOT NULL
);

CREATE TABLE CAMIONER (
  DNI VARCHAR2(9) PRIMARY KEY,
  NOM VARCHAR2(50) NOT NULL,
  TELEFONO VARCHAR2(9) NOT NULL,
  SALARI NUMBER(10,2) NOT NULL
);

CREATE TABLE CAMIONER-CAMIO (
    DNI_CAMIONER VARCHAR2(9) NOT NULL,
  	MATRICULA_CAMIO VARCHAR2(7) NOT NULL,
  	DATAINICICON DATE,
  	DATAFICON DATE,
  	FOREIGN KEY (DNI_CAMIONER) REFERENCES CAMIONER(DNI),
  	FOREIGN KEY (MATRICULA_CAMIO) REFERENCES CAMIO(MATRICULA),
  	PRIMARY KEY (DNI_CAMIONER, MATRICULA_CAMIO)
);

CREATE TABLE PAQUET (
  CODI NUMBER PRIMARY KEY,
  DNI_CAMIONER VARCHAR2(9) NOT NULL,
  DNI_CLIENT VARCHAR2(9) NOT NULL,
  DESCRIPCIO VARCHAR2(300) NOT NULL,
  Estat VARCHAR2(1) NOT NULL,
  FOREIGN KEY (DNI_CAMIONER) REFERENCES CAMIONER(DNI),
  FOREIGN KEY (DNI_CLIENT) REFERENCES CLIENT(DNI)
);
/* 2 camioners */
INSERT INTO CAMIONER VALUES ('12345678A', 'Pepito', '666666666', 1000);
INSERT INTO CAMIONER VALUES ('87654321B', 'Juanito', '77666677', 2000);

/* 1 camió */
INSERT INTO CAMIO VALUES ('1234ABC', 'Mercedes', 10);

/* Un dels camioners ha d'haver conduit el camió durant tot el mes de desembre de 2024 */
INSERT INTO CAMIONER_CAMIO VALUES ('12345678A', '1234ABC', TO_DATE('01/12/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'));