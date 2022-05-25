package hu.nye.progkornyezet.vasarlasilista.service.impl;

import hu.nye.progkornyezet.vasarlasilista.model.Genre;
import hu.nye.progkornyezet.vasarlasilista.model.Products;
import hu.nye.progkornyezet.vasarlasilista.model.exception.NotFoundException;
import hu.nye.progkornyezet.vasarlasilista.service.VasarlasilistaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
    public class VasarlasilistaServiceImpl implements VasarlasilistaService {

        private static final List<Products> DB = new ArrayList<>();
        private static final List<Products> DB2 = new ArrayList<>();

        static {
            DB.add(new Products(1, "tej", "Hajdú Tej", Genre.Spar));
            DB.add(new Products(2, "kenyér", "Alföldi Pékség", Genre.Lidl));
            DB.add(new Products(3, "cola", "Coca", Genre.Aldi));
            DB.add(new Products(4, "alma", "Nyírségi Farm", Genre.Tesco));
        }

        public VasarlasilistaServiceImpl(List<Products> movies) {
        }


        @Override
        public List<Products> getAllProducts() {
            return Collections.unmodifiableList(DB);
        }

        @Override
        public Products getProducts(final int id) {
            return DB.stream()
                    .filter(products -> products.getId() == (id))
                    .findFirst()
                    .orElseThrow(NotFoundException::new);
        }

        @Override
        public void addProducts(final int id) {
            final Products products = getProducts(id);
            DB2.add(products);
        }

        @Override
        public void deleteProducts(final int id) {
            final Products products = getProducts(id);
            DB2.remove(products);
        }

        @Override
        public List<Products> getAllProductsProfile() {
            return Collections.unmodifiableList(DB2);
        }

    }
