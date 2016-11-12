# AFFECTIONS
INSERT INTO affections(name, type) VALUES
	('Caries', 1),
	('Pulpitis', 1),
	('Fractura', 1),
	('Gingivitis', 1),
	('Gingivitis Ulceronecrotizante Aguda', 1),
	('Periodontitis', 2),
	('Dislocación mandibular', 3),
	('Osteonecrosis de la mandíbula', 3),
	('Anquilosis de la Articulación Temporomandibular', 3),
	('Artritis de la Articulación', 3),
	('Hiperplasia Condilar Mandibular', 3),
	('Hipoplasia Condilar Mandibular', 3),
	('Dolor Miofascial', 3),
	('Trastornos de la Articulación Temporomandibular', 3);
	
	
# SYMPTOMS
INSERT INTO symptoms(type, name) VALUES
	(1, 'Frío'),
	(1, 'Calor'),
	(2, 'Al morder'),
	(2, 'Sensación de diente flojo'),
	(2, 'De cabeza'),
	(2, 'Al tragar'),
	(2, 'En las articulaciones temporomandibulares'),
	(3, 'Enrojecimiento de las encías'),
	(3, 'Hinchazón de las encías'),
	(3, 'Sangrado de encías'),
	(3, 'Bruxismo'),
	(4, 'Mal aliento'),
	(4, 'Exceso de placa'),
	(4, 'Exceso de saliva');
	
# RISK FACTORS
INSERT INTO risk_factors(type, name) VALUES
	(1, 'Defectos dentales'),
	(1, 'Flujo salival reducido'),
	(1, 'Obesidad'),
	(1, 'Diabetes'),
	(2, 'Control inadecuado de la placa'),
	(2, 'Fumar'),
	(2, 'Deficiencia de vitamina C'),
	(2, 'Dieta excesiva en carbohidratos y azúcares');
	