package pe.upc.pc2logistipro.Inventory.interfaces.rest.transform;

import pe.upc.pc2logistipro.Inventory.domain.model.aggregates.ProductReview;
import pe.upc.pc2logistipro.Inventory.interfaces.rest.resources.CreateProductReviewResource;

public class ProductReviewResourceFromEntityAssembler {
    public static CreateProductReviewResource toResourceFromEntity(ProductReview productReview) {
        return new CreateProductReviewResource(
                productReview.getUserEmail(),
                productReview.getRating(),
                productReview.getReviewCriterion(),
                productReview.getComment()
        );
    }

}
