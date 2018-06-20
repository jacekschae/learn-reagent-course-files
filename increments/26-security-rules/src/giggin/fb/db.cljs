(ns giggin.fb.db
  (:require ["firebase/app" :refer [database]]
            [clojure.string :as str]
            [giggin.state :as state]))

(defn db-ref
  [path]
  (.ref (database) (str/join "/" path)))

(defn db-save!
  [path value]
  (.set (db-ref path) value))

; var starCountRef = firebase.database().ref('posts/' + postId + '/starCount');
; starCountRef.on('value', function(snapshot) {
;   updateStarCount(postElement, snapshot.val());
; });
(defn db-subscribe
  [path]
  (.on (db-ref path)
       "value"
       (fn [snapshot]
         (reset! state/gigs (js->clj (.val snapshot) :keywordize-keys true)))))
