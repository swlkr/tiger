(ns tiger.events-test
  (:require [clojure.test :refer :all]
            [tiger.events :as events]
            [tiger.http :as http]
            [cheshire.core :as json]))

(def test-event {:request "req_AC3S5jsqKntkQZ",
                 :type "customer.created",
                 :created 1488166732,
                 :pending_webhooks 0,
                 :id "evt_AC3SuhOOYgjek4",
                 :api_version "2017-01-27",
                 :livemode false,
                 :object "event",
                 :data {:object {:default_source nil,
                                 :description nil,
                                 :email nil,
                                 :delinquent false,
                                 :account_balance 0,
                                 :sources {:object "list",
                                           :data [],
                                           :has_more false,
                                           :total_count 0,
                                           :url "/v1/customers/cus_AC3SKt227SZKlu/sources"},
                                 :created 1488166732,
                                 :subscriptions {:object "list",
                                                 :data [],
                                                 :has_more false,
                                                 :total_count 0,
                                                 :url "/v1/customers/cus_AC3SKt227SZKlu/subscriptions"},
                                 :currency nil,
                                 :id "cus_AC3SKt227SZKlu",
                                 :livemode false,
                                 :shipping nil,
                                 :discount nil,
                                 :metadata {},
                                 :object "customer"}}})

(def test-error {:body "{\"error\": { \"type\": \"invalid_request_error\", \"message\": \"No such event: cus_123\", \"param\": \"id\" } }",
                 :headers {:date "Thu, 02 Mar 2017 05:55:39 GMT",
                           :request-id "req_ADDLfFNTKl7IRG",
                           :server "nginx",
                           :stripe-version "2017-01-27",
                           :cache-control "no-cache, no-store",
                           :content-length "117",
                           :access-control-max-age "300",
                           :content-type "application/json",
                           :access-control-allow-methods "GET, POST, HEAD, OPTIONS, DELETE",
                           :access-control-allow-origin "*",
                           :connection "keep-alive",
                           :access-control-allow-credentials "true"},
                 :status 404})

(def nil-res {:error {:message "Unrecognized request URL (GET: /v1/events/). Please see https://stripe.com/docs or we can help at https://support.stripe.com/."
                      :type    "invalid_request_error"}})

(deftest get!-test
  (testing "nil id"
    (is (= nil-res (events/get! nil))))

  (testing "valid get request"
    (with-redefs [request (fn [m] {:status 200 :body (json/generate-string test-event)})]
      (is (= test-event (events/get! "evt_AC3SuhOOYgjek4")))))

  (testing "error response"
    (with-redefs [request (fn [m] test-error)]
      (is (= (-> test-error :body (json/parse-string true)) (events/get! ""))))))


