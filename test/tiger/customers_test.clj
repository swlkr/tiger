(ns tiger.customers-test
  (:require [clojure.test :refer :all]
            [tiger.customers :as customers]
            [tiger.fixtures :as fixtures]
            [vcr-clj.core :refer [with-cassette]]))

(use-fixtures :once fixtures/set-key!)

(deftest create!
  (with-cassette :customers/create! [{:var #'tiger.http/send!}]
    (is (= true (customers/customer? (customers/create! {:email "new-customer@example.com"}))))))

(deftest get!
  (with-cassette :customers/get! [{:var #'tiger.http/send!}]
    (is (= true (-> "cus_AFQw5kDgoqexoN" customers/get! customers/customer?)))))

(deftest update!
  (with-cassette :customers/update! [{:var #'tiger.http/send!}]
    (is (= "new-customer1@example.com" (-> "cus_AFQw5kDgoqexoN" (customers/update! {:email "new-customer1@example.com"}) :email)))))

(deftest list!
  (with-cassette :customers/list! [{:var #'tiger.http/send!}]
    (is (= true (-> (customers/list!) :data first customers/customer?)))))

(deftest delete!
  (with-cassette :customers/delete! [{:var #'tiger.http/send!}]
    (is (= {:deleted true :id "cus_AFQw5kDgoqexoN"} (customers/delete! "cus_AFQw5kDgoqexoN")))))
