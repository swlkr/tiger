(ns tiger.plans
  (:require [tiger.http :as http]
            [tiger.utils :as utils])
  (:refer-clojure :exclude [list?]))

(defn plan? [m]
  (utils/has-keys? m [:amount :name :created :currency :interval_count :id :trial_period_days :interval :livemode :metadata :object :statement_descriptor]))

(defn list? [m]
  (utils/has-keys? m [:url :has_more :object :data]))

(defn list! []
  (-> (http/get "/plans")
      http/send!
      http/parse-response
      :body))

(defn get! [id]
  (let [url (str "/plans/" id)]
    (-> (http/get url)
        http/send!
        http/parse-response
        :body)))

(defn create! [m]
  (-> (http/post "/plans" m)
      http/send!
      http/parse-response
      :body))

(defn update! [id m]
  (let [url (str "/plans/" id)]
    (-> (http/put url m)
        http/send!
        http/parse-response
        :body)))

(defn delete! [id]
  (let [url (str "/plans/" id)]
    (-> (http/delete url)
        http/send!
        http/parse-response
        :body)))
