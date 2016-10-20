(ns katas.string-reducer
  (:require [clojure.test :refer :all]))


(defn cancel-pairs [pairs]
  (loop [[a b & r] pairs s (count pairs)]
    (let [pairs? (= a b)
          r' (if pairs? r (concat [b] r [a]))]
      (if (= 0 s)
        (concat [a b] r)
        (recur r' (dec s))))))

(defn reduce-string [st]
  (let [cancelled-pairs (cancel-pairs st)
        final-string (apply str (filter char? cancelled-pairs))]
    (if (empty? final-string)
      "Empty String"
      final-string)))


(testing "string reducer"
  (is
   (= (reduce-string "aaabccddd") "abd"))
  (is
   (= (reduce-string "baab") "Empty String"))
  (is
   (= (reduce-string "aa") "Empty String"))
  (is
   (= (reduce-string "zztqooauhujtmxnsbzpykwlvpfyqijvdhuhiroodmuxiobyvwwxupqwydkpeebxmfvxhgicuzdealkgxlfmjiucasokrdznmtlwh")
      "tqauhujtmxnsbzpykwlvpfyqijvdhuhirdmuxiobyvxupqwydkpbxmfvxhgicuzdealkgxlfmjiucasokrdznmtlwh")))

