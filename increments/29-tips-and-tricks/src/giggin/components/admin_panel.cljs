(ns giggin.components.admin-panel
  (:require [giggin.state :as state]
            [giggin.fb.db :refer [db-save!]]))

(defn admin-panel
  []
  [:div.admin-panel
   [:button.btn.btn--primary
    {:styles {:width "100%"}
     :on-click #(db-save! ["gigs"] (clj->js @state/gigs))}
    "Publish"]])
