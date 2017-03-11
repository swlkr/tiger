(ns tiger.subscriptions-test
  (:require [clojure.test :refer :all]
            [tiger.subscriptions :as subscriptions]
            [tiger.fixtures :as fixtures]
            [vcr-clj.core :refer [with-cassette]]))

(use-fixtures :once fixtures/set-key!)

(deftest create!
  (with-cassette :subscriptions/create! [{:var #'tiger.http/send!}]
    (is (= true (subscriptions/subscription? (subscriptions/create! {:customer "cus_AC3znPOHfvP2Mg"
                                                                     :plan "plan-id"}))))))

(deftest get!
  (with-cassette :subscriptions/get! [{:var #'tiger.http/send!}]
    (is (= true (-> "sub_AGZbR3MgZEvAfk" subscriptions/get! subscriptions/subscription?)))))

(deftest update!
  (with-cassette :subscriptions/update! [{:var #'tiger.http/send!}]
    (is (= 2 (-> (subscriptions/update! "sub_AGZbR3MgZEvAfk" {:quantity 2}) :quantity)))))

(deftest list!
  (with-cassette :subscriptions/list! [{:var #'tiger.http/send!}]
     (is (= true (-> (subscriptions/list!) :data first subscriptions/subscription?)))))

(deftest delete!
  (with-cassette :subscriptions/delete! [{:var #'tiger.http/send!}]
    (is (= "canceled" (-> (subscriptions/delete! "sub_AGZbR3MgZEvAfk") :status)))))
