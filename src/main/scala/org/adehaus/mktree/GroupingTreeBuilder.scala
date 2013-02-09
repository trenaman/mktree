package org.adehaus.mktree

/**
 * The 'Grouping' Algorithm: a functional, recursive algorithm that groups together paths
 * with the same first element, and then does the same to the sub paths that all start with the same
 * element.
 */
object GroupingTreeBuilder extends TreeBuilder {

  def buildWithPaths(paths: Iterable[Array[String]]): Iterable[Node] = {
    val nonZeroPaths = paths.filter(_.size > 0).toList
    val nodes = nonZeroPaths.map(_.head).distinct
    val groupedPaths = nonZeroPaths.groupBy(_.head)

    nodes map { node =>
      Node(node, buildWithPaths( groupedPaths(node).map(_.tail) ))
    }
  }

}
