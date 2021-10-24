package org.example._02_properties

import kotlin.properties.Delegates

var observeMe by Delegates.observable("a") {
  p, old, new ->
    println("${p.name} goes $old -> $new")
}

fun main(args: Array<String>) {
println("\n\nObservable property: $observeMe" )
  observeMe = "initial"
  observeMe = "next"
  observeMe = "subsequent"
  observeMe = "final"
}
