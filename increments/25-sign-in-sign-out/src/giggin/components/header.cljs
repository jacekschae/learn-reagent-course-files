(ns giggin.components.header
  (:require [giggin.fb.auth :refer [sign-in-with-google]]))

(defn header
  []
  [:header
   [:img.logo {:src "img/giggin-logo.svg" :alt "Giggin logo"}]
   [:button.btn.btn--link.float--right
    {:on-click #(sign-in-with-google)}
    "Login"]])