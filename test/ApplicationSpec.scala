import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class ApplicationSpec extends FlatSpec with ShouldMatchers {

/*  "A request to the addBar action" should "respond" in {
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
  }*/
  
}