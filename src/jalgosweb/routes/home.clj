(ns jalgosweb.routes.home
  (:require [compojure.core :refer :all]
            [jalgosweb.layout :as layout]
            [jalgosweb.util :as util]))

(defn home-page []
  (layout/render
    "home.html"))

(defn fr-page []
  (layout/render "fr/home.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/fr" [] (fr-page)))
