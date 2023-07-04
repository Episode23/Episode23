package com.project.projectsetting2.controller;

import com.project.projectsetting2.service.ProductService;
import com.project.projectsetting2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/view")
public class ViewController {

    private final UserService userService;

    private final ProductService productService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }

    @GetMapping("/main")
    public String mainPage(@RequestParam(required = false) String search, Model model) {
        if (search != null) {
            System.out.println(search + " sdfds");
        }
        model.addAttribute("products", productService.getProducts(search));
        return "main";
    }

    @GetMapping("/clothes")
    public String clothesPage(@RequestParam(required = false) String search, Model model) {
        model.addAttribute("products", productService.getClothes(search));
        return "main";
    }

    @GetMapping("/accessory")
    public String accessoryPage(@RequestParam(required = false) String search, Model model) {
        model.addAttribute("products", productService.getAccessory(search));
        return "main";
    }

    @GetMapping("/etc")
    public String etcPage(@RequestParam(required = false) String search, Model model) {
        model.addAttribute("products", productService.getEtc(search));
        return "main";
    }

//    @GetMapping("/best")
//    public String bestPage() {
//        return "best";
//    }

    @GetMapping("/cart")
    public String cartPage(Model model, Principal principal) {
        model.addAttribute("products", productService.getCart(principal));
        model.addAttribute("totalCost", productService.getCartTotalCost(principal));
        return "cart";
    }

    @GetMapping("/user")
    public String userPage() {
        return "user";
    }

    @GetMapping("/product")
    public String productDetailsPage(@RequestParam String id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productDetails";
    }

    @GetMapping("/add/product")
    public String addProductPage() {
        return "addProduct";
    }

}
