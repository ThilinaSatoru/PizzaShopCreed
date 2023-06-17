package lk.NIBM.PizzaShopCreed.controller;

import lk.NIBM.PizzaShopCreed.dao.Cart;
import lk.NIBM.PizzaShopCreed.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    ICartService cartService;

    @RequestMapping("cart_orders")
    public String showHome() {
        return "cart_orders";
    }

    @GetMapping("/cart_orders")
    public String showProductPage(Model model) {
        List<Cart> cartList = cartService.findAll();
        model.addAttribute("listCart", cartList);
        System.out.println("Get Cart list");
        return "cart_orders";
    }

    @RequestMapping("/cart/deletes/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        cartService.delete(id);
        return "cart_orders";
    }
}
