(ns giggin.state
  (:require [reagent.core :as r]))

(def orders (r/atom {}))

(def gigs (r/atom {}))

(def user (r/atom nil))
