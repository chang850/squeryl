package config

import models.{Company, User}
import org.squeryl.Schema

object AppDB extends Schema {
  val userTable = table[User]("mt_user")
}
