(ns tiger.events
  (:require [tiger.http :as http]
            [tiger.utils :as utils]))

(defn event? [val]
  (utils/has-keys? val [:request :type :created :pending_webhooks :id :api_version :livemode :object :data]))

(defn get! [id]
  (-> (str "/events/" id)
      http/get
      http/send!))
