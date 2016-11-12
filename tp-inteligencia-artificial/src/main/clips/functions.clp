(deffunction get-weight (?p)
    (if (eq ?p "Muy Alta") then
        5
    else (if (eq ?p "Alta") then
        4
    else (if (eq ?p "Media") then
        3
    else (if (eq ?p "Baja") then
        2
    else
        1)))))

(deffunction presuncion-sort (?t1 ?t2)
   (< (get-weight (fact-slot-value ?t1 Probabilidad))
      (get-weight (fact-slot-value ?t2 Probabilidad))))

(deffunction get-presuncion-list ()
  (bind ?facts (find-all-facts ((?f Presuncion)) TRUE))
  (sort presuncion-sort ?facts))
