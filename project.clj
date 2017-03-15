(defproject tiger "1.0.2"
  :description "Yet another stripe library for clojure"
  :url "https://github.com/swlkr/tiger"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.2.0"]
                 [cheshire "5.7.0"]
                 [environ "1.1.0"]
                 [com.gfredericks/vcr-clj "0.4.9"]
                 [org.clojure/tools.namespace "0.2.11"]]
  :main tiger.core
  :plugins [[lein-environ "1.1.0"]]
  :profiles {:uberjar {:aot :all}})
