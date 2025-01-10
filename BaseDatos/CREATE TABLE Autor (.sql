CREATE TABLE Autor (
    ID_Autor NUMBER(20),
    Nom VARCHAR2(50),
    Cognoms VARCHAR2(50),
    Data_Naix DATE,
    Nacionalitat VARCHAR2(40),
    PRIMARY KEY (ID_Autor)
);
CREATE TABLE Llibre (
    ID_llibre NUMBER(20),
    Titol VARCHAR2(50),
    Ani NUMBER(4),
    Exemplars NUMBER(50),
    PRIMARY KEY (ID_llibre),
    FOREIGN KEY (ID_Editorial) REFERENCES Editorial(ID_Editorial),
    FOREIGN KEY (ID_Sequela) REFERENCES Llibre(ID_Sequela)
);
CREATE TABLE Editorial (
    ID_Editorial NUMBER(20),
    Titol VARCHAR2(50),
    Ani NUMBER(4),
    Data_Naix DATE,
    Exemplars NUMBER(50),
    PRIMARY KEY (ID_Editorial)
);
CREATE TABLE Autor_Llibre (
    PRIMARY KEY (ID_Autor),
    PRIMARY KEY (ID_llibre),
    FOREIGN KEY (ID_Autor) REFERENCES Autor(ID_Autor),
    FOREIGN KEY (ID_llibre) REFERENCES Llibre(ID_llibre)
);