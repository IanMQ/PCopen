package pe.upc.pc2logistipro.Inventory.interfaces.rest.transform;

import pe.upc.pc2logistipro.Inventory.domain.model.commands.CreateProductCommand;
import pe.upc.pc2logistipro.Inventory.interfaces.rest.resources.CreateProductResource;

public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommandFromResource(CreateProductResource resource) {
        return new CreateProductCommand(
                resource.name(),
                resource.description(),
                resource.status()
        );
    }
}
