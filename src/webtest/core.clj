(ns webtest.core
  (:require [ring.adapter.jetty :as ring-jetty]
            [reitit.ring :as ring]
            [muuntaja.core :as m]
            [reitit.ring.middleware.muuntaja :as muuntaja])
  (:gen-class))

(defn string-handler [_]
  {:status 200
   :body "on the code again"})

(def app
  (ring/ring-handler
    (ring/router
      ["/"
       ["" {:get string-handler}]
       ["math" (:post string-handler)]]
      {:data {:muuntaja   m/instance
              :middleware [muuntaja/format-middleware]}})))


(defn start [] (ring-jetty/run-jetty app {:port  3000
                                              :join? false}))

(defn -main [& args] (start))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
