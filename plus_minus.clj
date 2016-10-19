(ns katas.plus-minus
  (:require [clojure.test :refer :all]))


(defn fraction [total fraction]
  (.doubleValue (.setScale (java.math.BigDecimal/valueOf (float (/ (count fraction) total))) 6 java.math.BigDecimal/ROUND_HALF_EVEN)))

(defn calculate-fractions [numbers]
  (let [length (count numbers)
        zeroes (filter zero? numbers)
        positive (filter pos? numbers)
        negative (filter neg? numbers)]
    (map (partial fraction length)
         [positive negative zeroes])))

(def input [-4 3 -9 0 4 1])

(testing "plus minus"
  (is
   (=
    (calculate-fractions input) [0.500000
                                 0.333333
                                 0.166667])))

