(ns first-01.29-April-2016
  (:require [clojure.set :as set]))


(keyword (str *ns*) "any-keyword-name")

(defn transform-all [f xs]
  (if (first xs)
    (cons (f (first xs))
          (transform-all f (rest xs)))
    (list)))

(transform-all inc [1 2 3 5])
(transform-all keyword ["bell" "hooks"])
(transform-all list [:codex :book :manuscript])
(map inc [4 6 7 3])


(defn expand [f x count]
  (if (pos? count)
    (cons x (expand f (f x) (dec count)))))

(expand inc 7 12)
(expand dec 23 8)

(take 10 (iterate inc 2))

(take 10 (iterate (fn [x] (if (odd? x) (+ 1 x) (/ x 2))) 23))

(take 7 (iterate (fn [x] (str x "adi")) "mani"))

(take 10 (iterate (partial + 2) 2))

(take 6 (repeat :hi-adi))
(repeat 4 :hello-keyword)
(repeat 4 "hello-string")
(repeat 4 'hello-symbol)

(rand)

(rand 34)

(take 3 (repeatedly rand))
(take 4 (repeatedly #(rand-int 18)))
(repeatedly 5 #(rand-int 11))

(rand-int 23)

(require '[clojure.set :as set])

(defn unique-random-numbers [n]
  (let [a-set (set (take n (repeatedly #(rand-int n))))]
    (concat a-set (set (set/difference (take n (range))) a-set))))

(unique-random-numbers 20)

(range 5)

(range 2 10)

(range 6 60 7)

(take 13 (cycle [2 4 7 9]))

(map (fn [n vehicle] (str "I've got " n " " vehicle "s"))
     [0 200 9]
     ["car" "train" "kiteboard"])
;;("I've got 0 cars" "I've got 200 trains" "I've got 9 kiteboards")

(map + [1 2 3]
     [4 5 6]
     [7 8 9])

(map (fn [index element] (str index ". " element))
     (iterate inc 0)
     ["erlang" "ruby" "haskell"])
;;("0. erlang" "1. ruby" "2. haskell")

(map-indexed (fn [index element] (str index ". " element))
             ["erlang" "ruby" "haskell"])
;;("0. erlang" "1. ruby" "2. haskell")

(concat [1 2 3] [:a :b :c] [4 5 6])

(interleave [:a :b :c] [1 2 3])

(interpose :and [1 2 3 4])

(reverse [1 2 3])

(reverse "woolf")

(apply str (reverse "woolf"))

(seq "sato")

(shuffle [1 2 3 4])

(apply str (shuffle (seq "abracadabra")))

(map inc [1 2 3 4 5])

(map + [1 2 3] [4 5 6])

(map + [1 2 3] (iterate inc 1))

(map #(str "Hello " % "!" ) ["Ford" "Arthur" "Tricia"])

;;below both are equivalent
(map vector [:a :b :c] [:d :e :f] [:g :h :i])

(apply map vector [[:a :b :c]
                   [:d :e :f]
                   [:g :h :i]])

;;
(map #(vector (first %) (* 2 (second %)))
     {:a 1 :b 2 :c 3})

(map {2 "two" 3 "three"} [5 3 2])

(filter identity (map {2 "two" 3 "three"} [5 3 2]))
