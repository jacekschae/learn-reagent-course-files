(ns giggin.fb.db
  (:require ["firebase/app" :refer [database]]
            [clojure.string :as str]))

(defn db-ref
  [path]
  (.ref (database) (str/join "/" path)))

(defn db-save!
  [path value]
  (.set (db-ref path) value))
