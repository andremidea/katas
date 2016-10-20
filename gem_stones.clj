(ns katas.gem-stores
  "https://www.hackerrank.com/challenges/gem-stones"
  (:require [clojure.test :refer :all]
            [clojure.set :as c-set]))

(defn gem-stones [stones]
  (count (apply c-set/intersection (map set stones))))

(testing "gem-stones"
  (is
   (= (gem-stones ["abcdde"
                   "baccd"
                   "eeabg"]) 2)))

