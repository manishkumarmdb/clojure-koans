(ns first-01.May-02-2016)

(frequencies [:a :b :c :a :c :a])
(frequencies ['a 'b 'c 'a 'a])

(clojure.pprint/pprint (group-by :first [{:first "Li"    :last "Zhou"}
                                         {:first "Sarah" :last "Lee"}
                                         {:first "Sarah" :last "Dunn"}
                                         {:first "Li"    :last "O'Toole"}]))

(drop 6 (range 12))

;; group strings by their length
(group-by count ["aas" "dfdg" "as" "hjg" "hyykF" "m"])

;;group integers by a predicate
(group-by odd? (range 15))

;; group by a primary key
(group-by :user-id [{:user-id 1 :uri "/"}
                    {:user-id 2 :uri "/foo"}
                    {:user-id 1 :uri "/account"}])

(reduce + [32 5 2 6 8]) ;;=> 53
(reduce + []) ;;=> 0
(reduce + [34]) ;;=> 34 ;; here no call function because less than 2 argument pass
(reduce + 3 []) ;;=> 3
(reduce + 4 [5 8])

;; converting a vector to a set
(reduce conj #{} [:a :s :f :g]) ;;=> #{:s :g :f :a}

(reductions + [4 3 6 7]) ;;=> (4 7 13 20) ;;shows intermediate values of the reduction, starting with init.

(reductions + [1 2 3 4]) ;;=> (1 3 6 10)

;;reductions using a init value 100
(reductions (fn [sum num] (+ sum num)) 100 [1 2 3 4 5])

(into {} [[:s 2] [:j 4] [:k 6]]) ;;=> {:s 2, :j 4, :k 6}
(into (list) [3 5 6 8 2]) ;;=> (2 8 6 5 3)

(reduce conj [] [6 4 3 7 9 2]) ;;=>  [6 4 3 7 9 2]

(defn my-map [f coll]
  (reduce (fn [output element]
            (conj output (f element)))
          []
          coll))

(my-map inc [5 3 6 8 2]) ;;=> [6 4 7 9 3]

(defn my-take-while [f coll]
  (reduce (fn [out elem]
            (if (f elem)
              (conj out elem)
              (reduced out)))
          []
          coll))

(my-take-while pos? [2 1 0 -1 0 1 2]) ;;=> [2 1]

(clojure.repl/source max)

(clojure.repl/source pos?)

(def my-value 7)
my-value
(realized? my-value) ;;return true if a value has been produced

(take 3 (map (fn [pair] (* (first pair) (second pair)))
             (partition 2 1 (filter odd? (iterate inc 0))))) ;;=> (3 15 35)
