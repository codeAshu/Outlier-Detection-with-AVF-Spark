/**
 * Created by ashu on 11/16/14.
 */

import com.sun.xml.internal.ws.policy.SimpleAssertion
import org.apache.spark.SparkContext._
import org.apache.spark.rdd.RDD

import org.scalatest.{BeforeAndAfterEach, FunSuite}

class outSuit extends FunSuite with LocalSparkContext {


  /*test("percentage should be less then 100") {
    val percent = 102

    val m = OutlierWithAVFModel.outliers(data,percent,sc)
    assert(System.exit(1) == true)
  }
*/
  test("parameter validation") {
       intercept[IllegalArgumentException] {
         val v = Vector(Vector("x","y","z"), Vector("m","n"))
         val p = sc.parallelize(v)
         val data = p
         val percent = 102
         val app = OutlierWithAVFModel.outliers(data,percent,sc)

    }
  }



}
