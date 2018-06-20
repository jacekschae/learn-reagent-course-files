(ns giggin.components.orders
  (:require [giggin.state :as state]
            [giggin.helpers :refer [format-price]]))

(defn total
  []
  (->> @state/orders
       (map (fn [[id quant]] (* quant (get-in @state/gigs [id :price]))))
       (reduce +)))

(defn orders
  []
  (let [remove-from-order #(swap! state/orders dissoc %)
        remove-all-orders #(reset! state/orders {})]
    [:aside
     (if (empty? @state/orders)
       [:div.empty
        [:div.title "You don't have any orders"]
        [:div.subtitle "Click on a + to add an order"]]
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
             [:div.price (format-price (* (get-in @state/gigs [id :price]) quant))]
             [:button.btn.btn--link.tooltip
              {:data-tooltip "Remove"
               :on-click #(remove-from-order id)}
              [:i.icon.icon--cross]]]])]
        [:div.total
         [:hr]
         [:div.item
          [:div.content "Total"]
          [:div.action
           [:div.price (format-price (total))]]
          [:button.btn.btn--link.tooltip
           {:data-tooltip "Remove all"
            :on-click #(remove-all-orders)}
           [:i.icon.icon--delete]]]]])]))
