(defrule R21
	(or
		(Sintoma (Sensibilidad "Frio"))
        	(Sintoma (Sensibilidad "Calor"))
	)
	(or
		(FactorDeRiesgo (Habito "Dieta excesiva en carbohidratos y azucares"))
		(FactorDeRiesgo (Enfermedad "Flujo salival reducido"))
		(FactorDeRiesgo (Enfermedad "Defectos dentales"))
		(FactorDeRiesgo (Habito "Control inadecuado de la placa"))
	)
	=>
	(assert
        	(Presuncion
			(PosibleTrastorno "Caries")
		        (Probabilidad "Muy Alta")
        		(Justificacion "Sensbilidad al frio o al calor, enfermedades dentales y malos habitos alimenticios")
		)
	)
)

(defrule R22
      	(or
        	(Sintoma (Sensibilidad "Frio"))
        	(Sintoma (Sensibilidad "Calor"))
	)
	(Sintoma (Dolor "En las articulaciones temporomandibulares"))
	(Sintoma (Inflamacion "Hinchazon de las encias"))
	=>
	(assert
		(Presuncion
			(PosibleTrastorno "Pulpitis")
			(Probabilidad "Muy Alta")
			(Justificacion "Sensibilidad al frio o al calor, dolor en la mandibula e hinchazon de las encias")
		)
	)
)

(defrule R23
    (Sintoma (Sensibilidad "Frio"))
    (Sintoma (Dolor "Al morder"))
    (Sintoma (Inflamacion "Enrojecimiento de las encias"))
    =>
    (assert
        (Presuncion
            (PosibleTrastorno "Fractura")
            (Probabilidad "Muy Alta")
            (Justificacion "Sensibilidad al frio (aire/agua), dolores al morder y inflamacion en las encias")
        )
    )
)

(defrule R24
	(or
		(Sintoma (Inflamacion "Enrojecimiento de las encias"))
		(Sintoma (Inflamacion "Sangrado de encias"))
	)
	(or
		(FactorDeRiesgo (Enfermedad "Diabetes"))
		(FactorDeRiesgo (Habito "Deficiencia de vitamina C"))
	)
	=>
	(assert
		(Presuncion
			(PosibleTrastorno "Gingivitis")
			(Probabilidad "Muy Alta")
			(Justificacion "Inflamacion o sangrado de encias junto con diabetes o falta de vitamina C")
		)
	)
)

(defrule R25
	(Sintoma (Inflamacion "Sangrado de encias"))
	(or
		(Sintoma (Salud "Exceso de saliva"))
		(Sintoma (Salud "Mal aliento"))
	)
	=>
	(assert
		(Presuncion
			(PosibleTrastorno "Gingivitis Ulceronecrotizante Aguda")
			(Probabilidad "Muy Alta")
			(Justificacion "Sangrado de encias junto a exceso de saliva o muy mal aliento")
		)
	)
)

(defrule R26
	(Sintoma (Dolor "Al morder"))
	(Sintoma (Salud "Exceso de placa"))
	(Sintoma (Salud "Mal aliento"))
	(or
		(FactorDeRiesgo (Habito "Fumar"))
		(FactorDeRiesgo (Enfermedad "Obesidad"))
		(FactorDeRiesgo (Habito "Deficiencia de vitamina C"))
		(FactorDeRiesgo (Habito "Control inadecuado de la placa"))
	)
	=>
	(assert
		(Presuncion
			(PosibleTrastorno "Periodontitis")
			(Probabilidad "Muy Alta")
			(Justificacion "Dolores al morder, exceso visible de placa y mal aliento; malos habitos como fumar frecuentemente, dieta pobre en vitamina C o mal control de la placa")
		)
	)
)

(defrule R27
	(Sintoma (Inflamacion "Bruxismo"))
	(or
		(Sintoma (Dolor "De cabeza"))
		(Sintoma (Dolor "En las articulaciones temporomandibulares"))
	)
	=>
	(assert
		(Presuncion
			(PosibleTrastorno "Dolor Miofascial")
			(Probabilidad "Muy Alta")
			(Justificacion "Bruxismo y dolores de cabeza o temporomandibulares")
		)
	)
)

