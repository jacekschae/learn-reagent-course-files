(ns giggin.fb.init
  (:require ["firebase/app" :as firebase]
            ["firebase/database"]
            ["firebase/auth"]
            [giggin.fb.auth :refer [on-auth-state-changed]]))

(defn firebase-init
  []
  (firebase/initializeApp
   #js {:apiKey "your-api-key"
        :authDomain "your-auth-domain"
        :databaseURL "your-database-url"
        :projectId "your-project-id"})
  (on-auth-state-changed))
