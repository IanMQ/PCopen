package pe.upc.pc2logistipro.Inventory.interfaces.rest.resources;

import pe.upc.pc2logistipro.Inventory.domain.model.valueobjects.ProductReviewCriterion;

public record ProductReviewResource(
        Long productReviewId,
        String userEmail,
        int rating,
        ProductReviewCriterion reviewCriterion,
        String comment
) {
}
