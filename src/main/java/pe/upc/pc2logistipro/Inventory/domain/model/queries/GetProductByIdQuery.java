package pe.upc.pc2logistipro.Inventory.domain.model.queries;

public record GetProductByIdQuery(
        Long productId
) {
    public GetProductByIdQuery {
        if (productId == null || productId <= 0) {
            throw new IllegalArgumentException("Product ID must be a positive number");
        }
    }
}
