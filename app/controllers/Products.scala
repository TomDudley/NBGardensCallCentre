package controllers

import play.api.mvc.{Action, Controller}
import models.Product

/**
  * Created by tdudley on 19/11/2015.
  */
class Products extends Controller {

  def list = Action { implicit request =>

    val products = Product.findAll

    Ok(views.html.products.list(products))
  }

  def show(ean: Long) = Action { implicit request =>
    Product.findByEan(ean).map { product =>
      Ok(views.html.products.details(product)) //Renders the product details page
    }.getOrElse(NotFound)  //404 Warning page
  }
}