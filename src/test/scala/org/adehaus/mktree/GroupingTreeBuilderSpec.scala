package org.adehaus.mktree

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class GroupingTreeBuilderSpec extends FlatSpec with ShouldMatchers {

  import GroupingTreeBuilder._

  "buildWithPaths" should "return an empty tree if the paths list is empty" in {
    buildWithPaths(Nil) should be (Nil)
  }

  it should "return a single node with no children of there is only one path of length one." in {
    val singlePath = Array("A") :: Nil
    val nodes: Iterable[Node] = buildWithPaths(singlePath)

    nodes should be (List(
      Node("A", Nil)
    ))
  }

  it should "return an iterable of nodes with no children of there is more than one path and all paths are length one." in {
    val twoShallowPaths = Array("A") :: Array("B") :: Nil
    val nodes = buildWithPaths(twoShallowPaths)

    nodes should be (List(
      Node("A", Nil),
      Node("B", Nil)
    ))
  }

  it should "return a single node with two children when the path describes a single node with two children." in {
    val pathForNodeWithTwoChildren =
      Array("A") ::
        Array("A", "B") ::
        Array("A", "C") :: Nil

    val nodes = buildWithPaths(pathForNodeWithTwoChildren)

    nodes should be (List(
        Node("A",
          Node ("B", Nil) ::
          Node ("C", Nil) :: Nil
        )
    ))
  }

  it should "handle a complex tree correctly" in {
    val paths =
      Array("A") ::
        Array("A", "B") ::
        Array("A", "B", "B") ::
        Array("A", "B", "B", "E") ::
        Array("A", "F") :: Nil

    val nodes = buildWithPaths(paths)

    nodes should be (List(
      Node("A",
        Node ("B",
          Node ("B",
            Node("E", Nil) :: Nil
          ) :: Nil
        ) ::
          Node ("F", Nil) :: Nil
      )
    ))
  }
}
