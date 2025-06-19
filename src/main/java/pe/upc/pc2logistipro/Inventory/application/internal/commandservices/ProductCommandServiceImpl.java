package pe.upc.pc2logistipro.Inventory.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.upc.pc2logistipro.Inventory.domain.model.aggregates.Product;
import pe.upc.pc2logistipro.Inventory.domain.model.commands.CreateProductCommand;
import pe.upc.pc2logistipro.Inventory.domain.model.commands.DeleteProductCommand;
import pe.upc.pc2logistipro.Inventory.domain.services.ProductCommandService;
import pe.upc.pc2logistipro.Inventory.infrastructure.persistence.jpa.repositories.ProductRepository;

import java.util.Optional;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {
    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void handle(DeleteProductCommand command) {
        if (!productRepository.existsById(command.productId())) {
            throw new IllegalArgumentException("Product with id %s not found".formatted(command.productId()));
        }
        try {
            productRepository.deleteById(command.productId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error deleting product: %s".formatted(e.getMessage()));
        }
    }

    @Override
    public Optional<Product> handle(CreateProductCommand command) {
        var product = new Product(command);
        try {
            productRepository.save(product);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving the product: %s".formatted(e.getMessage()));
        }
        return Optional.of(product);
    }
}
