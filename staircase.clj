(ns katas.staircase
  (:require [clojure.test :refer :all]))

(def spaces (repeat " "))
(def hashs (repeat "#"))

(defn make-step [total-chars step-n]
  (let [whites (- total-chars step-n)]
    (apply str (concat (take whites spaces) (take step-n hashs)))))

(defn staircase [n]
  (let [ c (rest (range (inc n)))]
    (map (partial make-step n) c)))


(testing "staircase"
  (is
   (= (staircase 4)
      ["   #"
       "  ##"
       " ###"
       "####"])))

