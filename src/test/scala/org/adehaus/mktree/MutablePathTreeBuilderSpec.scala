package org.adehaus.mktree

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class MutablePathTreeBuilderSpec extends FlatSpec with ShouldMatchers with TreeBuilderBehavior with MutablePathTreeBuilder {
  "MutablePathTreeBuilder" should behave like aTreeBuilder
}
