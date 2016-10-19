(ns katas.diagnal-differences
  (:require [clojure.test :refer :all])

"Given a square matrix of size N x N, calculate the absolute difference between the sums of its diagonals.

Input Format

The first line contains a single integer, . The next  lines denote the matrix's rows, with each line containing space-separated integers describing the columns.

Output Format

Print the absolute difference between the two sums of the matrix's diagonals as a single integer.")




(defn sum-index [state line]
  (let [[index sum] state]
    [(inc index) (+ (nth line index) sum)]))

(defn difference [matrix]
  (Math/abs
      (- (last (reduce sum-index [0 0] matrix))
         (last (reduce sum-index [0 0]
                       (map reverse matrix))))))

(def input
  [[11 2 4]
   [4 5 6]
   [10 9 -12]])

(testing "diagonal diff"
  (is
   (= (difference input) 15)))





