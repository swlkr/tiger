{:calls [{:var-name "tiger.http/send!", :arg-key [{:url "https://api.stripe.com/v1/plans", :headers {"Authorization" "Bearer sk_test_U5NGYnt3J2oI6I82Pyosf6eq"}, :method :post, :form-params {"id" "plan-id", "amount" 4999, "interval" "month", "name" "plan-name", "currency" "usd"}}], :return {:opts {:url "https://api.stripe.com/v1/plans", :headers {"Authorization" "Bearer sk_test_U5NGYnt3J2oI6I82Pyosf6eq"}, :method :post, :form-params {"id" "plan-id", "amount" 4999, "interval" "month", "name" "plan-name", "currency" "usd"}}, :body "{\n  \"id\": \"plan-id\",\n  \"object\": \"plan\",\n  \"amount\": 4999,\n  \"created\": 1488860419,\n  \"currency\": \"usd\",\n  \"interval\": \"month\",\n  \"interval_count\": 1,\n  \"livemode\": false,\n  \"metadata\": {},\n  \"name\": \"plan-name\",\n  \"statement_descriptor\": null,\n  \"trial_period_days\": null\n}\n", :headers {:date "Tue, 07 Mar 2017 04:20:19 GMT", :request-id "req_AF3vDUJJpvW1fk", :server "nginx", :stripe-version "2017-02-14", :cache-control "no-cache, no-store", :content-length "275", :strict-transport-security "max-age=31556926; includeSubDomains", :access-control-max-age "300", :content-type "application/json", :access-control-allow-methods "GET, POST, HEAD, OPTIONS, DELETE", :access-control-allow-origin "*", :connection "keep-alive", :access-control-allow-credentials "true"}, :status 200}}]}