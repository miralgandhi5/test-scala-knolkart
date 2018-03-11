package edu.knoldus.operations

import edu.knoldus.models.Item

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class InventoryServices {

  val items: List[Item] = List[Item](Item("motog3", "phone", "MOTOROLA", "electronics", 3, 12500), Item("kurti", "indian wear", "WOMEN WEAR", "clothing", 4, 1250))

  /**
    * search items on based f category.
    *
    * @param category category on which to search item.
    * @return list of items based on category.
    */
  def searchItem(category: String): Future[List[Item]] = {
    Future {
      items.filter(items => items.category == category)
    }
  }

  /**
    *
    * sorts items.
    *
    * @param filterOn   property on which to sort.
    * @param filterType order on which to sort.
    * @return sorted list of items.
    */

  def sortItemList(filterOn: String = "default", filterType: String = "default"): Future[List[Item]] = {
    Future {
      filterOn match {
        case "price" if filterType == "low to high" => items.sortWith((itemA, itemB) => itemA.price < itemB.price)
        case "rating" if filterType == "high to low" => items.sortWith((itemA, itemB) => itemA.rating > itemB.rating)
        case "rating" => items.sortWith((itemA, itemB) => itemA.rating < itemB.rating)
        case _ => items.sortWith((itemA, itemB) => itemA.price > itemB.price)
      }
    }
  }

  /**
    * filters items based on vendors.
    *
    * @param vendors list of vendors.
    * @return list of items filtered on based of vendors.
    */

  def filterItemsByVendor(vendors: List[String]): Future[List[Item]] = {
    Future {
      items.filter(item => vendors.contains(item.vendorInformation))
    }
  }

}
