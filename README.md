mktree - an exploration in mutable vs immutable datatypes.
==========================================================

A scala project showing how to convert a list of paths, like:

    src
    src/main
    src/main/resources
    src/main/scala
    src/main/scala/org
    src/main/scala/org/adehaus
    src/main/scala/org/adehaus/mktree
    src/main/scala/org/adehaus/mktree/GroupingTreeBuilder.scala
    src/main/scala/org/adehaus/mktree/MutablePathTreeBuilder.scala
    src/main/scala/org/adehaus/mktree/Node.scala
    src/main/scala/org/adehaus/mktree/Runner.scala
    src/main/scala/org/adehaus/mktree/TreeBuilder.scala
    src/main/scala/org/adehaus/mktree/TreeBuilderBenchmark.scala
    src/test
    src/test/scala
    src/test/scala/org
    src/test/scala/org/adehaus
    src/test/scala/org/adehaus/mktree
    src/test/scala/org/adehaus/mktree/GroupingTreeBuilderSpec.scala
    src/test/scala/org/adehaus/mktree/MutablePathTreeBuilderSpec.scala
    src/test/scala/org/adehaus/mktree/TreeBuilderBehavior.scala

... into a tree, using two different algorithms. The first algorithm is functional and makes use of immutable data-types;
the basic idea of the algorithm is to group the paths by the first elements of the list paths, and then make sub-nodes recursively. The
second algorithm makes use of temporary mutable data-types in Scala to construct the path, and then traverses the mutable structure to
create an immutable result. Results are so interesting: the functional algorithm, while super elegant, takes about 2-3 times as long to create
the final result.

    [info]              benchmark   us linear runtime
    [info]    GroupingTreeBuilder 41.9 ==============================
    [info] MutablePathTreeBuilder 16.6 ===========
