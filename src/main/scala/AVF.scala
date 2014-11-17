import org.apache.spark.SparkContext


/**
 * Driver for the OutlierWithAVFModel 
 *
 **/
object Test{

  def main(args:Array[String])
  {
    val sc = new SparkContext("local", "OutlierDetection")
    val dir = "/home/ashu/Desktop/abc.txt"
//    "hdfs://localhost:54310/train3"//"/home/ashu/Desktop/abc.txt"

    val data = sc.textFile(dir).map(word => word.split(",").toVector)
    val model = OutlierWithAVFModel.outliers(data,60,sc) //"hdfs://localhost:54310/train3"

    model.score.saveAsTextFile("/home/ashu/Desktop/scores")
    model.trimmed_data.saveAsTextFile("/home/ashu/Desktop/trimmed")


  }

}