package org.apache.zeppelin

/**
 * Created by zhanglei on 2016/1/18.
 */

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

class UDF {
  def main (args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("MySQL-Demo")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    val jdbcDF = sqlContext.read.format("jdbc").options(
    Map("url"->"{url}", "driver"->"{driver}", "dbtable"->"{dbtable}", "user"->"{user}", "password"->"{password}")
    ).load()
  }

  def ss =  """
              |val jdbcDF = sqlContext.read.format("jdbc").options(
              |    Map("url"->"@url", "driver"->"@driver", "dbtable"->"@dbtable", "user"->"@user", "password"->"@password")
              |    ).load()
            """.stripMargin
}
