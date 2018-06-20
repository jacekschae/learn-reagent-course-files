(ns giggin.core
  (:require [reagent.core :as r]))

(defn app
  []
  [:div.container])

(defn ^:export main
  []
  (r/render
    [app]
    (.getElementById js/document "app")))
