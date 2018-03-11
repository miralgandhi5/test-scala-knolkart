package edu.knoldus.operations

import org.apache.log4j.Logger

object Dashboard {

  def main(args: Array[String]): Unit = {
    val log = Logger.getLogger(this.getClass)

    log.info(s"1. Register user \n 2. Sort Items \n3. Filter Items \n4.Add Item \n5.")


  }


}
