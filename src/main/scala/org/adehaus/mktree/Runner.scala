package org.adehaus.mktree

import com.google.caliper.{Runner => CaliperRunner}

object Runner {
  def main(args: Array[String]) {
    val caliperArgs = ("-Jmemory=-Xmx1G" :: Nil).toArray
    CaliperRunner.main(classOf[TreeBuilderBenchmark], caliperArgs)
  }
}
