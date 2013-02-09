package org.adehaus.mktree

trait TreeBuilder {
  def buildWithPaths(paths: Iterable[Array[String]]): Iterable[Node]
}
