package org.example._03_functions

class StringUtil {
  fun getSecondWord(s: String, separator: String): String {
    val index = s.indexOf(separator)
    if (index < 0) {
      return s
    }
    else {
      return s.substring(index+1)
    }
  }

  fun getSecondWord(s: String): String {
    return getSecondWord(s, " ")
  }
}

fun main(args: Array<String>) {
  println(StringUtil().getSecondWord("Jane Doe", " "))
}
