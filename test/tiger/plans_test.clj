(ns tiger.plans-test
  (:require [clojure.test :refer :all]
            [tiger.plans :as plans]
            [tiger.fixtures :as fixtures]))

(use-fixtures :each fixtures/set-key!)

(deftest test-list!
  (is (= true (plans/list? (plans/list!)))))

(deftest test-get!
  (let [id "D9DB87B7-4F45-4D46-AEF6-7D7634CA807B"
        plan (plans/get! id)]
    (is (plans/plan? plan))))
