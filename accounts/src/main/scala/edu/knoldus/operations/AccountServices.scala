package edu.knoldus.operations

import edu.knoldus.models.User

import scala.collection.mutable.ListBuffer

class AccountServices {

  private val registeredUsers = ListBuffer[User] {
    User("raj", "12345", "raj")
  }

  /**
    * registers a user.
    *
    * @param user user to be added.
    * @return true if user added, else false.
    */

  def registerUser(user: User): Boolean = {

    val userExists = registeredUsers.exists(registerUser => registerUser.mobileNumber == user.mobileNumber)
    if (userExists) {
      false
    }
    else {
      registeredUsers += user
      true
    }
  }

  /**
    * deletes a user.
    *
    * @param user user to be deleted.
    * @return true if user deleted, else false.
    */

  def deleteUser(user: User): Boolean = {
    val exists = registeredUsers.contains(user)
    if (exists) {
      registeredUsers -= user
      true
    } else {
      false
    }
  }

  /**
    * authenticates a user, and gives an accessToken for it.
    *
    * @param userName mobileNumber of user.
    * @param password password of user.
    * @return accessToken wrapped in option.
    */

  def authenticateUser(userName: String, password: String): Option[String] = {

    registeredUsers.find(user => user.mobileNumber == userName && user.password == password) match {
      case Some(user) => Some(user.name + user.mobileNumber)
      case None => None
    }

  }

}
