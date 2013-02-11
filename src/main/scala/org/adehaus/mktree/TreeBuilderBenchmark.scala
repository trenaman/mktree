package org.adehaus.mktree

import com.google.caliper.SimpleBenchmark

class TreeBuilderBenchmark extends SimpleBenchmark {

  val groupingTreeBuilder = new GroupingTreeBuilder {}
  val mutablePathTreeBuilder = new MutablePathTreeBuilder {}

  val paths =
    """src
      |src/main
      |src/main/resources
      |src/main/scala
      |src/main/scala/org
      |src/main/scala/org/adehaus
      |src/main/scala/org/adehaus/mktree
      |src/main/scala/org/adehaus/mktree/GroupingTreeBuilder.scala
      |src/main/scala/org/adehaus/mktree/MutablePathTreeBuilder.scala
      |src/main/scala/org/adehaus/mktree/Node.scala
      |src/main/scala/org/adehaus/mktree/TreeBuilder.scala
      |src/main/scala/org/adehaus/mktree/TreeBuilderBenchmark.scala
      |src/test
      |src/test/scala
      |src/test/scala/org
      |src/test/scala/org/adehaus
      |src/test/scala/org/adehaus/mktree
      |src/test/scala/org/adehaus/mktree/GroupingTreeBuilderSpec.scala
      |src/test/scala/org/adehaus/mktree/MutablePathTreeBuilderSpec.scala
      |src/test/scala/org/adehaus/mktree/TreeBuilderBehavior.scala""".stripMargin.split("\n").map(_.split("/").toIterable).toIterable

  def timeGroupingTreeBuilder(reps: Int): String = {
    var dummy = ""
    var i = 0

    while (i < reps) {
      val nodes = groupingTreeBuilder.buildWithPaths(paths)
      dummy = nodes.head.label
      i += 1
    }

    dummy
  }

  def timeMutablePathTreeBuilder(reps: Int): String = {
    var dummy = ""
    var i = 0

    while (i < reps) {
      val nodes = mutablePathTreeBuilder.buildWithPaths(paths)
      dummy = nodes.head.label
      i += 1
    }

    dummy
  }
}
