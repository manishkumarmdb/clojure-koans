(ns koans.08-conditionals
  (:require [koan-engine.core :refer :all]))

(defn explain-exercise-velocity [exercise-term]
  (case exercise-term
    :bicycling        "pretty fast"
    :jogging          "not super fast"
    :walking          "not fast at all"
    "is that even exercise?"))

(meditations
 "You will face many decisions"
 (= __ (if (false? (= 4 5))
         :a
         :b))

 (= :a (if (false? (= 4 5))
         :a
         :b))

 "Some of them leave you no alternative"
 (= __ (if (> 4 3)
         []))

 (= [] (if (> 4 3)
         []))

 "And in such a situation you may have nothing"
 (= __ (if (nil? 0)
         [:a :b :c]))

 (= nil (if (nil? 0)
          [:a :b :c]))

 "In others your alternative may be interesting"
 (= :glory (if (not (empty? ()))
             :doom
             __))

 (= :glory (if (not (empty? ()))
             :doom
             :glory))

 "You may have a multitude of possible paths"
 (let [x 5]
   (= :your-road (cond (= x __) :road-not-taken
                       (= x __) :another-road-not-taken
                       :else __)))

 (let [x 5]
   (= :your-road (cond (= x 10) :road-not-taken
                       (= x 12) :another-road-not-taken
                       :else :your-road)))

 "Or your fate may be sealed"
 (= 'doom (if-not (zero? __)
            'doom
            'more-doom))

 (= 'doom (if-not (zero? 1)
            'doom
            'more-doom))

 "In case of emergency, go fast"
 (= "pretty fast"
    (explain-exercise-velocity __))

 (= "pretty fast"
    (explain-exercise-velocity :bicycling))

 "But admit it when you don't know what to do"
 (= __
    (explain-exercise-velocity :watching-tv)))

(= "is that even exercise?"
   (explain-exercise-velocity :watching-tv)))
