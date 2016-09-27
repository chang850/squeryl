package controllers

import config.AppDB
import models.User
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
    User.apply(userId, name)
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
      val users = from(AppDB.userTable)(userTable => where(userTable.name === Option[String](name))
        select (userTable))
      Json.toJson(users)
    }
    Ok(json)
  }

  def userList = Action {
    implicit val barWrites = Json.writes[User]
    val json = inTransaction {
      val users = from(AppDB.userTable)(
        userTable => select(userTable)
      )
      Json.toJson(users)
    }
    Ok(json)
  }
  //SAVE
  def userSave = Action {
    implicit request =>
      userForm.bindFromRequest.value map {
        user => inTransaction(
          AppDB.userTable insert user)
          Redirect(routes.UserController.index)
      } getOrElse BadRequest
  }

  def userUpdate = Action { implicit request =>
    userForm.bindFromRequest.value map { user =>
      inTransaction(AppDB.userTable deleteWhere (x => x.name === Option[String]("윤창희")))
      Redirect(routes.UserController.index)
    } getOrElse BadRequest
  }

  //DELETE
  def userDelete = Action { implicit request =>
    userForm.bindFromRequest.value map { user =>
      inTransaction(AppDB.userTable deleteWhere (x => x.name === Option[String]("윤창희")))
      Redirect(routes.UserController.index)
    } getOrElse BadRequest
  }
}
