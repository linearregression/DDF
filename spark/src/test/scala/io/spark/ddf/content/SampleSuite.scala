package io.spark.ddf.content

import io.spark.ddf.ATestSuite
import scala.collection.JavaConversions._
/**
 */
class SampleSuite extends ATestSuite {
  createTableMtcars()
  test("test sample") {
    val ddf = manager.sql2ddf("select * from mtcars")
    val sample = ddf.VIEWS.getRandomSample(10)

    assert(sample(0)(0).asInstanceOf[Double] != sample(1)(0).asInstanceOf[Double])
    assert(sample(1)(0).asInstanceOf[Double] != sample(2)(0).asInstanceOf[Double])
    assert(sample(2)(0).asInstanceOf[Double] != sample(3)(0).asInstanceOf[Double])
    assert(sample.length == 10)
  }
}
