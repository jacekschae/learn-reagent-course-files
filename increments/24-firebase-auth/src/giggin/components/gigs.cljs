(ns giggin.components.gigs
  (:require [giggin.state :as state]
            [giggin.helpers :refer [format-price]]
            [giggin.components.gig-editor :refer [gig-editor]]
            [reagent.core :as r]
            [clojure.string :as str]
            [giggin.fb.db :refer [db-save!]]))

(defn gigs
  []
  (let [modal (r/atom {:active false})
        initial-values {:id nil :title "" :desc "" :price 0 :img "" :sold-out false}
        values (r/atom initial-values)
        add-to-order #(swap! state/orders update (keyword %) inc)
        toggle-modal (fn
                       [{:keys [active gig]}]
                       (swap! modal assoc :active active)
                       (reset! values gig))
        upsert-gig (fn [{:keys [id title desc price img sold-out]}]
                     (let [id (or id (str "gig-" (random-uuid)))]
                       (db-save! ["gigs" id] #js {:id id
                                                  :title (str/trim title)
                                                  :desc (str/trim desc)
                                                  :img (str/trim img)
                                                  :price (js/parseInt price)
                                                  :sold-out sold-out}))
                     (toggle-modal {:active false :gig initial-values}))]
    (fn
      []
      [:main
       [:div.gigs
        [:button.add-gig
         {:on-click #(toggle-modal {:active true :gig initial-values})}
         [:div.add__title
          [:i.icon.icon--plus]
          [:p "Add gig"]]]
        [gig-editor {:modal modal
                     :values values
                     :upsert-gig upsert-gig
                     :toggle-modal toggle-modal
                     :initial-values initial-values}]
        (for [{:keys [id img title price desc sold-out] :as gig} (vals @state/gigs)]
          [:div.gig {:key id}
           [:img.gig__artwork.gig__edit {:src img
                                         :alt title
                                         :on-click #(toggle-modal {:active true
                                                                   :gig gig})}]
           [:div.gig__body
            [:div.gig__title
             (if sold-out
               [:div.sold-out.float--right "Soldout"]
               [:div.btn.btn--primary.float--right.tooltip
                {:data-tooltip "Add to order"
                 :on-click #(add-to-order id)}
                [:i.icon.icon--plus]])
             title]
            [:p.gig__price (format-price price)]
            [:p.gig__desc desc]]])]])))
