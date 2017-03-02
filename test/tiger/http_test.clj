(ns tiger.http-test
  (:require [clojure.test :refer :all]
            [tiger.http :refer :all]
            [tiger.core :as stripe])
  (:refer-clojure :exclude [get]))

(deftest make-url-test
  (testing "nil"
    (is (= "" (make-url nil))))

  (testing "valid value"
    (is (= "hello/world" (make-url "hello/world"))))

  (testing "valid url"
    (is (= "https://api.stripe.com/v1/" (make-url "https://api.stripe.com/v1/"))))

  (testing "double slash after protocol"
    (is (= "https://api.com/hello" (make-url "https://api.com//hello")))))

(deftest req-body-test
  (testing "nil"
    (is (= {:body ""} (req-body nil))))

  (testing "random key"
    (is (= {:body ""} (req-body {:hello nil}))))

  (testing "body"
    (is (= {:body "{\"hello\":\"world\"}"} (req-body {:body {:hello "world"}}))))

  (testing "form-params"
    (is (= {:form-params {"hello" "world"}} (req-body {:form-params {:hello "world"}})))))

(deftest req-test
  (let [headers {"Authorization" "Bearer api-key"}
        _ (stripe/set-api-key! "api-key")]
    (testing "nils"
      (is (= {:url "https://api.stripe.com/v1/" :method nil :headers headers} (req nil nil))))

    (testing "2nd arity nils"
      (is (= {:url "https://api.stripe.com/v1/" :method nil :headers headers :body ""} (req nil nil nil))))

    (testing "valid get request"
      (is (= {:url "https://api.stripe.com/v1/hello" :method :get :headers headers} (get "/hello"))))

    (testing "valid post request"
      (is (= {:url "https://api.stripe.com/v1/hello"
              :method :post
              :headers headers
              :body "{\"hello\":\"world\"}"} (post "/hello" {:body {:hello "world"}}))))

    (testing "valid post request with form-data"
      (is (= {:url "https://api.stripe.com/v1/hello"
              :method :post
              :headers headers
              :form-params {"hello" "world"}} (post "/hello" {:form-params {:hello "world"}}))))))


