(ns tiger.events-test
  (:require [clojure.test :refer :all]
            [tiger.core :as stripe]
            [tiger.events :as events]
            [tiger.fixtures :as fixtures]))

(use-fixtures :once fixtures/set-key!)

(deftest test-get!
  (testing "nil id"
      (is (= "invalid_request_error" (-> nil events/get! :error :type))))

  (testing "valid get request"
      (is (= true (-> "evt_AC3SuhOOYgjek4" events/get! events/event?)))))

