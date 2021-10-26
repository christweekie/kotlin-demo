package org.example._02_properties


fun main(args: Array<String>) {
  println("President $president")
  president = "Joe Biden"
  println("President $president")

  for (i in 1..3) {
    println(os)
  }
}

var president: String = "Donald Trump"
  get() {
    return field
  }
  set(value) {
    println("Setting president to $value from $field")
    field = value
  }























private var _os: String? = null

val os: String
  get() {
    if (_os == null) {
      println("Computing")
      _os = System.getProperty("os.name") +
        " v" + System.getProperty("os.version") +
        " (" + System.getProperty("os.arch") + ")"
    }
    return _os!!
  }




