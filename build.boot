(set-env!
 :source-paths #{"src"}
 :repositories #(conj % ["jitpack" "https://jitpack.io"])
 :dependencies '[[org.clojure/clojure "1.9.0"]
                 [com.github.kenglxn/QRGen "2.5.0"]
                 [adzerk/bootlaces "0.1.13" :scope "test"]])

;; to check the newest versions:
;; boot -d boot-deps ancient

(def +version+ "0.0.1")

(require '[adzerk.bootlaces :refer :all])

(bootlaces! +version+)

(task-options!
 pom {:project 'defunkt/clj-qrgen
      :version +version+
      :description "QRCodes with clojure"
      :url "https://github.com/mbuczko/clj-qrgen"
      :scm {:url "https://github.com/mbuczko/clj-qrgen"}
      :license {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})
