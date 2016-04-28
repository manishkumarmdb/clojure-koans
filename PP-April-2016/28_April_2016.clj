(ns first-01.28_April_2016)

(inc 783)

(first [2 3 54 67])

(defn add? [a b]
  (+ a b))

(type :abcd)

(first [3 5 6 5 234])

(rest [453 6 765 424 234])

(cons 1 [5])
(cons 4 [45 32 67])
(cons 56 '(23 34 5 6))

(defn inc-first [nums]
  (cons (inc (first nums))
        (rest nums)))
(inc-first [34 54 23 65])

(if true :a :b)
(if false :a :b)

(defn inc-second? [nums]
  (if (first nums)
    (cons (inc (first nums))
          (rest nums))
    (list)))

(defn inc-more [nums]
  (if (first nums)
    (cons (inc (first nums))
          (inc-more (rest nums)))
    (lits)))

(map (fn [name] (str "Hi, " name))
     ["abcdfs" "ergtrth"])
((fn [x] (* x 5)) 7)

(#(* % 3) 8)

(#(str %1 " and " %2) "bvsd" "sdfb")

(#(identity %&) 1 "abcd" :yip)

(defn transform-all [f xs]
  (if (first xs)
    (cons (f (first xs))
          transform-all f (rest xs)))
  (list))
(transform-all inc [4 65 74 3])
