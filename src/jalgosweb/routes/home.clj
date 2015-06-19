(ns jalgosweb.routes.home
  (:require [compojure.core :refer :all]
            [jalgosweb.layout :as layout]
            [jalgosweb.util :as util]
            [jalgosweb.db.core :as db]))

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

(defn references-page []
  (layout/render
    "references.html"))

(defn career-page []
  (layout/render
    "career.html"))





(defn fr-page []
  (layout/render "fr/home_fr.html"))

(defn fr-about-page []
  (layout/render
    "fr/about_fr.html"))

(defn fr-usecases-page []
  (layout/render
    "fr/usecases_fr.html"))

(defn fr-contact-page []
  (layout/render
    "fr/contact_fr.html"))

(defn fr-references-page []
  (layout/render
    "fr/references_fr.html"))

(defn fr-career-page []
  (layout/render
    "fr/career_fr.html"))



(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/usecases" [] (usecases-page))  
  (GET "/contact" [] (contact-page))
  (GET "/references" [] (references-page))
  (GET "/career" [] (career-page))

  (GET "/fr" [] (fr-page))
  (GET "/about-fr" [] (fr-about-page))
  (GET "/usecases-fr" [] (fr-usecases-page))  
  (GET "/contact-fr" [] (fr-contact-page))
  (GET "/references-fr" [] (fr-references-page))
  (GET "/career-fr" [] (fr-career-page)))
