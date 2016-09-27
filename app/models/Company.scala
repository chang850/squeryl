package models

/**
  * Created by RSUPPORT on 2016-09-27.
  */


class Company(val id: Long,
              val name: String,
              val address: Option[String]
             ) {
  def this() = this(0, "", Some(""))
}
