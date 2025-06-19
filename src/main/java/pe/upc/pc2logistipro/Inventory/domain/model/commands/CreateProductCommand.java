package pe.upc.pc2logistipro.Inventory.domain.model.commands;

import pe.upc.pc2logistipro.Inventory.domain.model.valueobjects.ProductStatus;

public record CreateProductCommand(
        String name,
        String description,
        ProductStatus status
) {
    public CreateProductCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        name = name.trim();
        if (name.length() > 100) {
            throw new IllegalArgumentException("Name cannot exceed 100 characters");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        if (description.length() > 500) {
            throw new IllegalArgumentException("Description cannot exceed 500 characters");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
    }
}
