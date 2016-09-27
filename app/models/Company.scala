package models

import org.squeryl.annotations.ColumnBase

case class Company(val id:String, val name: String, val address: Option[String]){

}
