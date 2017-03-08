(ns tiger.customers
  (:require [tiger.http :as http]
            [tiger.utils :as utils])
  (:refer-clojure :exclude [list?]))

(defn customer? [m]
  (utils/has-keys? m [:id
                      :object
                      :account_balance
                      :created
                      :currency
                      :default_source
                      :delinquent
                      :description
                      :discount
                      :email
                      :livemode
                      :metadata
                      :shipping
                      :sources]))

(defn list? [m]
  (utils/has-keys? m [:url :has_more :object :data]))

(defn list! []
  (-> (http/get "/customers")
      http/send!))

(defn get! [id]
  (-> (http/get (str "/customers/" id))
      http/send!))

(defn create! [m]
  (-> (http/post "/customers" {:form-params m})
      http/send!))

(defn update! [id m]
  (-> (http/post (str "/customers/" id) {:form-params m})
      http/send!))

(defn delete! [id]
  (-> (http/delete (str "/customers/" id))
      http/send!))
