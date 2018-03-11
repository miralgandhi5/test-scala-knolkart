package edu.knoldus.operations

import edu.knoldus.models.Item
import org.scalatest.AsyncFlatSpec



class InventoryServicesTest extends AsyncFlatSpec {


  val inventoryService = new InventoryServices()

  "search item method" should "return a list of searched items" in {
    inventoryService.searchItem("clothing").map{ list => assert(list == List(Item("kurti", "indian wear", "WOMEN WEAR", "clothing", 4, 1250))) }
  }

  it should "return an empty list of searched items" in {
    inventoryService.searchItem("footwear").map { list => assert(list == List()) }
  }

  "sortItemList method" should "return sorted list on basis of price: low to high" in {
    inventoryService.sortItemList("price","low to high").map { list => assert(list == List(Item("kurti", "indian wear", "WOMEN WEAR", "clothing", 4, 1250),Item("motog3", "phone", "MOTOROLA", "electronics", 3, 12500))) }
  }

  it should "return sorted list on basis of price: high to low" in {
    inventoryService.sortItemList("price","high to low").map { list => assert(list == List(Item("motog3", "phone", "MOTOROLA", "electronics", 3, 12500), Item("kurti", "indian wear", "WOMEN WEAR", "clothing", 4, 1250))) }
  }

  it should "return sorted list on basis of rating: high to low" in {
    inventoryService.sortItemList("rating","high to low").map { list => assert(list == List(Item("kurti", "indian wear", "WOMEN WEAR", "clothing", 4, 1250),Item("motog3", "phone", "MOTOROLA", "electronics", 3, 12500))) }
  }

  it should "return sorted list on basis of rating: low to high" in {
    inventoryService.sortItemList("rating","low to high").map { list => assert(list == List(Item("motog3", "phone", "MOTOROLA", "electronics", 3, 12500), Item("kurti", "indian wear", "WOMEN WEAR", "clothing", 4, 1250))) }
  }

  it should "return sorted list on default" in {
    inventoryService.sortItemList("xyz","xyz").map { list => assert(list == List(Item("motog3", "phone", "MOTOROLA", "electronics", 3, 12500), Item("kurti", "indian wear", "WOMEN WEAR", "clothing", 4, 1250))) }
  }

  "filterItemsByVendor method" should "return filtered list on basis of vendor" in {
    inventoryService.filterItemsByVendor(List("MOTOROLA")).map {list => assert(list == List(Item("motog3", "phone", "MOTOROLA", "electronics", 3, 12500)) )}
  }

  it should "return empty list" in {
    inventoryService.filterItemsByVendor(List("xyz")).map(list => assert(list == List()))
  }


}
