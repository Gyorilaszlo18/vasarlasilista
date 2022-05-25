package hu.nye.progkornyezet.vasarlasilista.service;

import hu.nye.progkornyezet.vasarlasilista.model.Products;

import java.util.List;

public interface VasarlasilistaService {
    List<Products> getAllProducts();

    Products getProducts(int id);

    void addProducts(int id);

    void deleteProducts(int id);

    List<Products> getAllProductsProfile();
}

