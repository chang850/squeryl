package models

import org.squeryl.KeyedEntity

case class User(id: Long, name: Option[String]) extends KeyedEntity[Long]

object User {

}