(defrule R28
	(Sintoma (Dolor "Al morder"))
	(Sintoma (Dolor "En las articulaciones temporomandibulares"))
	(Sintoma (Inflamacion "Hinchazon de las encias"))
	=>
	(assert
		(Presuncion
			(PosibleTrastorno "Dislocacion Mandibular")
			(Probabilidad "Muy Alta")
			(Justificacion "Dolores al morder y en las articulaciones de la mandibula, hinchazon visible de las encias")
		)
	)
)

(defrule R1
    (Sintoma (Sensibilidad "Frio"))
    =>
    (bind ?j "Sensibilidad al Frio")
    (assert (Presuncion (PosibleTrastorno "Gingivitis") (Probabilidad "Media") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Pulpitis") (Probabilidad "Media") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Baja") (Justificacion ?j)))
)
    
(defrule R2
    (Sintoma (Sensibilidad "Calor"))
    =>
    (bind ?j "Sensibilidad al Calor")
    (assert (Presuncion (PosibleTrastorno "Pulpitis") (Probabilidad "Media") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Media") (Justificacion ?j)))
)

(defrule R3
    (Sintoma (Salud "Exceso de placa"))
    =>
    (bind ?j "Exceso de Placa")
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Alta") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Media") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Media") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Anquilosis de la Articulacion Temporomandibular") (Probabilidad "Baja") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Hipoplasia Condilar Mandibular") (Probabilidad "Baja") (Justificacion ?j)))
)

(defrule R4
    (Sintoma (Inflamacion "Enrojecimiento de las encias"))
    =>
    (bind ?j "Enrojecimiento de las Encias")
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Media") (Justificacion ?j)))
	(assert (Presuncion (PosibleTrastorno "Hipoplasia Condilar Mandibular") (Probabilidad "Media") (Justificacion ?j)))
	(assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Baja") (Justificacion ?j)))
	(assert (Presuncion (PosibleTrastorno "Osteonecrosis de la Mandibula") (Probabilidad "Baja") (Justificacion ?j)))
	(assert (Presuncion (PosibleTrastorno "Gingivitis") (Probabilidad "Baja") (Justificacion ?j)))
	(assert (Presuncion (PosibleTrastorno "Artritis de la Articulacion Temporomandibular") (Probabilidad "Baja") (Justificacion ?j)))
)

(defrule R5
    (Sintoma (Inflamacion "Hinchazon de las encias"))
    =>
    (bind ?j "Hinchazon de las Encias")
    (assert (Presuncion (PosibleTrastorno "Osteonecrosis de la Mandibula") (Probabilidad "Alta") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Gingivitis") (Probabilidad "Alta") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Media") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Pulpitis") (Probabilidad "Media") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Gingivitis Ulceronecrotizante Aguda") (Probabilidad "Media") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Anquilosis de la Articulacion Temporomandibular") (Probabilidad "Media") (Justificacion ?j)))
)

(defrule R6
    (Sintoma (Dolor "Al morder"))
    =>
    (bind ?j "Dolor al Morder")
    (assert (Presuncion (PosibleTrastorno "Trastornos de la Articulacion Temporomandibular") (Probabilidad "Alta") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Media") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Media") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Dolor Miofascial") (Probabilidad "Media") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Pulpitis") (Probabilidad "Baja") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Dislocacion Mandibular") (Probabilidad "Baja") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Anquilosis de la Articulacion Temporomandibular") (Probabilidad "Baja") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Artritis de la Articulacion Temporomandibular") (Probabilidad "Baja") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Hiperplasia Condilar Mandibular") (Probabilidad "Baja") (Justificacion ?j)))
)

(defrule R7
    (Sintoma (Dolor "Sensacion de diente flojo"))
    =>
    (bind ?j "Sensacion de Diente Flojo")
    (assert (Presuncion (PosibleTrastorno "Dolor Miofascial") (Probabilidad "Baja") (Justificacion ?j)))
)

(defrule R8
    (Sintoma (Inflamacion "Sangrado de encias"))
    =>
    (bind ?j "Sangrado de Encias")
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Alta") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Media") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Osteonecrosis de la Mandibula") (Probabilidad "Media") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Gingivitis Ulceronecrotizante Aguda") (Probabilidad "Media") (Justificacion ?j)))
)

(defrule R9
    (Sintoma (Salud "Exceso de saliva"))
    =>
    (bind ?j "Exceso de Saliva")
    (assert (Presuncion (PosibleTrastorno "Gingivitis Ulceronecrotizante Aguda") (Probabilidad "Media") (Justificacion ?j)))
)

