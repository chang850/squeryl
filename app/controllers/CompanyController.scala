package controllers

import config.DBSchema
import models.{Company, User}
import org.squeryl.PrimitiveTypeMode._
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

object CompanyController extends Controller{

  def companyList = Action {
    implicit val barWrites = Json.writes[Company]
    implicit val barWrites2 = Json.writes[User]
        val json = inTransaction {
      val companys = from(DBSchema.companyTable)(
        companyTable => select(companyTable)
      )

      for(i <- companys.toList){
        val user = i.userList.toList
        val temp = "chang"

      }
      Json.toJson(companys)
    }
    Ok(json)
  }
}
