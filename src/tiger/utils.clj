(ns tiger.utils)

(defn flip [f]
  (fn [x y] (f y x)))

(defn has-keys? [m keys]
  (and
    (not (nil? m))
    (not (nil? keys))
    (map? m)
    (coll? keys)
    (every? (partial contains? m) keys)))
