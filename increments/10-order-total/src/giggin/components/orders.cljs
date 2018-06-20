(ns giggin.components.orders
  (:require [giggin.state :as state]))

(defn orders
  []
  [:aside
   [:div.order
    [:div.body
     (for [[id quant] @state/orders]
       [:div.item {:key id}
        [:div.img
         [:img {:src (get-in @state/gigs [id :img])
                :alt (get-in @state/gigs [id :title])}]]
        [:div.content
         [:p.title (str (get-in @state/gigs [id :title]) " \u00D7 " quant)]]
        [:div.action
         [:div.price (* (get-in @state/gigs [id :price]) quant)]
         [:button.btn.btn--link.tooltip
          {:data-tooltip "Remove"
           :on-click (fn [] (swap! state/orders dissoc id))}
          [:i.icon.icon--cross]]]])]]])
