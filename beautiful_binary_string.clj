(ns katas.beautiful-binary-string
  "https://www.hackerrank.com/challenges/beautiful-binary-string"
  (:require [clojure.test :refer :all]
            [clojure.string :as str]))



(defn make-beautiful [st]
  (loop [new st old "" c -1]
    (if (= new old)
      c
      (recur (str/replace-first new "010" "011") new (inc c)))))


(testing "make beautiful binary strings"
  (is
   (= (make-beautiful "0101010") 2))
  (is
   (= (make-beautiful "0100101010") 3)))


