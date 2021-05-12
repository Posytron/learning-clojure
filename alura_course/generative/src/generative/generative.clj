(ns generative.generative
  (:gen-class)
  (:require [clojure.test.check.generators :as gen]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(gen/sample gen/boolean)
;; => (false true true false true true false true true false)

(gen/sample gen/boolean 4)
;; => (false false false false)

(gen/sample gen/int)
;; => (0 -1 2 1 3 -3 -3 2 -3 1)

(gen/sample gen/string)
;; => ("" "" "ë-" "" "/Ï©" " \fYä" "¼jÞ=ä" "©æòZ" "ÒçÀà" "Éqï")

(gen/sample gen/string-alphanumeric)
;; => ("" "4" "gJ" "V9" "2O1x" "MG6iH" "wx" "3W" "2A4" "0B7J7")

(gen/sample gen/keyword)
;; => (:. :N :Vl :+ :U :*1Y :La :?AB7 :+q :j.+!)

(gen/sample gen/char)
;; => (\ \G \è \Ç \á \@ \Ô \Y \W \)

(gen/sample gen/bytes)
;; => ([]
;;     [112]
;;     []
;;     []
;;     [-32, 96, -68]
;;     [35, -108, -57, -61, -66]
;;     [20, -122, -22, -60, -23]
;;     [90, 119]
;;     [-50, 68, -73, -116, -76, 99, -13, 48]
;;     [5, 49, 32, 42])

(gen/sample (gen/vector gen/small-integer))
;; => ([] [] [] [3 -1] [4 2] [3 -5] [-2 -1 0 -4 -6 0] [3] [3 -1 -8 6] [2 -6 8 4 9 5 0 0])

(gen/sample (gen/vector gen/large-integer))
;; => ([] [] [0] [-1] [1 -1 0 -1] [-1] [] [4] [-21 -6] [])

(gen/sample (gen/vector gen/keyword 5) 5)
;; => ([:+ :N :? :n :*] [:J! :!- :- :+Q :?B] [:r_ :W :! :eP :M] [:_3 :? :+_ :I9 :L] [:y-? :NN+ :tw :y :/])

(gen/sample (gen/vector gen/large-integer 4) 4)
;; => ([0 -1 -1 -1] [-1 -1 -1 0] [-1 -1 0 0] [-3 1 0 -4])
