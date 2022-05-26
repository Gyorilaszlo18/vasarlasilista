package hu.nye.progkornyezet.vasarlasilista.controller;


import hu.nye.progkornyezet.vasarlasilista.model.Products;
import hu.nye.progkornyezet.vasarlasilista.model.exception.NotFoundException;
import hu.nye.progkornyezet.vasarlasilista.service.VasarlasilistaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class VasarlasilistaController {
    private static final String PRODUCTS_LIST_TEMPLATE_NAME = "products/list";
    private static final String PRODUCTS_LIST_TEMPLATE_NAME_P = "products/profile";
    private static final String PRODUCTS_ATTRIBUTE_NAME = "products";

    private final VasarlasilistaService vasarlasilistaService;

    public VasarlasilistaController(final VasarlasilistaService vasarlasilistaService) {
        this.vasarlasilistaService = vasarlasilistaService;
    }

    /**
     * Get all movie.
     */
    @GetMapping
    public String getAllMovie(final Model model) {
        final List<Products> products = vasarlasilistaService.getAllProducts();
        model.addAttribute("products", products);
        return PRODUCTS_LIST_TEMPLATE_NAME;
    }


    @GetMapping("/{id}")
    public String getMovie(final Model model, final @PathVariable int id) {
        final Products movie = vasarlasilistaService.getProducts(id);
        model.addAttribute(PRODUCTS_ATTRIBUTE_NAME, movie);
        return PRODUCTS_LIST_TEMPLATE_NAME_P;
    }

    /**
     * Delete selected movie.
     */
    @GetMapping("/{id}/delete")
    public String deleteProducts(final Model model, final @PathVariable("id") int id) {
        try {
            vasarlasilistaService.deleteProducts(id);
        } catch (NotFoundException e) {
            // Ignored
        }
        final List<Products> products = vasarlasilistaService.getAllProductsProfile();
        model.addAttribute("products", products);
        return PRODUCTS_LIST_TEMPLATE_NAME_P;
    }


    @GetMapping("/{id}/put")
    public String addProducts(final Model model, final @PathVariable("id") int id) {
        try {
            vasarlasilistaService.addProducts(id);
        } catch (NotFoundException e) {
            // Ignored
        }
        final List<Products> products = vasarlasilistaService.getAllProductsProfile();
        model.addAttribute("products", products);
        return PRODUCTS_LIST_TEMPLATE_NAME_P;
    }

    /**
     * Get all movie from profile.
     */
    @GetMapping("/profile")
    public String getAllProductsProfile(final Model model) {
        final List<Products> products2 = vasarlasilistaService.getAllProductsProfile();
        model.addAttribute("products", products2);
        return PRODUCTS_LIST_TEMPLATE_NAME_P;
    }
}