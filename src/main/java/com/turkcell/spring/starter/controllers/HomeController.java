package com.turkcell.spring.starter.controllers;

// CTRL + SPACE => Intelissense'i triggerlar

import com.turkcell.spring.starter.entities.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("home")
// http://localhost:8080/home
// http://localhost:8080/home/index
// http://localhost:8080/home/categories

// METHOD => GET,POST,PUT,DELETE...


// GET => Cevap olarak bir kaynak dönüleceği durumlarda kullanılır. Örn: ürünleri listeleme fonksiyonu
// POST => Bir kaynak oluşturulması isteği durumlarında kullanılır. Örn: ürün ekleme fonksiyonu
// PUT => Bir kaynağın değiştirilmesi isteği durumunda kullanılır. Örn: ürün güncellenmesi.
// DELETE => Bir kaynağın silinmesi isteği durumunda kullanılır. Örn: ürünün dbden silinmesi.
public class HomeController {


    // http://localhost:8080/home GET İSTEĞİ
    @GetMapping("")
    public String get(){
        return "Merhaba Turkcell";
    }

    // http://localhost:8080/home POST İSTEĞİ
    @PostMapping("")
    public String getPost(){
        return "Merhaba Turkcell Post";
    }

    //http://localhost:8080/home/index
    @GetMapping("index")
    public String get2(){
        return "Merhaba Turkcell 2";
    }

    @GetMapping("products")
    public List<Product> getProducts(){
        List<Product> productList = new ArrayList<>();

        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Laptop");

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Telefon");

        productList.add(product1);
        productList.add(product2);

        // InMemory

        return productList;
    }

    // Query String =>  localhost:8080/home/getById?id=1&name=deneme
    // Route => localhost:8080/home/getById/1/deneme
    @GetMapping("getById")
    public Product getById(@RequestParam("id") int id){
        Product product = new Product();
        product.setId(id);
        product.setName("Laptop");
        return product;
    }

    // Her bir temel entitynin kendi controllerinin bulunması best practicedir.
    // 8:00'de dersteyiz..

}
