; Definicion de Templates

; Template de Sintoma

(deftemplate Sintoma
	(slot Sensibilidad 
		(type STRING) (allowed-strings "Frio" "Calor")
	)
	(slot Dolor 
		(type STRING) (allowed-strings 
                            "Al morder" 
                            "Sensacion de diente flojo" 
                            "De cabeza" "Al tragar" 
                            "En las articulaciones temporomandibulares") 
	)
	(slot Inflamacion 
		(type STRING) (allowed-strings 
                            "Enrojecimiento de las encias" 
                            "Hinchazon de las encias" 
                            "Sangrado de encias" 
                            "Bruxismo")
	)
	(slot Salud 
		(type STRING) (allowed-strings 
                            "Mal aliento" 
                            "Exceso de placa" 
                            "Exceso de saliva")
	)
)

; Template de Factor de Riesgo

(deftemplate FactorDeRiesgo 
    (slot Enfermedad
        (type STRING) (allowed-strings 
                            "Defectos dentales" 
                            "Flujo salival reducido" 
                            "Obesidad" 
                            "Diabetes")
    )
    (slot Habito
        (type STRING) (allowed-strings 
                            "Control inadecuado de la placa" 
                            "Fumar" 
                            "Deficiencia de vitamina C" 
                            "Dieta excesiva en carbohidratos y azucares" ) 
    )
)

; Template de Presuncion

(deftemplate Presuncion
	(slot PosibleTrastorno
		(type STRING)
		(allowed-strings
			"Caries"
			"Pulpitis"
			"Fractura"
			"Dislocacion Mandibular"
			"Osteonecrosis de la Mandibula"
			"Periodontitis"
			"Gingivitis"
			"Gingivitis Ulceronecrotizante Aguda"
			"Anquilosis de la Articulacion Temporomandibular"
			"Artritis de la Articulacion Temporomandibular"
			"Hiperplasia Condilar Mandibular"
			"Hipoplasia Condilar Mandibular"
			"Dolor Miofascial"
			"Trastornos de la Articulacion Temporomandibular")
		(default ?NONE))
	(slot Probabilidad
		(type STRING)
		(allowed-strings "Muy Alta" "Alta" "Media" "Baja" "Sin Informacion")
		(default "Sin Informacion"))
	(slot Justificacion
	    (type STRING)))