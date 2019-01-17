[![Clojars Project](https://img.shields.io/clojars/v/defunkt/clj-qrgen.svg)](https://clojars.org/defunkt/clj-qrgen)

# Summary

Forked version of killme2008's [clj.qrgen](https://github.com/killme2008/clj.qrgen) - clojure wrapper over [QRGen](https://github.com/kenglxn/QRGen) with iCal scheme added.

## Usage
```clojure
(use 'qrgen)
```

Create a QRCode from a text then save as a temporary file:

```clojure
(as-file (from "hello world"))
```

Created with options:

```clojure
;; override size and image type
(from "hello world" :size [250 250] :image-type JPG)
;; supply charset hint to ZXING
(from "hello world" :charset "utf-8")
;; supply error correction level hint to ZXING
(from "hello world" :correction L)
;; supply any hint to ZXING
(from "hello world" :hint {CHARACTER_SET "utf-8"})
```

Encode contact data as vcard using defaults:

```clojure
(from (vcard "John Doe"
             :email "john.doe@example.org"
			 :address "John Doe Street 1, 5678 Doestown"
			 :title "Mister"
			 :company "John Doe Inc."
			 :phonenumber "1234"
			 :website "www.example.org"))
```

same with ical:

```clojure
(from (ical "20170324T193000Z" ;; DTSTART
            "20170324T194000Z" ;; DTEND
            :organizer "Foo"
            :summary "Birthday party" 
            :location "Coffee Bar"
            :description "Bring sandwiches")
```

As InputStream( as ring response):

```clojure
(as-input-stream (from "hello world"))
```

As OutputStream:

```clojure
(as-output-stream (from "hello world"))
```

As byte array:

```clojure
(as-bytes (from "hello world"))
```

Suppy own file name:

```clojure
(as-file (from "hello world") "QRCode.png")
```

Work with `clojure.java.io`:

```clojure
(require '[clojure.java.io :as io])
(io/file (from "hello world"))
(io/output-stream (from "hello world"))
(io/input-stream (from "hello world"))
(io/copy (io/file (from "hello world")) a-output-stream)
```

## License

Copyright © 2014 [dennis zhuang](https://github.com/killme2008), 2019 [michał buczko](https://github.com/mbuczko)

Distributed under the Eclipse Public License version 1.0
