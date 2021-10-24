package org.example._03_functions

class StringUtil {
  fun getFirstWord(s: String, separator: String): String {
    val index = s.indexOf(separator)
    if (index < 0) {
      return s
    }
    else {
      return s.substring(index)
    }
  }

  fun getFirstWord(s: String): String {
    return getFirstWord(s, " ")
  }
}

fun main(args: Array<String>) {
  println(StringUtil().getFirstWord("Jane Doe", " "))
}
