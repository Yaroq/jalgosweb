(ns jalgosweb.routes.home
  (:require [compojure.core :refer :all]
            [jalgosweb.layout :as layout]
            [jalgosweb.util :as util]))

(defn home-page []
  (layout/render
    "home.html"))

(defn about-page []
  (layout/render
    "about.html"))

(defn usecases-page []
  (layout/render
    "usecases.html"))

(defn contact-page []
  (layout/render
    "contact.html"))



(defn fr-page []
  (layout/render "home_fr.html"))

(defn fr-about-page []
  (layout/render
    "about_fr.html"))

(defn fr-usecases-page []
  (layout/render
    "usecases_fr.html"))

(defn fr-contact-page []
  (layout/render
    "contact_fr.html"))


(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/usecases" [] (usecases-page))  
  (GET "/contact" [] (contact-page))

  (GET "/fr" [] (fr-page))
  (GET "/about-fr" [] (fr-about-page))
  (GET "/usecases-fr" [] (fr-usecases-page))  
  (GET "/contact-fr" [] (fr-contact-page))
)
