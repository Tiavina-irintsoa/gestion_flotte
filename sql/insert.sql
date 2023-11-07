-- Insertion de données dans la table "marque"
INSERT INTO marque (nomMarque) VALUES
    ('Marque 1'),
    ('Marque 2'),
    ('Marque 3');

-- Insertion de données dans la table "vehicule"
INSERT INTO vehicule (matricule, idmarque) VALUES
    ('ABC123', 1),
    ('XYZ789', 2),  
    ('123XYZ', 3);  

INSERT INTO kilometrage (idvehicule, date, debutkm, finkm) VALUES
(1, '2023-01-15', 100, 250),
(2, '2023-01-16', 75, 300),
(1, '2023-01-18', 250, 500),
(3, '2023-01-20', 50, 150);

-- Insertion de données réelles dans la table utilisateur

INSERT INTO utilisateur (login, motdepasse) VALUES
('john_doe', 'motdepasse123'), -- Utilisateur : John Doe
('jane_smith', 'mdpSecret456'), -- Utilisateur : Jane Smith
('robert_adams', 'adamsPass789'); -- Utilisateur : Robert Adams
