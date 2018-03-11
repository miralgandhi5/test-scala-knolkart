package edu.knoldus

import edu.knoldus.models.Credentials
import edu.knoldus.operations.{AccountServices, InventoryServices, checkoutServices}

object Services {

  val AccountServices = new AccountServices()
  val InventoryServices = new InventoryServices()

  def getCheckOutService(user: Credentials): checkoutServices = {
    new checkoutServices(user)
  }


}
