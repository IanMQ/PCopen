package pe.upc.pc2logistipro.Inventory.domain.model.commands;

public record DeleteProductCommand(
        Long productId
) {
    public DeleteProductCommand {
        if (productId == null || productId <= 0) {
            throw new IllegalArgumentException("Product ID must be a positive number");
        }
    }
}
