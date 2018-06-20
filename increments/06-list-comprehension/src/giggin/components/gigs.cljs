(ns giggin.components.gigs
  (:require [giggin.state :as state]))

(defn gigs
  []
  [:main
   [:div.gigs (map (fn [gig]
                     [:div.gig {:key (:id gig)}
                      [:img.gig__artwork {:src (:img gig) :alt (:title gig)}]
                      [:div.gig__body
                       [:div.gig__title
                        [:div.btn.btn--primary.float--right.tooltip {:data-tooltip "Add to order"}
                         [:i.icon.icon--plus]] (:title gig)]
                       [:p.gig__price (:price gig)]
                       [:p.gig__desc (:desc gig)]]]) (vals @state/gigs))]])