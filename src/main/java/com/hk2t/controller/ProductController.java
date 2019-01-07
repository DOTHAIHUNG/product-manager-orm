package com.hk2t.controller;

import com.hk2t.model.Product;
import com.hk2t.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ModelAndView index() {
        List <Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create-product")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create-product")
    public String saveCustomer(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "New product created successfully");
        return "redirect:/";
    }

    @GetMapping("/edit-product/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("product", product);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-product")
    public String updateProduct(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Product updated successfully");
        return "redirect:/";
    }

    @GetMapping("/delete-product/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("product", product);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-product")
    public String deleteProduct(@ModelAttribute("product") Product product) {
        productService.remove(product.getId());
        return "redirect:/";
    }

    @GetMapping("/view-product/{id}")
    public ModelAndView view(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView("/view");
            modelAndView.addObject("product", product);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    //    @GetMapping("/product/{id}/edit")
//    public String edit(@PathVariable Long id, Model model) {
//        model.addAttribute("product", productService.findById(id));
//        return "edit";
//    }
//
//    @PostMapping("/product/update")
//    public String update(Product product, RedirectAttributes redirectAttributes) {
//        productService.save(product);
//        redirectAttributes.addFlashAttribute("success", "Modified customer successfully!");
//        return "redirect:/";
//    }
//
//    @GetMapping("/product/{id}/delete")
//    public String remove(@PathVariable Long id, Model model) {
//        model.addAttribute("product", productService.findById(id));
//        return "delete";
//    }
//
//    @PostMapping("/product/delete")
//    public String delete(Product product, RedirectAttributes redirectAttributes) {
//        productService.remove(product.getId());
//        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
//        return "redirect:/";
//    }
//

}
