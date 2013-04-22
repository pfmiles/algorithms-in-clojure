(ns bubble-sort)

; bubble-sort, two nested "loops".
(defn bubble-sort 
  [col]
  ((fn
     [cc i]
     (if (< i 1)
       cc
       (letfn [(inner-loop
                 [c j]
                 (if (> j (- i 2))
                   c
                   (let [_1st (first c)
                         _2nd (second c)
                         others (rest (rest c))]
                     (if (> _1st _2nd)
                       (cons _2nd (inner-loop (cons _1st others) (inc j)))
                       (cons _1st (inner-loop (cons _2nd others) (inc j)))))))]
         (recur (inner-loop cc 0) (dec i)))))
    col (count col)))

; tail-recursion version, which would not overflow.
(defn bubble-sort-tail
  [col]
  ((fn
     [cc i]
     (if (< i 1)
       cc
       (let [inner-loop (fn 
                          [c j rst]
                          (if (> j (- i 2))
                            (into rst c)
                            (let [_1st (first c)
                                  _2nd (second c)
                                  others (rest (rest c))]
                              (if (> _1st _2nd)
                                (recur (cons _1st others) (inc j) (conj rst _2nd))
                                (recur (cons _2nd others) (inc j) (conj rst _1st))))))]
         (recur (inner-loop cc 0 []) (dec i)))))
    col (count col)))

;(time (bubble-sort-tail (vec (range 100000 0 -1))))
;"Elapsed time: 811439.431946 msecs"
