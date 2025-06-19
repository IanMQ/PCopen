package pe.upc.pc2logistipro.Inventory.interfaces.rest.resources;

import pe.upc.pc2logistipro.Inventory.domain.model.valueobjects.ProductStatus;

public record CreateProductResource(
        String name,
        String description,
        ProductStatus status
) {
}
