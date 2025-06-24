package pe.upc.pc2logistipro.Inventory.interfaces.rest.transform;

import pe.upc.pc2logistipro.Inventory.domain.model.commands.CreateProductReviewCommand;
import pe.upc.pc2logistipro.Inventory.interfaces.rest.resources.CreateProductReviewResource;

public class CreateProductReviewCommandFromResourceAssembler {
    public static CreateProductReviewCommand toCommandFromResource(CreateProductReviewResource resource, long productId) {
         return new CreateProductReviewCommand(
                resource.userEmail(),
                 resource.rating(),
                 resource.reviewCriterion(),
                 resource.comment(),
                 productId
         );
     }
}
