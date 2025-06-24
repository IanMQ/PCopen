package pe.upc.pc2logistipro.Inventory.domain.services;

import pe.upc.pc2logistipro.Inventory.domain.model.aggregates.ProductReview;
import pe.upc.pc2logistipro.Inventory.domain.model.commands.CreateProductReviewCommand;
import pe.upc.pc2logistipro.Inventory.domain.model.commands.DeleteProductReviewCommand;

import java.util.Optional;

public interface ProductReviewCommandService {
    Optional<ProductReview> handle(CreateProductReviewCommand command);
    void handle(DeleteProductReviewCommand command);
}
