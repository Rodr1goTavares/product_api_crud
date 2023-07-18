package br.com.microsservice.productmanager.app.dto;

import br.com.microsservice.productmanager.app.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDTO {

    private Long id = null;

    @NotBlank
    @Size(min = 2)
    private String name;

    @NotBlank
    @Size(min = 50)
    private String description;

    @PositiveOrZero
    private double price;

    private boolean available;

    public ProductDTO(String name, String description, double price, boolean available) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
    }

    public Product toProduct() {
        return new Product(this.name, this.description, this.price, isAvailable());
    }

    public static ProductDTO toDto(Product product) {
        ProductDTO productDto = new ProductDTO(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.isAvailable()
            );
        productDto.setId(product.getId());
        return productDto;
    }
}
