package pe.upc.pc2logistipro.Inventory.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.upc.pc2logistipro.Inventory.domain.model.commands.CreateProductCommand;
import pe.upc.pc2logistipro.Inventory.domain.model.valueobjects.ProductStatus;
import pe.upc.pc2logistipro.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.List;
import java.util.UUID;

@Getter
@Entity
public class Product extends AuditableAbstractAggregateRoot<Product> {

    @Setter
    private UUID productCode;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    private ProductStatus status;

    @Setter
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductReview> reviews;
    //La propiedad reviews es una lista que contiene todas las reseñas asociadas al producto.

    public Product() {
        this.productCode = UUID.randomUUID(); // Genera un UUID único para el producto
        this.name = "";
        this.description = "";
        this.status = ProductStatus.PENDING; // Estado por defecto
    }

    public Product(CreateProductCommand command) {
        if (command == null) {
            throw new IllegalArgumentException("CreateProductCommand cannot be null");
        }
        this.productCode = UUID.randomUUID(); // Genera un UUID único para el producto
        this.name = command.name();
        this.description = command.description();
        this.status = command.status();
    }
}
