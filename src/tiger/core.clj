(ns tiger.core)

(defonce api-key (atom ""))

(defn get-api-key []
  (deref api-key))

(defn set-api-key! [k]
  (reset! api-key k))
