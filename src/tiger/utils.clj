(ns tiger.utils)

(defn flip [f]
  (fn [x y] (f y x)))
