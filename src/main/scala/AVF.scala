import org.apache.spark.SparkContext


/**
 * Driver for the OutlierWithAVFModel 
 *
 **/
object Test{

  def main(args:Array[String])
  {
    val sc = new SparkContext("local", "OutlierDetection")
    val dir = "hdfs://localhost:54310/train3"//"/home/ashu/Desktop/abc.txt"
//

    val data = sc.textFile(dir).map(word => word.split(",").toVector)
    val model = OutlierWithAVFModel.outliers(data,60,sc) //"hdfs://localhost:54310/train3"

    model.score.saveAsTextFile("/home/ashu/Desktop/sc")
    model.trimedData.saveAsTextFile("/home/ashu/Desktop/tri")


  }

}