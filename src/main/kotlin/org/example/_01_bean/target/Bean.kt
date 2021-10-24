package org.example._01_bean.target

class Bean(val name: String, val age: Int)


fun parseName(name: String): List<String> {
    val space = name.indexOf(' ')
    return listOf(
        name.substring(0, space),
        name.substring(space + 1)
    )
}

fun main(args: Array<String>) {
    val name = parseName("Jane Doe")
    val first = name[0]
    val last = name[1]

    print("Name is " + first + " " + last)

//  if (!name.equals(parseName("Jane Doe"))) {
//    System.err.println("Equals does not work")
//  }

}
