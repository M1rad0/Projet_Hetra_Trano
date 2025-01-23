-- Séquence pour la table Maison
CREATE SEQUENCE seq_maison
START WITH 1
INCREMENT BY 1
NOCACHE;

-- Séquence pour la table Categorie_Car
CREATE SEQUENCE seq_categorie_car
START WITH 1
INCREMENT BY 1
NOCACHE;

-- Séquence pour la table Prix
CREATE SEQUENCE seq_prix
START WITH 1
INCREMENT BY 1
NOCACHE;

-- Séquence pour la table Arrondissement
CREATE SEQUENCE seq_arrondissement
START WITH 1
INCREMENT BY 1
NOCACHE;

-- Séquence pour la table Paiement
CREATE SEQUENCE seq_paiement
START WITH 1
INCREMENT BY 1
NOCACHE;

-- Séquence pour la table Caractestique
CREATE SEQUENCE seq_caracteristique
START WITH 1
INCREMENT BY 1
NOCACHE;

-- Séquence pour la table Caracteristique_Maison
CREATE SEQUENCE seq_caracteristique_maison
START WITH 1
INCREMENT BY 1
NOCACHE;


CREATE OR REPLACE FUNCTION getNomSeq(nom_sequence VARCHAR2)
RETURN NUMBER
AS
   valeur_sequence NUMBER;
BEGIN
   EXECUTE IMMEDIATE 'SELECT ' || nom_sequence || '.NEXTVAL FROM dual' INTO valeur_sequence;
   RETURN valeur_sequence;
END;
/
