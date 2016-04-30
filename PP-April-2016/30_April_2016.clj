(ns first-01.30-April-2016)

(use '[clojure.set :only (index)])

(def weights #{ {:name 'betsy :weight 1000}
               {:name 'jake :weight 756}
               {:name 'shyq :weight 1000} })

(def by-weight (index weights [:weight]))

by-weight

(get by-weight {:weight 756})

(get by-weight {:weight 1000})

(count (get by-weight {:weight 1000}))

(concat [3 5 7 2] [9 7 6 10])

(into [] (concat [1 2 3 4 5] [8 4 5 8]))

(concat [:a :b] nil [1 [2 3] 4])

(concat [1] [2] '(3 4) [5 6 7] #{9 12 13 16})
;;#{9 12 13 16} is set. set must be unique.

#{:a :b :c :d}
#{24 45 223 67 78}

(set '(234 545 6 42 76 7 234 6 76))

(set [232 12 4 56 33 12 56 4])

(set "sdfkg")
(apply str (set "sdfs"))
(apply str (set "abcdef"))
(apply str (set "nishantmanish"))
(apply str (set "manishkumarmdb"))
(apply str (set "ghywedfaszzxttevuwwouhjkcv"))

(set {:one 1 :two 2 :three 3})

(set nil)

#{:a :b :c :d :a}

(interleave [:fruit :color :temp]
            ["grape" "green" "hot"]
            [1 2 3])

;;--------------------

(def *strings* ["str1" "str2" "str3"])
(str *strings*)
(apply str *strings*)

(apply str ["str1" "str2" "str3"])
(str "str1" "str2" "str3")

;; Transpose a matrix
(def A [[5 6 8 2]
        [3 4 9 7]
        [0 1 10 11]])
(apply map vector A)

(map (partial apply +) [[6 2] [5 7]])

(def sixty-times (partial * 60))
(sixty-times 12)
(sixty-times 2 4 6)
(sixty-times 8 10 2 2)

(every? seq ["1" [1] '(1) {:1 1} #{1}])
(every? seq ["1" [1] '(1) {:1 1} #{1} []]) ;;here pass empty vector so o/p is false

(shuffle [2 34 56 31 78]) ;;return a random permutation of collection

(repeatedly 5 (partial shuffle [45 2 11 56]))


;;subsequences-------

(range 10)
(take 4 (range 13))
(drop 6 (range 18))
(take 13 (range 11))

(take-last 4 (range 78))
(drop-last 7 (range 16))

(take-while pos? [34 56 23 8 4 1 -5 -45 -21 -3 67 32 12])
(take-while pos? [-12 -213 -4 -2 -655 54 12 56 -56 -78 -12 6 8 4])

(split-at 4 (range 10))
(split-with number? [1 2 3 :mark 4 5 6 :mark 7])

(filter pos? [11 54 -234 -47 634 560 0])

(remove string? [1 "turing" :apple])

(partition 2 [:cats 5 :bats 27 :crocodiles 0])

(partition-by neg? [1 2 3 2 1 -1 -2 -3 -2 -1 1 2])
