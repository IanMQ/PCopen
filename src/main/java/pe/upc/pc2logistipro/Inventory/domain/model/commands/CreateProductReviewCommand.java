package pe.upc.pc2logistipro.Inventory.domain.model.commands;

import pe.upc.pc2logistipro.Inventory.domain.model.valueobjects.ProductReviewCriterion;

public record CreateProductReviewCommand(
    String userEmail,
    Integer rating,
    ProductReviewCriterion reviewCriterion,
    String comment,
    Long productId
) {
    public CreateProductReviewCommand {
        if (userEmail == null || userEmail.isBlank()) {
            throw new IllegalArgumentException("User email cannot be null or empty");
        }
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        if (reviewCriterion == null) {
            throw new IllegalArgumentException("Review criterion cannot be null");
        }
        if (comment == null || comment.isBlank()) {
            throw new IllegalArgumentException("Comment cannot be null or empty");
        }
        if (productId == null || productId <= 0) {
            throw new IllegalArgumentException("Product ID must be a positive number");
        }
    }
}
