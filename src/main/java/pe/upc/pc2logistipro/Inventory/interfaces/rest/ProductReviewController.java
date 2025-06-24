package pe.upc.pc2logistipro.Inventory.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.pc2logistipro.Inventory.application.internal.commandservices.ProductReviewCommandServiceImpl;
import pe.upc.pc2logistipro.Inventory.application.internal.queryservices.ProductReviewQueryServiceImpl;
import pe.upc.pc2logistipro.Inventory.domain.model.commands.DeleteProductReviewCommand;
import pe.upc.pc2logistipro.Inventory.interfaces.rest.resources.CreateProductReviewResource;
import pe.upc.pc2logistipro.Inventory.interfaces.rest.transform.CreateProductReviewCommandFromResourceAssembler;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/products/{productId}/reviews",produces = APPLICATION_JSON_VALUE)
@Tag(name = "ProductReview", description = "Available ProductReview Endpoints")
public class ProductReviewController {
    private final ProductReviewCommandServiceImpl productReviewCommandService;
    private final ProductReviewQueryServiceImpl productReviewQueryService;

    public ProductReviewController(ProductReviewCommandServiceImpl productReviewCommandService,
                                   ProductReviewQueryServiceImpl productReviewQueryService) {
        this.productReviewCommandService = productReviewCommandService;
        this.productReviewQueryService = productReviewQueryService;
    }

    @PostMapping
    @Operation(summary = "Create a product review", description = "Create a product review")
    public ResponseEntity<?> createProductReview(@RequestBody CreateProductReviewResource resource,@PathVariable Long productId) {
        try{
            var createProductReviewCommand = CreateProductReviewCommandFromResourceAssembler
                    .toCommandFromResource(resource, productId);
            var createdProductReview = productReviewCommandService.handle(createProductReviewCommand)
                .orElseThrow(() -> new IllegalArgumentException("Error creating product review"));
            return ResponseEntity.status(201).body(createdProductReview);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(400).body(ex.getMessage());
        }
    }

    @GetMapping
    @Operation(summary = "Get all product reviews", description = "Get all product reviews for a product")
    public ResponseEntity<?> getAllProductReviews(@PathVariable Long productId) {
        var query = productReviewQueryService.getProductReviewsByProductId(productId);
        if (query.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(query);
    }

    //EXTRAS

    @DeleteMapping("{productReviewId}")
    @Operation(summary = "Delete a product review", description = "Delete a product review by id")
    public void deleteProductReview(@PathVariable Long productId, @PathVariable Long productReviewId) {
        var deleteProductReviewCommand = new DeleteProductReviewCommand(productReviewId);
        productReviewCommandService.handle(deleteProductReviewCommand);
    }

    @GetMapping("{productReviewId}")
    @Operation(summary = "Get product review by id", description = "Get product review by id")
    public ResponseEntity<?> getProductReviewById(@PathVariable Long productId, @PathVariable Long productReviewId) {
        var query = productReviewQueryService.getProductReviewById(productReviewId);
        if (query.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(query.get());
    }


}
