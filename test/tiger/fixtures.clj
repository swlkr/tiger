(ns tiger.fixtures
  (:require [tiger.core :as stripe]
            [environ.core :refer [env]]))

(defn set-key! [f]
  (stripe/set-api-key! (env :api-key))
  (f))
