(ns katas.time-to-exposure)

(def input [[1 2] [2 3] [3 4] [3 7] [4 5] [4 6] [7 8]])

(defn insert [graph tuple]
  (let [[node edge] tuple]
    (-> (update-in graph [node] conj edge)
        (update-in [edge] conj node))))

(defn into-graph [input]
  (reduce insert {} input))

(defn depth [graph node]
  (let [es (get graph node)]
    (if (nil? es)
      1
      (apply max
       (map #(-> (depth graph %) inc) es)))))

(defn remove-node-from-edge [graph node edge]
  (update-in graph [edge] #(remove #{node} %)))

(defn exposure [graph node]
  (let [es (get graph node)]
    (if (empty? es)
      0
      (apply max
             (map #(-> (exposure
                        (remove-node-from-edge graph node %) %) inc) es)))))

(defn min-time [graph]
  (apply min (map #(exposure graph %) (keys graph))))

(defn tallness [graph node]
  (filter (fn [[k v]] (contains? v node)) graph))


(def output [10 10 10 8 8 7 7 6 6 4 5 5 7 7 10 10])

(defn check-closest [graph nodes]
  (let [nodes+closeness (partition 2 (interleave nodes (map #(exposure graph %) nodes)))]
    (reduce (fn [[closest new-nodes] [node distance]]
              (cond
                (< distance closest) [distance [node]]
                (> distance closest) [closest new-nodes]
                (= distance closest) [closest (conj new-nodes node)]))
            [Integer/MAX_VALUE []] nodes+closeness)))

(defn breadth-first-search [graph nodes last-closeness]
  (let [[closest new-nodes] (check-closest graph nodes)]
    (if (>= closest last-closeness) last-closeness
        (recur graph (mapcat #(remove #{%} (get graph %)) new-nodes) closest))))

(defn check-min-value [graph]
  (breadth-first-search graph [(-> graph first first)] Integer/MAX_VALUE))
