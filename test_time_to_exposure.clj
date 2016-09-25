(ns test.time-to-exposure
  (:require [time-to-exposure :as time]
            [clojure.test :refer :all]))


(def input-1 [[1 2] [2 3] [3 4] [3 7] [4 5] [4 6] [7 8]])

(def input-3
[
 [0 1]
 [0 8]
 [0 15]
 [1 2]
 [1 5]
 [2 3]
 [2 4]
 [5 6]
 [5 7]
 [8 9]
 [8 12]
 [9 10]
 [9 11]
 [12 13]
 [12 14]
 [15 16]
 [15 19]
 [16 17]
 [16 18]
 [19 20]
 [19 21]
 ])

(defn min-time [input]
  (let [graph (time/into-graph input)]
    (time/check-min-value graph)))

(testing "min time to exposure"
  (is
   (= (min-time input-1) 2))
  (is
   (= (min-time input-3)) 3))

