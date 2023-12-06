package com.itv.petstore.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itv.petstore.entites.Product;
import com.itv.petstore.services.ProductServices;

@RestController
public class productcontroller {
    @RequestMapping("/")
    public String getName()
    {
        return "My Name is Vaibhav";
    }
    @RequestMapping("/score")
    public int getscore()
    {
        return 99;
    }
    @Autowired
    private ProductServices productServices;
    @RequestMapping(path="/products",method=RequestMethod.GET )
    public Collection<Product>getProducts()
    {
        return this.productServices.getAllProducts();
    }
    @RequestMapping(path = "/products/{id}",method = RequestMethod.GET)
    public  Product getProductById(@PathVariable Integer id)
    {
        return this.productServices.getProductById(id);
    }
    @RequestMapping(path="/products",method=RequestMethod.POST)
   public Product addProduct(@RequestBody Product product)
   {
    return this.productServices.addProduct(product);
   }

   @RequestMapping(path="/products/{id}",method=RequestMethod.DELETE)
    public String deleteProduct(@PathVariable Integer id)
    {
        return this.productServices.deleteProduct(id);
    }

    @RequestMapping(path="/products/{id}",method=RequestMethod.PUT)
    public String updateProduct(@PathVariable Integer id ,@RequestBody Product product)
    {
        return this.productServices.updateProduct(id,product);
    }

}