(ns tiger.events
  (:require [tiger.http :as http]))

(defn get! [id]
  (let [url (str "/events/" id)]
    (-> (http/get url)
        http/request
        http/res
        :body)))
