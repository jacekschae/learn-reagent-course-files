(ns giggin.components.gigs
  (:require [giggin.state :as state]
            [giggin.helpers :refer [format-price]]
            [giggin.components.gig-editor :refer [gig-editor]]
            [reagent.core :as r]
            [clojure.string :as str]))

(defn gigs
  []
  (let [modal (r/atom {:active false})
        values (r/atom {:id nil :title "" :desc "" :price 0 :img "" :sold-out false})
        add-to-order #(swap! state/orders update % inc)
        toggle-modal (fn
                       [{:keys [active gig]}]
                       (swap! modal assoc :active active)
                       (reset! values gig))
        upsert-gig (fn [{:keys [id title desc price img sold-out]}]
                     (swap! state/gigs assoc id {:id (or id (str "gig-" (random-uuid)))
                                                 :title (str/trim title)
                                                 :desc (str/trim desc)
                                                 :img (str/trim img)
                                                 :price (js/parseInt price)
                                                 :sold-out sold-out})
                     (toggle-modal {:active false :gig {}}))]
    (fn
      []
      [:main
       [:div.gigs
        [:button.add-gig
         {:on-click #(toggle-modal {:active true :gig {}})}
         [:div.add__title
          [:i.icon.icon--plus]
          [:p "Add gig"]]]
        [gig-editor modal values upsert-gig toggle-modal]
        (for [{:keys [id img title price desc] :as gig} (vals @state/gigs)]
          [:div.gig {:key id}
           [:img.gig__artwork.gig__edit {:src img
                                         :alt title
                                         :on-click #(toggle-modal {:active true
                                                                   :gig gig})}]
           [:div.gig__body
            [:div.gig__title
             [:div.btn.btn--primary.float--right.tooltip
              {:data-tooltip "Add to order"
               :on-click #(add-to-order id)}
              [:i.icon.icon--plus]] title]
            [:p.gig__price (format-price price)]
            [:p.gig__desc desc]]])]])))
