package com.project.projectsetting2.controller;

import com.project.projectsetting2.dto.AddProductRequest;
import com.project.projectsetting2.dto.ChangeUserInfoRequest;
import com.project.projectsetting2.dto.MemberJoinRequest;
import com.project.projectsetting2.service.ProductService;
import com.project.projectsetting2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ServiceController {

    private final UserService userService;

    private final ProductService productService;

    @GetMapping("/add/admin")
    public String addAdmin() {
        userService.addAdmin();
        return "redirect:/view/login";
    }

    @PostMapping("/join")
    public String join(MemberJoinRequest request) {
        userService.join(request);
        return "login";
    }

    @PostMapping("/add/product")
    public String addProduct(AddProductRequest request,
                             @RequestParam(name = "image") MultipartFile[] multipartFiles, Principal principal) throws IOException {
        productService.addProduct(request, multipartFiles, principal);
        return "redirect:/view/main";
    }

    @PostMapping("/delete/product")
    public String deleteProduct(@RequestParam String id) {
        productService.deleteProduct(id);
        return "redirect:/view/user";
    }

    @PostMapping("/add/cart")
    public String addCart(@RequestParam String id, Principal principal) {
        productService.addCart(id, principal);
        return "redirect:/view/cart";
    }

    @PostMapping("/delete/cart")
    public String deleteCart(@RequestParam String id, Principal principal) {
        productService.deleteCart(id, principal);
        return "redirect:/view/cart";
    }

    @PostMapping("/change/user/info")
    public String changeUserInfo(ChangeUserInfoRequest request, Principal principal) {
        userService.changeUserInfo(request, principal);
        return "redirect:/logout";
    }

}
