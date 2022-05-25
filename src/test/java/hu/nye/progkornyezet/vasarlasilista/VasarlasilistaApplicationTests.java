package hu.nye.progkornyezet.vasarlasilista;

import hu.nye.progkornyezet.vasarlasilista.model.Genre;
import hu.nye.progkornyezet.vasarlasilista.model.Products;
import hu.nye.progkornyezet.vasarlasilista.model.exception.NotFoundException;
import hu.nye.progkornyezet.vasarlasilista.service.VasarlasilistaService;
import hu.nye.progkornyezet.vasarlasilista.service.impl.VasarlasilistaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class VasarlasilistaApplicationTests {
	private static final Products TEJ = new Products(1, "tej", "Hajdú Tej", Genre.Spar);
	private static final Products KENYÉR = new Products(2, "kenyér", "Alföldi Pékség", Genre.Lidl);
	private static final Products COLA = new Products(3, "cola", "Coca", Genre.Aldi);
	private static final Products ALMA = new Products(4, "alma", "Nyírség Farm", Genre.Tesco);
	private static final List<Products> MOVIES = List.of(
			TEJ,
			KENYÉR,
			COLA,
			ALMA
	);
	private static final List<Products> DATABASE = new ArrayList<>();
	private static final List<Products> DATABASE2 = new ArrayList<>();

	static {
		DB.add(new Products(1, "tej", "Hajdú Tej", Genre.Spar));
		DB.add(new Products(2, "kenyér", "Alföldi Pékség", Genre.Lidl));
		DB.add(new Products(3, "cola", "Coca", Genre.Aldi));
		DB.add(new Products(4, "alma", "Nyírség Farm", Genre.Tesco));
	}

	private static final List<Products> PROFILEMOVIES = List.of(

	);
	public static final int UNKNOWN_PRODUCTS_ID = -1;


	private VasarlasilistaService underTest;

	@BeforeEach
	void setUp() {
		underTest = new VasarlasilistaService(MOVIES);
	}

	@Test
	void getAllProductsShouldReturnAllProducts() {
		// when
		final List<Products> actual = underTest.getAllProducts();
		// then
		assertThat(actual).isEqualTo(PRODUCTS);
	}

	@Test
	void getProductsShouldReturnProductsWhenGivenIdOfExistingProducts() {
		// when
		final Products actual = underTest.getProducts(TEJ.getId());
		// then
		assertThat(actual).isEqualTo(TEJ);
	}

	@Test
	void getProductsShouldThrowNotFoundExceptionWhenGivenIdOfNotExistingProducts() {
		// when then
		assertThrows(NotFoundException.class, () -> underTest.getProducts(UNKNOWN_PRODUCTS_ID));
	}

	@Test
	void getAllProductsProfileShouldReturnAllProductsFromProfile() {
		// when
		final List<Products> actual = underTest.getAllProductsProfile();
		// then
		assertThat(actual).isEqualTo(PROFILEPRODUCTS);
	}
}