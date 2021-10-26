package org.example._08_local_sealed_casts

fun main(args: Array<String>) {
  val root = Container(
    Text("richard "),
    Container(
      Text("of "),
      Container(
        Text("york "),
        Text("gave ")
      ),
      Text("battle ")
    ),
    Text("in vain")
  )

  println(root.extractText())
}

// Simple class declarations
abstract class Element
class Container(vararg val children: Element) : Element()
class Text(val text: String) : Element()

// extension function
fun Element.extractText(): String {
  return extractText(this, StringBuilder()).toString()
}

fun extractText(e: Element, sb:StringBuilder) : StringBuilder {
  if (e is Text) {
    val text = e as Text
    sb.append(text.text)
  } else if (e is Container) {
    val container = e as Container
    for (child in container.children) {
      extractText(child, sb)
    }
  } else  error("Unrecognised element : $e")

  return sb
}
