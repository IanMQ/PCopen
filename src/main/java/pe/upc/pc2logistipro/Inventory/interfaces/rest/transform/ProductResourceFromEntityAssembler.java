package pe.upc.pc2logistipro.Inventory.interfaces.rest.transform;

import pe.upc.pc2logistipro.Inventory.domain.model.aggregates.Product;
import pe.upc.pc2logistipro.Inventory.interfaces.rest.resources.ProductResource;

public class ProductResourceFromEntityAssembler {
    public static ProductResource toResourceFromEntity(Product product) {
        return new ProductResource(
                product.getId(),
                product.getProductCode(),
                product.getName(),
                product.getDescription(),
                product.getStatus()
        );
    }
}
