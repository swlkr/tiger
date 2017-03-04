(ns tiger.http
  (:require [tiger.utils :as utils]
            [cheshire.core :as json]
            [org.httpkit.client :as http-kit]
            [tiger.core :refer [get-api-key]])
  (:refer-clojure :exclude [get]))

(defn make-url [& args]
  (clojure.string/replace (apply str args) #"(\w+)\/+" "$1/"))

(defn req-body [m]
  (condp (utils/flip contains?) m
    :body {:body (json/generate-string (:body m))}
    :form-params {:form-params (clojure.walk/stringify-keys (:form-params m))}
    {:body ""}))

(defn make-request
  ([method url]
   {:url (make-url "https://api.stripe.com/v1/" url)
    :headers {"Authorization" (str "Bearer " (get-api-key))}
    :method method})
  ([method url params]
   (let [body (req-body params)]
     (-> (make-request method url)
         (merge body)))))

(def get (partial make-request :get))
(def post (partial make-request :post))
(def put (partial make-request :put))
(def delete (partial make-request :delete))

(defn parse-response [{:keys [error status body] :as response}]
  (let [parsed-body (json/parse-string body true)]
    (assoc response :body parsed-body)))

(defn send! [m]
  (-> m http-kit/request deref))
