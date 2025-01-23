DROP TABLE Caracteristique_Maison;
DROP TABLE Caracteristique;
DROP TABLE Paiement;
DROP TABLE Point_Arrondissement;
DROP TABLE Arrondissement;
DROP TABLE Prix;
DROP TABLE Categorie_Car;
DROP TABLE Maison;

CREATE TABLE Maison(
   id_maison VARCHAR2(10) ,
   adresse VARCHAR2(50) ,
   longitude NUMBER(15,2)  ,
   latitude NUMBER(15,2)  ,
   longueur NUMBER(15,2)  ,
   largeur NUMBER(15,2)  ,
   nb_etage NUMBER(10),
   PRIMARY KEY(id_maison)
);

CREATE TABLE Categorie_Car(
   id_categorie VARCHAR2(10) ,
   nom_categorie VARCHAR2(50) ,
   PRIMARY KEY(id_categorie)
);

CREATE TABLE Prix(
   id_prix VARCHAR2(10) ,
   valeur_m2 NUMBER(15,2)  ,
   date_prix DATE,
   PRIMARY KEY(id_prix)
);

CREATE TABLE Arrondissement(
   id_arrondissement VARCHAR2(10) ,
   nom_arrondissement VARCHAR2(50) ,
   PRIMARY KEY(id_arrondissement)
);

CREATE TABLE Paiement(
   id_paiement VARCHAR2(10) ,
   valeur_paiement BINARY_DOUBLE NOT NULL,
   date_paiement DATE,
   mois NUMBER(10),
   annee NUMBER(10),
   id_maison VARCHAR2(10)  NOT NULL,
   PRIMARY KEY(id_paiement),
   FOREIGN KEY(id_maison) REFERENCES Maison(id_maison)
);

CREATE TABLE Point_Arrondissement(
   id_point_arrondissement VARCHAR2(10) ,
   longitude NUMBER(15,2)  ,
   latitude NUMBER(15,2)  ,
   id_arrondissement VARCHAR2(10)  NOT NULL,
   PRIMARY KEY(id_point_arrondissement),
   FOREIGN KEY(id_arrondissement) REFERENCES Arrondissement(id_arrondissement)
);

CREATE TABLE Caracteristique(
   id_caracteristique VARCHAR2(10) ,
   description_caracteristique VARCHAR2(50) ,
   coefficient NUMBER(15,2)  ,
   id_categorie VARCHAR2(10)  NOT NULL,
   PRIMARY KEY(id_caracteristique),
   FOREIGN KEY(id_categorie) REFERENCES Categorie_Car(id_categorie)
);

CREATE TABLE Caracteristique_Maison(
   id_maison VARCHAR2(10) ,
   id_caracteristique VARCHAR2(10) ,
   PRIMARY KEY(id_maison, id_caracteristique),
   FOREIGN KEY(id_maison) REFERENCES Maison(id_maison),
   FOREIGN KEY(id_caracteristique) REFERENCES Caracteristique(id_caracteristique)
);


CREATE VIEW v_arrondissement_geometries AS
SELECT 
    pa.id_arrondissement,
    a.nom_arrondissement,
    SDO_GEOMETRY(
        2003, -- Type : Polygone
        4326, -- SRID
        NULL, 
        SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- Anneau extérieur
        CAST(
            COLLECT(SDO_ORDINATE_ARRAY(pa.longitude, pa.latitude)) AS SDO_ORDINATE_ARRAY
        ) -- Collection des coordonnées
    ) AS geometrie
FROM Point_Arrondissement pa
JOIN Arrondissement a ON a.id_arrondissement=pa.id_arrondissement
GROUP BY pa.id_arrondissement;


CREATE OR REPLACE VIEW Maison_Arrondissement AS
SELECT 
    m.id_maison,
    m.adresse,
    m.longitude,
    m.latitude,
    a.id_arrondissement,
    a.nom_arrondissement
FROM 
    Maison m
JOIN 
    v_arrondissement_geometries a
ON 
    SDO_GEOM.RELATE(
        a.geometrie,
        'CONTAINS',
        SDO_GEOMETRY(2001, NULL, SDO_POINT_TYPE(m.longitude, m.latitude, NULL), NULL, NULL),
        0.005
    ) = 'TRUE';
