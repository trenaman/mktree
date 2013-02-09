package org.adehaus.mktree

case class Node (
  val label: String,
  val children: Iterable[Node]
)