package org.adehaus.mktree
import collection.mutable.LinkedHashMap

trait MutablePathTreeBuilder extends TreeBuilder {

  case class MutableNode (
     label: String,
     children: LinkedHashMap[String, MutableNode] = new LinkedHashMap[String, MutableNode]
  ) {
    def toNode: Node = Node(label, children.map(_._2.toNode))

    def addPath(path: Iterable[String]) {
      if (path.size > 0) {
        val node = path.head
        val child = if (! children.contains(node)) {
          val newChild = MutableNode(node)
          children.put(node, newChild)
          newChild
        } else {
          children(node)
        }

        child.addPath(path.tail)
      }
    }
  }

  def buildWithPaths(paths: Iterable[Iterable[String]]): Iterable[Node] = {
    val root = MutableNode("")

    paths foreach {
      root.addPath(_)
    }

    root.children.map(_._2.toNode)
  }
}
