(ns giggin.fb.auth
  (:require ["firebase/app" :as firebase]
            [giggin.fb.db :refer [db-save!]]
            [giggin.state :as state]))

(defn sign-in-with-google
  []
  (let [provider (firebase/auth.GoogleAuthProvider.)]
    (.signInWithPopup (firebase/auth) provider)))

(defn sign-out
  []
  (.signOut (firebase/auth)))

(defn on-auth-state-changed
  []
  (.onAuthStateChanged
   (firebase/auth)
   (fn
     [user]
     (if user
       (let [uid (.-uid user)
             display-name (.-displayName user)
             photo-url (.-photoURL user)
             email (.-email user)]
         (do
           (reset! state/user {:photo-url photo-url
                               :display-name display-name
                               :email email})
           (db-save!
            ["users" uid "profile"]
            #js {:photo-url photo-url
                 :display-name display-name
                 :email email})))
       (reset! state/user nil)))))
