(ns tiger.core
  (:require [clojure.tools.namespace.repl :as tn])
  (:gen-class))

(defonce api-key (atom ""))

(defn get-api-key []
  (deref api-key))

(defn set-api-key! [k]
  (reset! api-key k))

(defn refresh []
  (tn/refresh))
