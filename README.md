# tiger

Yet another clojure stripe library

## Usage

```bash
lein plz tiger
```

or

```clojure
; add the following to :dependencies in your project.clj
[tiger "1.0.1"]
```

```clojure
(ns your-project.core
  (:require [tiger.core :as stripe]))
            [tiger.events :as events]
            [tiger.plans :as plans]
            [tiger.customers :as customers]
            [tiger.subscriptions :as subscriptions]
 
(stripe/set-api-key! "your api key")

; events
(events/get! "evt_id")

; plans
(plans/get! "plan_id")
(plans/create! {:id "plan-id" :amount 4999 :interval "month" :name "plan-name" :currency "usd"})
(plans/update! "plan_id" {:name "hello world"})
(plans/delete! "plan_id")
(plans/list!)

; customers
(customers/get! "cus_id")
(customers/create! {:email "customer@example.com"})
(customers/update! "cus_id" {:email "customer1@example.com"})
(customers/delete! "cus_id")
(customers/list!)

; subscriptions
(subscriptions/get! "sub_id")
(subscriptions/create! {:customer "cus_id" :plan "plan-id"})
(subscriptions/update! "sub_id" {:quantity 10})
(subscriptions/delete! "sub_id")
(subscriptions/list!)

```
