(ns giggin.fb.init
  (:require ["firebase/app" :as firebase]
            ["firebase/database"]
            ["firebase/auth"]
            [giggin.fb.auth :refer [on-auth-state-changed]]))

(defn firebase-init
  []
  (if (zero? (alength firebase/apps))
    (firebase/initializeApp
     #js {:apiKey "your-api-key"
          :authDomain "your-auth-domain"
          :databaseURL "your-database-url"
          :projectId "your-project-id"})
    (firebase/app))
  (on-auth-state-changed))
