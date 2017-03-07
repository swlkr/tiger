(ns tiger.plans
  (:require [tiger.http :as http]
            [tiger.utils :as utils])
  (:refer-clojure :exclude [list?]))

(defn plan? [m]
  (utils/has-keys? m [:amount :name :created :currency :interval_count :id :trial_period_days :interval :livemode :metadata :object :statement_descriptor]))

(defn list? [m]
  (utils/has-keys? m [:url :has_more :object :data]))

(defn send! [req]
  (-> req
      http/send!
      http/parse-response
      :body))

(defn list! []
  (-> (http/get "/plans")
      send!))

(defn get! [id]
  (-> (http/get (str "/plans/" id))
      send!))

(defn create! [m]
  (-> (http/post "/plans" {:form-params m})
      send!))

(defn update! [id m]
  (-> (http/post (str "/plans/" id) {:form-params m})
      send!))

(defn delete! [id]
  (-> (str "/plans/" id)
      http/delete
      send!))
