package kitchenpos.application;

import kitchenpos.domain.MenuRepository;
import kitchenpos.domain.Product;
import kitchenpos.domain.ProductRepository;
import kitchenpos.fixture.ProductFixture;
import kitchenpos.infra.PurgomalumClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    private ProductRepository productRepository = new InMemoryProductRepository();

    private MenuRepository menuRepository = new InMemoryMenuRepository();

    @Mock
    private PurgomalumClient purgomalumClient;

    //    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService(productRepository, menuRepository, purgomalumClient);
    }

    @Test
    void create() {
        //given
        given(productRepository.save(any())).willReturn(new Product());
        Product product = ProductFixture.generateProduct();

        //when
        productService.create(product);

        //then
        verify(productRepository).save(any());
    }
}
