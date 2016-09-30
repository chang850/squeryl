package base

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import play.api.test.PlayRunners

/**
  * Created by RSUPPORT on 2016-09-30.
  */
trait BaseDao extends FlatSpec with ShouldMatchers with PlayRunners{
  override def inMemoryDatabase(name: String, options: Map[String, String]): Map[String, String] = {
    Map(
      ("db." + name + ".driver") -> "com.mysql.jdbc.Driver",
      ("db." + name + ".url") -> ("jdbc:mysql://localhost/playdb")
    )
  }
}
