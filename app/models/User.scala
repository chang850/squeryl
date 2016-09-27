package models

import org.squeryl.KeyedEntity

case class User(name: Option[String]) extends KeyedEntity[String]{
  val id: String = "name"
}




