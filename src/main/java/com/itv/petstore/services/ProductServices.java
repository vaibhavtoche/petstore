package com.itv.petstore.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;
import com.itv.petstore.entites.Product;

@Service
public class ProductServices {
    private Map<Integer,Product>product=new HashMap<>();
    private AtomicInteger atomic=new AtomicInteger();
    public  ProductServices()
    {
        Product p=new Product();
        p.setId(atomic.incrementAndGet());
        p.setName("DEEP DEAR Extra Large Dog");
        p.setPrice(23223.67);
        p.setManufature("Thicker Pet Training and Puppy");
        p.setDescription("Thicker Pet Training and Puppy");
        product.put(p.getId(),p);

        Product p2 = new Product();
        p2.setId(atomic.incrementAndGet());
        p2.setName("DEEP DEAR Extra Large Dog");
        p2.setPrice(23223.67);
        p2.setManufature("Thicker Pet Training and Puppy");
        p2.setDescription("Thicker Pet Training and Puppy");
        product.put(p2.getId(),p);
    }
   

    public Collection<Product>getAllProducts()

    {
        return product.values();
    }

    public Product getProductById(Integer id)
    {
        return product.get(id);
    }
    public Product addProduct(Product p) {
        p.setId(atomic.incrementAndGet());
        product.put(p.getId(), p);
           return p;
     }

     public String deleteProduct(Integer id) {
        Product productexists=product.get(id);
        if(productexists!=null)
        {
         product.remove(id);
         return "product deleted sucessfully...";
        }
        else{
         return "no such  product";
        }
     }
     public String updateProduct(Integer id, Product p) {
        
        Product productexits=product.get(id);
        if(productexits!=null)
        {
            p.setId(id);
            product.put(id,p);
            return "product updated successfully....";
        }
        else{
            return "no such product";
        }
    }


}

