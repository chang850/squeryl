package dao

import base.BaseDao
import config.DBSchema
import models.User
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.squeryl.PrimitiveTypeMode.inTransaction
import play.api.test.Helpers._
import play.api.test._


class UserSpec extends BaseDao {

  "A Bar" should "be creatable" in {
    running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
      inTransaction {
        val bar = DBSchema.userTable insert User(1L,Some("윤창희"),1L)
        bar.id should not equal(0)
      }
    }
  }



  /*
  "A request to the addBar action" should "respond" in {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        val result = controllers.UserController.userSave(FakeRequest().withFormUrlEncodedBody("name" -> "FooBar"))
        status(result) should equal (SEE_OTHER)
        redirectLocation(result) should equal (Some(routes.UserController.index.url))
      }
    }

    "A request to the getBars Action" should "respond with data" in {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        inTransaction(DBSchema.userTable insert User))

        val result = controllers.UserController.userView(FakeRequest())
        status(result) should equal (OK)
        contentAsString(result) should include("foo")
      }
    }
    */
}
