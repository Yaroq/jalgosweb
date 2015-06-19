(defproject
  jalgosweb
  "0.1.0-SNAPSHOT"
  :description
  "FIXME: write description"
  :url
  "http://example.com/FIXME"
  :dependencies
  [[ring-server "0.3.1"]
   [noir-exception "0.2.3"]
   [environ "1.0.0"]
   [com.taoensso/timbre "3.3.1"]
   [markdown-clj "0.9.58" :exclusions [com.keminglabs/cljx]]
   [org.clojure/clojure "1.6.0"]
   [com.taoensso/tower "3.0.2"]
   [log4j
    "1.2.17"
    :exclusions
    [javax.mail/mail
     javax.jms/jms
     com.sun.jdmk/jmxtools
     com.sun.jmx/jmxri]]
   [http-kit "2.1.19"]
   [prone "0.8.0"]
   [im.chit/cronj "1.4.3"]
   [selmer "0.7.7"]
   [lib-noir "0.9.5"]
   [com.novemberain/monger "2.0.0"]]
  :repl-options
  {:init-ns jalgosweb.repl}
  :jvm-opts
  ["-server"]
  :plugins
  [[lein-ring "0.9.0"]
   [lein-environ "1.0.0"]
   [lein-ancient "0.5.5"]
   [lein-cucumber "1.0.2"]]
  :ring
  {:handler jalgosweb.handler/app,
   :init jalgosweb.handler/init,
   :destroy jalgosweb.handler/destroy,
   :uberwar-name "jalgosweb.war"}
  :profiles
  {:uberjar {:omit-source true, :env {:production true}, :aot :all},
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}},
   :dev
   {:dependencies
    [[pjstadig/humane-test-output "0.6.0"]
     [org.clojure/core.cache "0.6.3"]
     [ring/ring-devel "1.3.2"]
     [clj-webdriver/clj-webdriver "0.6.1"]
     [ring-mock "0.1.5"]],
    :injections
    [(require 'pjstadig.humane-test-output)
     (pjstadig.humane-test-output/activate!)],
    :env {:dev true}}}
  :cucumber-feature-paths
  ["test/features/"]
  :main
  jalgosweb.core
  :uberjar-name
  "jalgosweb.jar"
  :min-lein-version "2.0.0")
