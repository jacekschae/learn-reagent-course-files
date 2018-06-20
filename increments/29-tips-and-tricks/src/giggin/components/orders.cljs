(ns giggin.components.orders
  (:require [giggin.state :as state]
            [giggin.helpers :refer [format-price]]
            [giggin.components.checkout-modal :refer [checkout-modal]]))

(defn total
  []
  (->> @state/orders
       (map (fn [[id quant]]
              (if (get-in @state/gigs [id :sold-out])
                0
                (* quant (get-in @state/gigs [id :price])))))
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
         (doall (for [[id quant] @state/orders]
                  (let [gig (id @state/gigs)]
                    [:div.item {:key id}
                     [:div.img
                      [:img {:src (:img gig)
                             :alt (:title gig)}]]
                     [:div.content
                      (if (:sold-out gig)
                        [:p.sold-out "Sold out"]
                        [:p.title (:title gig) " \u00D7 " quant])]
                     [:div.action
                      (if (:sold-out gig)
                        [:div.price (format-price 0)]
                        [:div.price (format-price (* (:price gig) quant))])
                      [:button.btn.btn--link.tooltip
                       {:data-tooltip "Remove"
                        :on-click #(remove-from-order id)}
                       [:i.icon.icon--cross]]]])))]
        [:div.total
         [:hr]
         [:div.item
          [:div.content "Total"]
          [:div.action
           [:div.price (format-price (total))]]
          [:button.btn.btn--link.tooltip
           {:data-tooltip "Remove all"
            :on-click #(remove-all-orders)}
           [:i.icon.icon--delete]]]
         [checkout-modal]]])]))
