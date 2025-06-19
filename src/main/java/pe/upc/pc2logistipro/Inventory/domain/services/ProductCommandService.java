package pe.upc.pc2logistipro.Inventory.domain.services;

import pe.upc.pc2logistipro.Inventory.domain.model.aggregates.Product;
import pe.upc.pc2logistipro.Inventory.domain.model.commands.CreateProductCommand;
import pe.upc.pc2logistipro.Inventory.domain.model.commands.DeleteProductCommand;

import java.util.Optional;

public interface ProductCommandService {
    void handle(DeleteProductCommand command);
    Optional<Product> handle(CreateProductCommand command);
}
