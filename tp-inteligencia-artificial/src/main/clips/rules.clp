(defrule R1
    (Sintoma (Sensibilidad "Frio"))
    =>
    (assert (Presuncion (PosibleTrastorno "Gingivitis") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Pulpitis") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Gingivitis Ulceronecrotizante Aguda")  (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Dolor Miofascial") (Probabilidad "Baja"))))
    
(defrule R2
    (Sintoma (Sensibilidad "Calor"))
    =>
    (assert (Presuncion (PosibleTrastorno "Pulpitis") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Hipoplasia Condilar Mandibular") (Probabilidad "Baja"))))
    
(defrule R3
    (Sintoma (Salud "Exceso de placa"))
    =>
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Muy Alta")))
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Anquilosis de la Articulacion Temporomandibular") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Hipoplasia Condilar Mandibular") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Gingivitis Ulceronecrotizante Aguda") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Hiperplasia Condilar Mandibular") (Probabilidad "Baja"))))
    
(defrule R4
    (Sintoma (Inflamacion "Enrojecimiento de las encias"))
    =>
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Alta")))
	(assert (Presuncion (PosibleTrastorno "Hipoplasia Condilar Mandibular") (Probabilidad "Alta")))
	(assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Media")))
	(assert (Presuncion (PosibleTrastorno "Osteonecrosis de la Mandibula") (Probabilidad "Media")))
	(assert (Presuncion (PosibleTrastorno "Gingivitis") (Probabilidad "Media")))
	(assert (Presuncion (PosibleTrastorno "Artritis de la Articulacion Temporomandibular") (Probabilidad "Media")))
	(assert (Presuncion (PosibleTrastorno "Gingivitis Ulceronecrotizante Aguda") (Probabilidad "Baja")))
	(assert (Presuncion (PosibleTrastorno "Anquilosis de la Articulacion Temporomandibular") (Probabilidad "Baja")))
	(assert (Presuncion (PosibleTrastorno "Hiperplasia Condilar Mandibular") (Probabilidad "Baja")))
	(assert (Presuncion (PosibleTrastorno "Dolor Miofascial") (Probabilidad "Baja"))))

(defrule R5
    (Sintoma (Inflamacion "Hinchazon de las encias"))
    =>
    (assert (Presuncion (PosibleTrastorno "Osteonecrosis de la Mandibula") (Probabilidad "Muy Alta")))
    (assert (Presuncion (PosibleTrastorno "Gingivitis") (Probabilidad "Muy Alta")))
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Pulpitis") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Gingivitis Ulceronecrotizante Aguda") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Anquilosis de la Articulacion Temporomandibular") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Dislocacion Mandibular") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Hiperplasia Condilar Mandibular") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Trastornos de la Articulacion Temporomandibular") (Probabilidad "Baja"))))

(defrule R6
    (Sintoma (Dolor "Al morder"))
    =>
    (assert (Presuncion (PosibleTrastorno "Trastornos de la Articulacion Temporomandibular") (Probabilidad "Muy Alta")))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Dolor Miofascial") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Pulpitis") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Dislocacion Mandibular") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Anquilosis de la Articulacion Temporomandibular") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Artritis de la Articulacion Temporomandibular") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Hiperplasia Condilar Mandibular") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Osteonecrosis de la Mandibula") (Probabilidad "Baja"))))

(defrule R7
    (Sintoma (Dolor "Sensacion de diente flojo"))
    =>
    (assert (Presuncion (PosibleTrastorno "Dolor Miofascial") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Hiperplasia Condilar Mandibular") (Probabilidad "Baja"))))

(defrule R8
    (Sintoma (Inflamacion "Sangrado de encias"))
    =>
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Muy Alta")))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Osteonecrosis de la Mandibula") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Gingivitis Ulceronecrotizante Aguda") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Hiperplasia Condilar Mandibular") (Probabilidad "Baja"))))

