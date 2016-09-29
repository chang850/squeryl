package models

import config.DBSchema
import org.squeryl.KeyedEntity
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.dsl.{ManyToOne, OneToMany}

case class User(id: Long, name: Option[String], ccid: Long) extends KeyedEntity[Long]{
  lazy val company: ManyToOne[Company] = DBSchema.companyToUser.right(this)
}

object User {
  def list = from(DBSchema.userTable)(userTable => select(userTable))
  def view(name: String) = from(DBSchema.userTable)(userTable => where(userTable.name === Option[String](name)) select (userTable))
  def save(x: User) = { inTransaction(DBSchema.userTable insert x) }
  def delete(name: String) = { inTransaction(DBSchema.userTable deleteWhere (x => x.name === Option[String](name))) }
  def update(x: User) = { inTransaction(DBSchema.userTable update x)}
}






