(ns jalgosweb.db.core
    (:require [monger.core :as mg]
              [monger.collection :as mc]
              [monger.operators :refer :all]
              [monger.conversion :refer [from-db-object]]))
