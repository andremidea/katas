(ns katas.pangrams
  (:require [clojure.test :refer :all]
            [clojure.string :as str]))


(defn pangrams [s]
  (let [ letters (-> s
       str/lower-case
       (str/replace #" " "")
       set)]
    (if (= (count letters) 26)
      "pangram"
      "not pangram")))


(testing "panrams"
  (is
   (= (pangrams "We promptly judged antique ivory buckles for the next prize") "pangram"))
  (is
   (= (pangrams "We promptly judged antique ivory buckles for the prize") "not pangram")))

