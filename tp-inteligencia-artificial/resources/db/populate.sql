# AFFECTIONS
DELETE FROM affections WHERE id != -1 LIMIT 1000;
INSERT INTO affections(name, type) VALUES
	('Caries', 1),
	('Pulpitis', 1),
	('Fractura', 1),
	('Gingivitis', 1),
	('Gingivitis Ulceronecrotizante Aguda', 1),
	('Periodontitis', 2),
	('Dislocacion mandibular', 3),
	('Osteonecrosis de la mandibula', 3),
	('Anquilosis de la Articulacion Temporomandibular', 3),
	('Artritis de la Articulacion Temporomandibular', 3),
	('Hiperplasia Condilar Mandibular', 3),
	('Hipoplasia Condilar Mandibular', 3),
	('Dolor Miofascial', 3),
	('Trastornos de la Articulacion Temporomandibular', 3);


# SYMPTOMS
DELETE FROM symptoms WHERE id != -1 LIMIT 1000;
INSERT INTO symptoms(type, name) VALUES
	(1, 'Frio'),
	(1, 'Calor'),
	(2, 'Al morder'),
	(2, 'Sensacion de diente flojo'),
	(2, 'De cabeza'),
	(2, 'Al tragar'),
	(2, 'En las articulaciones temporomandibulares'),
	(3, 'Enrojecimiento de las encias'),
	(3, 'Hinchazon de las encias'),
	(3, 'Sangrado de encias'),
	(3, 'Bruxismo'),
	(4, 'Mal aliento'),
	(4, 'Exceso de placa'),
	(4, 'Exceso de saliva');

# RISK FACTORS
DELETE FROM risk_factors WHERE id != -1 LIMIT 1000;
INSERT INTO risk_factors(type, name) VALUES
	(1, 'Defectos dentales'),
	(1, 'Flujo salival reducido'),
	(1, 'Obesidad'),
	(1, 'Diabetes'),
	(2, 'Fumar'),
	(2, 'Dieta excesiva en carbohidratos y azucares');
