(ns )

(= ":bar:foo" ((fn [[a b]] (str b a))
               [:foo :bar]))

(= (str "First comes love, "
        "then comes marriage, "
        "then comes Clojure with the baby carriage")
   ((fn [[a b c]] (str "First comes " a ", "
                       "then comes " b ", "
                       "then comes " c " with the baby carriage"))
    ["love" "marriage" "Clojure"]))

(= "Rich Hickey aka The Clojure aka Go Time aka Macro Killah"
   (let [[first-name last-name & aliases]
         (list "Rich" "Hickey" "The Clojure" "Go Time" "Macro Killah")]
     (str first-name " " last-name
          (apply str (map #(str " aka " %) aliases)))))

(= {:original-parts ["Steven" "Hawking"]
    :named-parts {:first "Steven" :last "Hawking"}}
   (let [[first-name last-name :as full-name] ["Steven" "Hawking"]]
     {:original-parts full-name
      :named-parts {:first first-name :last last-name}}))

(def test-address
  {:street-address "123 Test Lane"
   :city "Testerville"
   :state "TX"})

(= "123 Test Lane, Testerville, TX"
   (let [{street-address :street-address,
          city :city,
          state :state} test-address]
     (str street-address ", " city ", " state)))

(= "123 Test Lane, Testerville, TX"
   (let [{:keys [street-address city state]} test-address]
     (str street-address ", " city ", " state)))

(= "Test Testerson, 123 Test Lane, Testerville, TX"
   ((fn [[first-name last-name]
         {:keys [street-address city state]}]
      (str first-name " " last-name ", " street-address ", " city ", " state))
    ["Test" "Testerson"]
    test-address))
