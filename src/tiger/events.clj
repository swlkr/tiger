(ns tiger.events
  (:require [tiger.http :as http]
            [tiger.utils :as utils]))

(defn event? [val]
  (utils/has-keys? val [:request :type :created :pending_webhooks :id :api_version :livemode :object :data]))

(defn get! [id]
  (let [url (str "/events/" id)]
    (-> (http/get url)
        http/send!
        http/parse-response
        :body)))
