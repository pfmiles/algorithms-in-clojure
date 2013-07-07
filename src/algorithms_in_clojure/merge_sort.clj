(ns algorithms-in-clojure.merge-sort)

(declare ms-merge)

(defn merge-sort [col]
  (let [size (count col)]
    (cond
      (<= size 1) col
      :else (let [middle (int (/ size 2))
                  [left right] (split-at middle col)
                  l-sorted (merge-sort left)
                  r-sorted (merge-sort right)]
              (ms-merge l-sorted r-sorted)))))

(defn- ms-merge [left right]
  (cond
    (empty? left) right
    (empty? right) left
    :else
      (let [lf (first left) ls (rest left) rf (first right) rs (rest right)]
        (cond
          (< lf rf) (cons lf (ms-merge ls right)) 
          :else (cons rf (ms-merge left rs))))))
