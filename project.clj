(defproject katas "0.1.0-SNAPSHOT"
  :description "FIXME: write description"

  :plugins [[lein-midje "3.1.3"]
            [lein-cloverage "1.0.6"]
            [lein-vanity "0.2.0"]
            [s3-wagon-private "1.2.0"]
            [lein-ancient "0.6.10"]]

  :repositories  [["central" {:url "http://repo1.maven.org/maven2/" :snapshots false}]
                  ["clojars" {:url "https://clojars.org/repo/"}]]

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [criterium "0.4.4"]]


  :min-lein-version "2.4.2"
  :resource-paths ["resources"]
  :test-paths ["test/"])

