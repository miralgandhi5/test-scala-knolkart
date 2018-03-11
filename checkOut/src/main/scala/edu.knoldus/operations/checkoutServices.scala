package edu.knoldus.operations

import edu.knoldus.models.{Credentials, Item}

import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


class checkoutServices(user: Credentials) {

  val accountServices = new AccountServices()
  private val userCart = ListBuffer.empty[Item]

  /**
    * adds item to cart.
    *
    * @param item item to be added.
    * @return true if item added else false.
    */
  def addItem(item: Item): Future[Boolean] =
    Future {
      if (user.accessToken == user.password + user.userName) {
        userCart += item
        true
      } else {
        false
      }
    }

  /**
    * gets total price of items in cart.
    *
    * @return total price.
    */
  def getTotalPrice: Future[Double] = {
    Future {
      userCart.foldLeft(0d)((sum, item) => sum + item.price)
    }
  }

  /**
    * removes item from cart.
    *
    * @param item item to be removed.
    * @return true if removed else false.
    */
  def removeItem(item: Item): Future[Boolean] = {
    Future {
      if (user.accessToken == user.password + user.userName) {
        userCart -= item
        true
      } else {
        false
      }
    }
  }

  /**
    * places order.
    *
    * @return true if order placed else false.
    */

  def placeOrder: Future[Boolean] = {
    Future {
      if (user.accessToken == user.password + user.userName) {
        userCart.remove(0, userCart.length)
        true
      } else {
        false
      }
    }
  }


}
