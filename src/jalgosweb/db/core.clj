(ns jalgosweb.db.core
    (:require [monger.core :as mg]
              [monger.collection :as mc]
              [monger.operators :refer :all]
              [monger.conversion :refer [from-db-object]]))


(defonce db
  (let [conn (mg/connect)
        db (mg/get-db conn "ufc")]
        db))

(comment (defonce db 
  (let [conn (mg/connect)
        db   (mg/get-db conn "news")
        u    "moustik"
        p    (.toCharArray "jaimelenlp101")]
    (mg/authenticate db u p)
    db)))

  
(defn articles []
 (mc/find-maps db "fights"))

(defn create-user [user]
  (mc/insert db "users" user))

(defn update-user [id first-name last-name email]
  (mc/update db "users" {:id id}
             {$set {:first_name first-name
                    :last_name last-name
                    :email email}}))

(defn get-user [id]
  (mc/find-one-as-map db "users" {:id id}))