(defrule R9
    (Sintoma (Salud "Exceso de saliva"))
    =>
    (assert (Presuncion (PosibleTrastorno "Gingivitis Ulceronecrotizante Aguda") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Dislocacion Mandibular") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Anquilosis de la Articulacion Temporomandibular") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Hipoplasia Condilar Mandibular") (Probabilidad "Baja"))))

(defrule R10
    (Sintoma (Salud "Mal aliento"))
    =>
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Alta")))
    (assert (Presuncion (PosibleTrastorno "Osteonecrosis de la Mandibula") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Gingivitis Ulceronecrotizante Aguda") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Hiperplasia Condilar Mandibular") (Probabilidad "Baja"))))
	
(defrule R11 
	(Sintoma (Dolor "De cabeza"))
	=> 
	(assert (Presuncion (PosibleTrastorno "Dislocacion Mandibular") (Probabilidad "Alta")))
	(assert (Presuncion (PosibleTrastorno "Osteonecrosis de la Mandibula") (Probabilidad "Baja")))
	(assert (Presuncion (PosibleTrastorno "Gingivitis Ulceronecrotizante Aguda") (Probabilidad "Baja")))
	(assert (Presuncion (PosibleTrastorno "Anquilosis de la Articulacion Temporomandibular") (Probabilidad "Baja")))
	(assert (Presuncion (PosibleTrastorno "Hiperplasia Condilar Mandibular") (Probabilidad "Baja")))
	(assert (Presuncion (PosibleTrastorno "Hipoplasia Condilar Mandibular") (Probabilidad "Baja")))
	(assert (Presuncion (PosibleTrastorno "Trastornos de la Articulacion Temporomandibular") (Probabilidad "Baja"))))

(defrule R12 
	(Sintoma (Dolor "Al tragar"))
	=>
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Baja")))
	(assert (Presuncion (PosibleTrastorno "Trastornos de la Articulacion Temporomandibular") (Probabilidad "Baja"))))

(defrule R13 
	(Sintoma (Dolor "En las articulaciones temporomandibulares"))
	=>
	(assert (Presuncion (PosibleTrastorno "Artritis de la Articulacion Temporomandibular") (Probabilidad "Muy Alta")))
	(assert (Presuncion (PosibleTrastorno "Dislocacion Mandibular") (Probabilidad "Alta")))
	(assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Alta")))
	(assert (Presuncion (PosibleTrastorno "Anquilosis de la Articulacion Temporomandibular") (Probabilidad "Alta")))
	(assert (Presuncion (PosibleTrastorno "Trastornos de la Articulacion Temporomandibular") (Probabilidad "Alta")))
	(assert (Presuncion (PosibleTrastorno "Hipoplasia Condilar Mandibular") (Probabilidad "Media")))
	(assert (Presuncion (PosibleTrastorno "Osteonecrosis de la Mandibula") (Probabilidad "Baja")))	)

(defrule R14 
	(Sintoma (Inflamacion "Bruxismo"))
	=> 
	(assert (Presuncion (PosibleTrastorno "Dolor Miofascial") (Probabilidad "Alta")))
	(assert (Presuncion (PosibleTrastorno "Dislocacion Mandibular") (Probabilidad "Media")))
	(assert (Presuncion (PosibleTrastorno "Anquilosis de la Articulacion Temporomandibular") (Probabilidad "Media")))
	(assert (Presuncion (PosibleTrastorno "Trastornos de la Articulacion Temporomandibular") (Probabilidad "Media")))
	(assert (Presuncion (PosibleTrastorno "Hipoplasia Condilar Mandibular") (Probabilidad "Baja"))))

(defrule R15
    (FactorDeRiesgo (Enfermedad "Defectos dentales"))
    =>
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Muy Alta")))
    (assert (Presuncion (PosibleTrastorno "Pulpitis") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Anquilosis de la Articulacion Temporomandibular") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Hiperplasia Condilar Mandibular") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Hipoplasia Condilar Mandibular") (Probabilidad "Baja"))))

(defrule R16
    (FactorDeRiesgo (Habito "Dieta excesiva en carbohidratos y azucares"))
    =>
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Gingivitis Ulceronecrotizante Aguda") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Hiperplasia Condilar Mandibular") (Probabilidad "Baja"))))

(defrule R17
    (FactorDeRiesgo (Enfermedad "Flujo salival reducido"))
    =>
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Baja"))))

(defrule R18
    (FactorDeRiesgo (Habito "Fumar"))
    =>
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Osteonecrosis de la Mandibula") (Probabilidad "Baja"))))

(defrule R19
    (FactorDeRiesgo (Enfermedad "Obesidad"))
    =>
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Dislocacion Mandibular") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Baja"))))

(defrule R20
    (FactorDeRiesgo (Enfermedad "Diabetes"))
    =>
    (assert (Presuncion (PosibleTrastorno "Gingivitis") (Probabilidad "Media")))
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Baja")))
    (assert (Presuncion (PosibleTrastorno "Gingivitis Ulceronecrotizante Aguda") (Probabilidad "Baja"))))

