package kitchenpos.fixture;

import kitchenpos.domain.Product;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductFixture {
    public static Product generateProduct() {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName("간장 치킨");
        product.setPrice(BigDecimal.valueOf(10000));
        return product;
    }
}
