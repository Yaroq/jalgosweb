(ns jalgosweb.db.core
    (:require [monger.core :as mg]
              [monger.collection :as mc]
              [monger.operators :refer :all]
              [monger.conversion :refer [from-db-object]]))


(defn db [] 
  (let [conn (mg/connect))
        db   (mg/get-db conn "news")
        u    "moustik"
        p    (.toCharArray "jaimelenlp101")]
    (mg/authenticate db u p)))

  
(defn articles []
 (str (db)))
