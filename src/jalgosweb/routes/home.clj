(ns jalgosweb.routes.home
  (:require [compojure.core :refer :all]
            [jalgosweb.layout :as layout]
            [jalgosweb.util :as util]))

(defn home-page []
  (layout/render
    "home.html"))

(defn about-page []
  (layout/render "about.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page)))
