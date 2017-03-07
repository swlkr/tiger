(ns tiger.plans-test
  (:require [clojure.test :refer :all]
            [tiger.plans :refer :all]
            [tiger.fixtures :as fixtures]
            [vcr-clj.core :refer [with-cassette]])
  (:refer-clojure :exclude [list?]))

(use-fixtures :each fixtures/set-key!)

(deftest test-create!
  (with-cassette :plans/test-create! [{:var #'tiger.http/send!}]
    (is (true? (plan? (create! {:id "plan-id" :amount 4999 :interval "month" :name "plan-name" :currency "usd"}))))))

(deftest test-list!
  (with-cassette :plans/test-list! [{:var #'tiger.http/send!}]
    (testing "list response"
      (is (= true (list? (list!)))))

    (testing "list contents"
      (is (= 1 (-> (list!) :data count))))))

(deftest test-get!
  (with-cassette :plans/test-get! [{:var #'tiger.http/send!}]
    (is (= true (plan? (get! "plan-id"))))))

(deftest test-update!
  (with-cassette :plans/test-update! [{:var #'tiger.http/send!}]
    (is (= "hello world" (-> (update! "plan-id" {:name "hello world"}) :name)))))

(deftest test-delete!
  (with-cassette :plans/test-delete! [{:var #'tiger.http/send!}]
    (is (= {:deleted true :id "plan-id"} (delete! "plan-id")))))
