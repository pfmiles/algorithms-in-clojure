(ns quick-sort)

(defn quick-sort
  [col]
  (if (empty? col)
    col
    (let [pivot (first col)]
      (concat 
        (quick-sort (filter #(< % pivot) col))
        (list pivot) 
        (quick-sort (filter #(> % pivot) col))))))