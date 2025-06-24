package pe.upc.pc2logistipro.Inventory.interfaces.rest.resources;

import pe.upc.pc2logistipro.Inventory.domain.model.valueobjects.ProductReviewCriterion;

public record CreateProductReviewResource(
        String userEmail,
        Integer rating,
        ProductReviewCriterion reviewCriterion,
        String comment
) {
}
