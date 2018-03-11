package edu.knoldus.operations

import edu.knoldus.models.Credentials

class checkoutServicesTest extends AsyncFlatSpec {

   val user = Credentials("12345","raj","raj12345")
  val checkoutService = new checkoutServices(user)
   val userTwo = Credentials("12345","roh","12345")
  val checkoutServiceTwo = new checkoutServices(userTwo)


  "add item method" should "return true if item added" in {
    checkoutService.addItem(Item("motog3", "phone", "MOTOROLA", "electronics", 3, 12500)).map(flag => assert(flag))
  }

  it should "return false if user is not authenticated" in {
    checkoutServiceTwo.addItem(Item("motog3", "phone", "MOTOROLA", "electronics", 3, 12500)).map(flag => assert(!flag))
  }


  "remove item method" should "return true if item removed" in {
    checkoutService.removeItem(Item("motog3", "phone", "MOTOROLA", "electronics", 3, 12500)).map(flag => assert(flag))
  }

  it should "return false if user is not authenticated" in {
    checkoutServiceTwo.removeItem(Item("motog3", "phone", "MOTOROLA", "electronics", 3, 12500)).map(flag => assert(!flag))
  }


  "place order method" should "return true if order place" in {
    checkoutService.placeOrder.map(flag => assert(flag))
  }

  it should "return false if user is not authenticated" in {
    checkoutServiceTwo.placeOrder.map(flag => assert(!flag))
  }


  "get price method" should "return total price" in {
    checkoutService.getTotalPrice.map(price => assert(price == 0.0))
  }




}
