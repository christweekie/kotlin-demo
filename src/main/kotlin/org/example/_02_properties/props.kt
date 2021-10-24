package org.example._02_properties

private var prop: String = "..."

fun getProp() = prop

fun setProp(v: String) {
  print("New value: $v")
  prop = v
}
