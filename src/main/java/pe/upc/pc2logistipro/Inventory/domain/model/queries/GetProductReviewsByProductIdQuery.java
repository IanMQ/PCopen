package pe.upc.pc2logistipro.Inventory.domain.model.queries;

public record GetProductReviewsByProductIdQuery(
    Long productId
) {
    public GetProductReviewsByProductIdQuery {
        if (productId == null || productId <= 0) {
            throw new IllegalArgumentException("Product ID must be a positive number");
        }
    }
}
