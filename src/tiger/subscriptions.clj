(ns tiger.subscriptions
  (:require [tiger.http :as http]
            [tiger.utils :as utils])
  (:refer-clojure :exclude [list?]))

(defn subscription? [m]
  (utils/has-keys? m [:application_fee_percent
                      :cancel_at_period_end
                      :canceled_at
                      :created
                      :current_period_end
                      :current_period_start
                      :customer
                      :discount
                      :ended_at
                      :id
                      :items
                      :livemode
                      :metadata
                      :object
                      :plan
                      :quantity
                      :start
                      :status
                      :tax_percent
                      :trial_end
                      :trial_start]))

(defn list! []
  (-> (http/get "/subscriptions")
      http/send!))

(defn get! [id]
  (-> (http/get (str "/subscriptions/" id))
      http/send!))

(defn create! [m]
  (-> (http/post "/subscriptions" {:form-params m})
      http/send!))

(defn update! [id m]
  (-> (http/post (str "/subscriptions/" id) {:form-params m})
      http/send!))

(defn delete! [id]
  (-> (http/delete (str "/subscriptions/" id))
      http/send!))
