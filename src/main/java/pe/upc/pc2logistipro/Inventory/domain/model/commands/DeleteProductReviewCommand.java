package pe.upc.pc2logistipro.Inventory.domain.model.commands;

public record DeleteProductReviewCommand(
    Long productReviewId
) {
    public DeleteProductReviewCommand {
        if (productReviewId == null || productReviewId <= 0) {
            throw new IllegalArgumentException("Product review ID must be a positive number");
        }
    }
}
