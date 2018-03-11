package edu.knoldus.operations


import edu.knoldus.models.User
import org.scalatest.{FlatSpec, Matchers}

class AccountServicesTest extends FlatSpec with Matchers {

  val user = User("miral","8447558500","miral")

  val registeredUser = User("raj","12345","raj")

  val accountService = new AccountServices()

  "register user method" should "add a user to the registered list" in {
    accountService.registerUser(user)
  }

  it should "not add already existing user" in {
    !accountService.registerUser(registeredUser)
  }

  "delete user method" should "delete a user from the registered list" in {
    accountService.deleteUser(user)
  }

  it should "not delete non-existing user" in {
    !accountService.deleteUser(user)
  }

  "authenticate user method" should "generate an access token" in {
    accountService.authenticateUser("12345","raj").getOrElse(" ") should be ("raj12345")
  }

  it should "not generate an access token" in {
    accountService.authenticateUser("aman123","123").getOrElse(" ") should be (" ")
  }





}
