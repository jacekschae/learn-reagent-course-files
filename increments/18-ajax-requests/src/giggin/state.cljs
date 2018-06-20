(ns giggin.state
  (:require [reagent.core :as r]))

(def orders (r/atom {}))

(def gigs (r/atom {:gig-01 {:id :gig-01
                            :title "Macaron"
                            :artist "Baher Khairy"
                            :desc "Sweet meringue-based rhythms with smooth and sweet injections of soul"
                            :img "https://res.cloudinary.com/schae/image/upload/f_auto,q_auto/v1519552695/giggin/baher-khairy-97645.jpg"
                            :price 1000
                            :sold-out false}
                   :gig-02 {:id :gig-02
                            :title "Stairs"
                            :artist "Brentr De Ranter"
                            :desc "Stairs to the highets peaks of music."
                            :img "https://res.cloudinary.com/schae/image/upload/f_auto,q_auto/v1519552695/giggin/brent-de-ranter-426248.jpg"
                            :price 2000
                            :sold-out false}
                   :gig-03 {:id :gig-03
                            :title "Infusion"
                            :artist "Camille Couvez"
                            :desc "Introduction of a new elements of music into modern world"
                            :img "https://res.cloudinary.com/schae/image/upload/f_auto,q_auto/v1519552695/giggin/camille-couvez-424606.jpg"
                            :price 3000
                            :sold-out false}
                   :gig-04 {:id :gig-04
                            :title "Books"
                            :artist "Cesar-Viteri"
                            :desc "A book of music, exploring different music genres across last decade"
                            :img "https://res.cloudinary.com/schae/image/upload/f_auto,q_auto/v1519552695/giggin/cesar-viteri-426877.jpg"
                            :seats 40
                            :price 4000
                            :sold-out false}
                   :gig-05 {:id :gig-05
                            :title "White"
                            :artist "Dan Schiumarini"
                            :desc "Vulnerability and humility exposed with Raps of Dan Schiumarini"
                            :img "https://res.cloudinary.com/schae/image/upload/f_auto,q_auto/v1519552695/giggin/dan-schiumarini-427769.jpg"
                            :price 5000
                            :sold-out false}
                   :gig-06 {:id :gig-06
                            :title "Hustin'"
                            :artist "Frank Cordoba"
                            :desc "Story of Hip Hop hustle by Frank Cordoba"
                            :img "https://res.cloudinary.com/schae/image/upload/f_auto,q_auto/v1519552695/giggin/frank-cordoba-425264.jpg"
                            :price 6000
                            :sold-out false}
                   :gig-07 {:id :gig-07
                            :title "Pumping"
                            :artist "Jakob Owens"
                            :desc "Get energized and ready to rock with this fresh and bright work of Jakob Owens"
                            :img "https://res.cloudinary.com/schae/image/upload/f_auto,q_auto/v1519552695/giggin/jakob-owens-393298.jpg"
                            :price 7000
                            :sold-out false}
                   :gig-08 {:id :gig-08
                            :title "Lion"
                            :artist "Jakob Puff"
                            :desc "An album of wild and brave sounds explored by Jakob Puff"
                            :img "https://res.cloudinary.com/schae/image/upload/f_auto,q_auto/v1519552695/giggin/jakob-puff-425634.jpg"
                            :price 8000
                            :sold-out false}
                   :gig-09 {:id :gig-09
                            :title "ampersand"
                            :artist "Kirstyn Paynter"
                            :desc "Connect music and words with ampersand and enjoy find out what happens next"
                            :img "https://res.cloudinary.com/schae/image/upload/f_auto,q_auto/v1519552696/giggin/kirstyn-paynter-424217.jpg"
                            :price 9000
                            :sold-out false}
                   :gig-10 {:id :gig-10
                            :title "Taxi"
                            :artist "Peter Kasprzyk"
                            :desc "Taka a Taxi ride with Peter to explore different beats of the city"
                            :img "https://res.cloudinary.com/schae/image/upload/f_auto,q_auto/v1519552696/giggin/peter-kasprzyk-111462.jpg"
                            :price 9000
                            :sold-out false}
                   :gig-11 {:id :gig-11
                            :title "Plaza De La Juderia"
                            :artist "Quino Al"
                            :desc "Spanish rhythms from Plaza De La Juderia"
                            :img "https://res.cloudinary.com/schae/image/upload/f_auto,q_auto/v1519552696/giggin/quino-al-427620.jpg"
                            :price 9000
                            :sold-out false}
                   :gig-12 {:id :gig-12
                            :title "Girl"
                            :artist "Shine Tang"
                            :desc "Shine Tang offers a grand exploration of classical music"
                            :img "https://res.cloudinary.com/schae/image/upload/f_auto,q_auto/v1519552696/giggin/shine-tang-425878.jpg"
                            :price 9000
                            :sold-out false}}))
