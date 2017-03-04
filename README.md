# tiger

Yet another clojure stripe library

## Usage

```clojure
(ns your-project.core
  (:require [tiger.core :as stripe]))
            [tiger.events :as events]
            [tiger.plans :as plans]
            [tiger.customers :as customers]
 
(stripe/set-api-key! "your api key")

; events
(events/get! "evt_id")

; plans
(plans/get! "plan_id")
(plans/create! {})
(plans/update! "plan_id" {})
(plans/delete! "plan_id")
(plans/list!)

; customers
(customers/get! "cus_id")
(customers/create! {})
(customers/update! "cus_id" {})
(customers/delete! "cus_id")
(customers/list!)
```
