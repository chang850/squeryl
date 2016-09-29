package models

import config.DBSchema
import org.squeryl.KeyedEntity
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.annotations.Column
import org.squeryl.dsl.OneToMany

case class Company(@Column("ccid") id: Long, name: String, description: String) extends KeyedEntity[Long]{
  lazy val userList: OneToMany[User] = DBSchema.companyToUser.left(this)
}

object Company{
  def list = from(DBSchema.companyTable)(companyTable => select(companyTable))
  def view(name: String) = from(DBSchema.companyTable)(companyTable => where(companyTable.name === name) select (companyTable))
  def save(x: Company) = { inTransaction( DBSchema.companyTable insert x) }
  def delete(name: String) = { inTransaction(DBSchema.companyTable deleteWhere (x => x.name === name)) }
  def update(x: Company) = { inTransaction(DBSchema.companyTable update x)}
}



