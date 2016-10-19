(ns katas.triplets-comparison)

(def pred (every-pred
                (fn [[a b]] (and (<= a 100) (<= b 100)))
                (fn [[a b]] (and (>= a 1) (>= b 1)))
                (fn [[a b]] (> a b))))

(
 let [
      a-results [1 5 10 3]
      b-results [3 2 10 2]
      part (partition 2 (interleave a-results b-results))
      alice-wins (filter pred part)
      bob-wins (filter #(pred (reverse %)) part)]
 (println (str (count alice-wins) " " (count bob-wins)))
 )


(
 let [arr [1000 1000]]
 (println (reduce (fn [sum num] (.add sum (BigInteger/valueOf num))) (BigInteger/ZERO) arr))
 )


(def hotels [[1 "aaaaaa a a a"] [2 "aaast bbb"]])

(defn strip [coll chars]
  (apply str (remove #((set chars) %) coll)))

(defn search-word [word review]
  (println word review)
  (count (re-seq (re-pattern word) (strip review ",.;:"))))

(defn search-words [words hotel]
  (let [[id review] hotel]
    [id (reduce
         (fn [total word]
           (+ total (search-word word review)))
         0 words)]))
