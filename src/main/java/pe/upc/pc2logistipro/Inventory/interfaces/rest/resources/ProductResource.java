package pe.upc.pc2logistipro.Inventory.interfaces.rest.resources;

import pe.upc.pc2logistipro.Inventory.domain.model.valueobjects.ProductStatus;

import java.util.UUID;

public record ProductResource(
        Long productId,
        UUID productCode,
        String name,
        String description,
        ProductStatus status

) {
}
