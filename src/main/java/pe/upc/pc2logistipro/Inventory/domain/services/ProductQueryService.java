package pe.upc.pc2logistipro.Inventory.domain.services;

import pe.upc.pc2logistipro.Inventory.domain.model.aggregates.Product;
import pe.upc.pc2logistipro.Inventory.domain.model.queries.GetProductByIdQuery;

import java.util.Optional;

public interface ProductQueryService {
    Optional<Product> handle(GetProductByIdQuery query);
}
