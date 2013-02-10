package org.adehaus.mktree

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class GroupingTreeBuilderSpec extends FlatSpec with ShouldMatchers with TreeBuilderBehavior with GroupingTreeBuilder {
  "GroupingTreeBuilder" should behave like aTreeBuilder
}
