package org.adehaus.mktree

trait TreeBuilder {
  def buildWithPaths(paths: Iterable[Iterable[String]]): Iterable[Node]
}
