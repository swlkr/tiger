(ns tiger.events-test
  (:require [clojure.test :refer :all]
            [tiger.core :as stripe]
            [tiger.events :as events]
            [tiger.fixtures :as fixtures]
            [vcr-clj.core :refer [with-cassette]]))

(use-fixtures :once fixtures/set-key!)

(deftest test-get!
  (testing "nil id"
    (with-cassette :events/test-nil-get! [{:var #'tiger.http/send!}]
      (is (= "invalid_request_error" (-> nil events/get! :error :type)))))

  (testing "valid get request"
    (with-cassette :events/test-valid-get! [{:var #'tiger.http/send!}]
      (is (= true (-> "evt_AC3SuhOOYgjek4" events/get! events/event?))))))

