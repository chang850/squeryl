package controllers

import config.DBSchema
import models.{Company, User}
import org.squeryl.PrimitiveTypeMode._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

object UserController extends Controller {

  val userForm = Form(
    mapping(
      "id" -> optional(longNumber),
      "name" -> optional(text)
    )(userFormApply)(userFormUnApply)
  )

  private def userFormApply(id: Option[Long], name: Option[String]) = {
    val userId = id match {
      case Some(long) =>long
      case None => -1L
    }
    val company = Company(111L,"COMPANY","COMPANY")
    User.apply(userId, name, company.id)
  }

  private def userFormUnApply(user: User) = {
    Option(Some(user.id), user.name)
  }

  def index = Action {
    Ok(views.html.index(userForm))
  }

  def userView(name: String) = Action {
    implicit val barWrites = Json.writes[User]
    val json = inTransaction {
      val users =
        from(DBSchema.userTable)(
          userTable => select(userTable)
        )
      Json.toJson(users)
    }
    Ok(json)
  }

  def userList = Action {
    implicit val barWrites = Json.writes[User]
    val json = inTransaction {
      val users =User.list
      Json.toJson(users)
    }
    Ok(json)
  }


  /*def userList = Action {
    implicit val barWrites = Json.writes[User]
    implicit val barWrites2 = Json.writes[Company]
    val json = inTransaction {
      val users =
        join(DBSchema.companyTable, DBSchema.userTable)((companyTable, userTable) =>
          select(companyTable).on(companyTable.id === userTable.ccid))
      Json.toJson(users)
    }
    Ok(json)
  }*/

  //조인문
  /*val json = inTransaction {
    val users =
      join(DBSchema.companyTable, DBSchema.userTable)((companyTable, userTable) =>
        select(companyTable).on(companyTable.id === userTable.ccid))
    Json.toJson(users)
  }*/

  def userSave = Action {
    implicit request =>
      userForm.bindFromRequest.value map {
        user => inTransaction(

          DBSchema.userTable insert user)
          Redirect(routes.UserController.index)
      } getOrElse BadRequest
  }

  def userUpdate = Action { implicit request =>
    userForm.bindFromRequest.value map { user =>
      inTransaction(DBSchema.userTable update user)
      Redirect(routes.UserController.index)
    } getOrElse BadRequest
  }


  def userDelete = Action { implicit request =>
    userForm.bindFromRequest.value map { user =>
      inTransaction(DBSchema.userTable deleteWhere (x => x.name === Option[String]("")))
      Redirect(routes.UserController.index)
    } getOrElse BadRequest
  }
}
