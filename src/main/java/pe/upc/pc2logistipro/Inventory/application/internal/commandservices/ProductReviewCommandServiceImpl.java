package pe.upc.pc2logistipro.Inventory.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.upc.pc2logistipro.Inventory.domain.model.aggregates.ProductReview;
import pe.upc.pc2logistipro.Inventory.domain.model.commands.CreateProductReviewCommand;
import pe.upc.pc2logistipro.Inventory.domain.model.commands.DeleteProductReviewCommand;
import pe.upc.pc2logistipro.Inventory.domain.services.ProductReviewCommandService;
import pe.upc.pc2logistipro.Inventory.infrastructure.persistence.jpa.repositories.ProductRepository;
import pe.upc.pc2logistipro.Inventory.infrastructure.persistence.jpa.repositories.ProductReviewRepository;

import java.util.Optional;

@Service
public class ProductReviewCommandServiceImpl implements ProductReviewCommandService {
    private final ProductReviewRepository productReviewRepository;
    private final ProductRepository productRepository;

    public ProductReviewCommandServiceImpl(ProductReviewRepository productReviewRepository,ProductRepository productRepository) {
        this.productReviewRepository = productReviewRepository;
        this.productRepository = productRepository;
    }

    // Implement methods for handling commands related to product reviews
    @Override
    public Optional<ProductReview> handle(CreateProductReviewCommand command) {
        // Logic to create a product review
        // Example: Validate command, create ProductReview entity, save to repository
        var product = productRepository.findById(command.productId())
                .orElseThrow(() -> new IllegalArgumentException("Product with id %s not found".formatted(command.productId())));
        var productReview = new ProductReview(command, product);
        try{
            productReviewRepository.save(productReview);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving the product review: %s".formatted(e.getMessage()));
        }
        return Optional.of(productReview);
    }

    @Override
    public void handle(DeleteProductReviewCommand command) {
        // Logic to delete a product review
        // Example: Validate command, check if review exists, delete from repository
        if (!productReviewRepository.existsById(command.productReviewId())) {
            throw new IllegalArgumentException("Product review with id %s not found".formatted(command.productReviewId()));
        }
        try {
            productReviewRepository.deleteById(command.productReviewId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error deleting product review: %s".formatted(e.getMessage()));
        }
    }
}
