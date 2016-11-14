; Definicion de Templates

; Template de Sintoma

(deftemplate Sintoma
	(slot Sensibilidad 
		(type STRING) (allowed-strings
                            "Sin Informacion"
                            "Frio"
                            "Calor")
                      (default "Sin Informacion")
	)
	(slot Dolor 
		(type STRING) (allowed-strings
		                    "Sin Informacion"
                            "Al morder" 
                            "Sensacion de diente flojo" 
                            "De cabeza"
                            "Al tragar"
                            "En las articulaciones temporomandibulares")
                      (default "Sin Informacion")
	)
	(slot Inflamacion 
		(type STRING) (allowed-strings
		                    "Sin Informacion"
                            "Enrojecimiento de las encias" 
                            "Hinchazon de las encias" 
                            "Sangrado de encias" 
                            "Bruxismo")
                      (default "Sin Informacion")
	)
	(slot Salud 
		(type STRING) (allowed-strings
		                    "Sin Informacion"
                            "Mal aliento" 
                            "Exceso de placa" 
                            "Exceso de saliva")
                      (default "Sin Informacion")
	)
)

; Template de Factor de Riesgo

(deftemplate FactorDeRiesgo 
    (slot Enfermedad
        (type STRING) (allowed-strings
                            "Sin Informacion"
                            "Defectos dentales" 
                            "Flujo salival reducido" 
                            "Obesidad" 
                            "Diabetes")
                      (default "Sin Informacion")
    )
    (slot Habito
        (type STRING) (allowed-strings
                            "Sin Informacion"
                            "Fumar"
                            "Dieta excesiva en carbohidratos y azucares")
                      (default "Sin Informacion")
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