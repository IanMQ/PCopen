package pe.upc.pc2logistipro.Inventory.domain.model.queries;

public record GetProductReviewByIdQuery(
    Long productReviewId
) {
    public GetProductReviewByIdQuery {
        if (productReviewId == null || productReviewId <= 0) {
            throw new IllegalArgumentException("Product review ID must be a positive number");
        }
    }
}
