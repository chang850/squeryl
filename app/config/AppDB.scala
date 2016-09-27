package config

import models.{Company, User}
import org.squeryl.Schema
import org.squeryl.PrimitiveTypeMode._

object AppDB extends Schema {
  val userTable = table[User]("mt_user")
  val companyTable = table[Company]("mt_company")

  on(userTable) { p => declare {
    p.id is(autoIncremented)
  }}

  on(companyTable) {p => declare{
    p.id is(autoIncremented)
  }}
}
