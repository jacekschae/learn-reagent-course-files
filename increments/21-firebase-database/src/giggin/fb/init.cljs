(ns giggin.fb.init
  (:require ["firebase/app" :as firebase]
            ["firebase/database"]
            ["firebase/auth"]))

(defn firebase-init
  []
  (firebase/initializeApp
   {:apiKey "your-api-key"
    :authDomain "your-auth-domain"
    :databaseURL "your-databse-url"
    :projectId "your-project-id"}))
