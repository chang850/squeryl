package models

import org.squeryl.KeyedEntity

case class Company(id: Long, name: String, description: String) extends KeyedEntity[Long] {

}

object Company {

}
