/**
 * Created by ashu on 11/16/14.
 */

import com.sun.xml.internal.ws.policy.SimpleAssertion
import org.apache.spark.SparkContext._
import org.apache.spark.rdd.RDD

import org.scalatest.{BeforeAndAfterEach, FunSuite}

class outSuit extends FunSuite with BeforeAndAfterEach with LocalSparkContext {

  var vectors: Vector[Vector[String]] = _
  var data: RDD[Vector[String]] = _

  override def beforeEach() {

    vectors = Vector(
      Vector("A", "B"),
      Vector("A", "C"),
      Vector("A", "D"),
      Vector("E", "B")
    )
    data = sc.parallelize(vectors, 2)
  }
    test("only two outliers should be removed"){
      val model = OutlierWithAVFModel.outliers(data,30,sc)
      assert(model.trimedData.count() == 3)

    }
    test("No outlier should be removed"){
      val model = OutlierWithAVFModel.outliers(data,0,sc)
      assert(model.trimedData.count() == 4)
    }

  test("4 entries in score RDD") {
    val model = OutlierWithAVFModel.outliers(data, 30, sc)
    assert(model.score.count() == 4)

  }



  }