(defrule R10
    (Sintoma (Salud "Mal aliento"))
    =>
    (bind ?j "Mal Aliento")
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Media") (Justificacion ?j)))
)

(defrule R11
	(Sintoma (Dolor "De cabeza"))
	=>
	(bind ?j "Dolor de Cabeza")
	(assert (Presuncion (PosibleTrastorno "Dislocacion Mandibular") (Probabilidad "Media") (Justificacion ?j)))
)

(defrule R12
	(Sintoma (Dolor "Al tragar"))
	=>
    (bind ?j "Dolor al Tragar")
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Baja") (Justificacion ?j)))
)

(defrule R13
	(Sintoma (Dolor "En las articulaciones temporomandibulares"))
	=>
	(bind ?j "Dolor en las Articulaciones Temporomandibulares")
	(assert (Presuncion (PosibleTrastorno "Artritis de la Articulacion Temporomandibular") (Probabilidad "Alta") (Justificacion ?j)))
	(assert (Presuncion (PosibleTrastorno "Dislocacion Mandibular") (Probabilidad "Media") (Justificacion ?j)))
	(assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Media") (Justificacion ?j)))
	(assert (Presuncion (PosibleTrastorno "Anquilosis de la Articulacion Temporomandibular") (Probabilidad "Media") (Justificacion ?j)))
	(assert (Presuncion (PosibleTrastorno "Trastornos de la Articulacion Temporomandibular") (Probabilidad "Media") (Justificacion ?j)))
	(assert (Presuncion (PosibleTrastorno "Hipoplasia Condilar Mandibular") (Probabilidad "Baja") (Justificacion ?j)))
)

(defrule R14
	(Sintoma (Inflamacion "Bruxismo"))
	=>
	(bind ?j "Bruxismo")
	(assert (Presuncion (PosibleTrastorno "Dolor Miofascial") (Probabilidad "Media") (Justificacion ?j)))
	(assert (Presuncion (PosibleTrastorno "Dislocacion Mandibular") (Probabilidad "Baja") (Justificacion ?j)))
	(assert (Presuncion (PosibleTrastorno "Anquilosis de la Articulacion Temporomandibular") (Probabilidad "Baja") (Justificacion ?j)))
	(assert (Presuncion (PosibleTrastorno "Trastornos de la Articulacion Temporomandibular") (Probabilidad "Baja") (Justificacion ?j)))
)

(defrule R15
    (FactorDeRiesgo (Enfermedad "Defectos dentales"))
    =>
    (bind ?j "Defectos Dentales")
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Alta") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Pulpitis") (Probabilidad "Baja") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Baja") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Anquilosis de la Articulacion Temporomandibular") (Probabilidad "Baja") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Hiperplasia Condilar Mandibular") (Probabilidad "Baja") (Justificacion ?j)))
)

(defrule R16
    (FactorDeRiesgo (Habito "Dieta excesiva en carbohidratos y azucares"))
    =>
    (bind ?j "Dieta Excesiva en Carbohidratos y Azucares")
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Baja") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Fractura") (Probabilidad "Baja") (Justificacion ?j)))
)

(defrule R17
    (FactorDeRiesgo (Enfermedad "Flujo salival reducido"))
    =>
    (bind ?j "Flujo Salival Reducido")
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Baja") (Justificacion ?j)))
)

(defrule R18
    (FactorDeRiesgo (Habito "Fumar"))
    =>
    (bind ?j "Fumador")
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Baja") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Osteonecrosis de la Mandibula") (Probabilidad "Baja") (Justificacion ?j)))
)

(defrule R19
    (FactorDeRiesgo (Enfermedad "Obesidad"))
    =>
    (bind ?j "Obesidad")
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Baja") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Dislocacion Mandibular") (Probabilidad "Baja") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Periodontitis") (Probabilidad "Baja") (Justificacion ?j)))
)

(defrule R20
    (FactorDeRiesgo (Enfermedad "Diabetes"))
    =>
    (bind ?j "Diabetes")
    (assert (Presuncion (PosibleTrastorno "Gingivitis") (Probabilidad "Media") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Caries") (Probabilidad "Baja") (Justificacion ?j)))
    (assert (Presuncion (PosibleTrastorno "Gingivitis Ulceronecrotizante Aguda") (Probabilidad "Baja") (Justificacion ?j)))
)

