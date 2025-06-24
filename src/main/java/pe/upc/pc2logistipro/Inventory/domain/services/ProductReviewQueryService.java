package pe.upc.pc2logistipro.Inventory.domain.services;

import pe.upc.pc2logistipro.Inventory.domain.model.aggregates.ProductReview;

import java.util.List;
import java.util.Optional;

public interface ProductReviewQueryService {
    /**
     * Retrieves product reviews by product ID.
     *
     * @param productId the ID of the product for which to retrieve reviews
     * @return a list of product reviews associated with the specified product ID
     */
    List<ProductReview> getProductReviewsByProductId(Long productId);
    Optional<ProductReview> getProductReviewById(Long productReviewId);


}
