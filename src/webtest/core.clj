(ns webtest.core
  (:require [ring.adapter.jetty :as ring.jetty]))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello World"})

(defn start [] (ring.jetty/run-jetty handler {:port  3000
                                              :join? false}))

(defn -main [& args] (start))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
