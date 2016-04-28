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
