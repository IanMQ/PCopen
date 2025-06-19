package pe.upc.pc2logistipro.Inventory.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import pe.upc.pc2logistipro.Inventory.application.internal.commandservices.ProductCommandServiceImpl;
import pe.upc.pc2logistipro.Inventory.application.internal.queryservices.ProductQueryServiceImpl;
import pe.upc.pc2logistipro.Inventory.domain.model.aggregates.Product;
import pe.upc.pc2logistipro.Inventory.domain.model.commands.DeleteProductCommand;
import pe.upc.pc2logistipro.Inventory.domain.model.queries.GetProductByIdQuery;
import pe.upc.pc2logistipro.Inventory.interfaces.rest.resources.CreateProductResource;
import pe.upc.pc2logistipro.Inventory.interfaces.rest.resources.ProductResource;
import pe.upc.pc2logistipro.Inventory.interfaces.rest.transform.CreateProductCommandFromResourceAssembler;
import pe.upc.pc2logistipro.Inventory.interfaces.rest.transform.ProductResourceFromEntityAssembler;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/products",produces = APPLICATION_JSON_VALUE)
@Tag(name = "Product", description = "Available Product Endpoints")
public class ProductController {
    private final ProductCommandServiceImpl productCommandService;
    private final ProductQueryServiceImpl productQueryService;

    public ProductController(ProductCommandServiceImpl productCommandService,
                             ProductQueryServiceImpl productQueryService)  {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
    }

    @PostMapping
    @Operation(summary = "Create a product", description = "Create a product")
    public ResponseEntity<?> createProduct(@RequestBody CreateProductResource resource) {
        try {
            var createProductCommand = CreateProductCommandFromResourceAssembler.toCommandFromResource(resource);
            var createdProduct = productCommandService.handle(createProductCommand).orElseThrow(() ->
                    new IllegalArgumentException("Error creating product"));
            return ResponseEntity.status(201).body(createdProduct);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(400).body(ex.getMessage());
        }
    }

    @DeleteMapping("{productId}")
    @Operation(summary = "Delete a product", description = "Delete a product by id")
    public void deleteProduct(@PathVariable Long productId) {
        var deleteProductCommand = new DeleteProductCommand(productId);
        productCommandService.handle(deleteProductCommand);
    }

    @GetMapping("{productId}")
    @Operation(summary = "Get product by id", description = "Get product by id")
    public ResponseEntity<ProductResource> getProductById(@PathVariable Long productId) {
        var query = new GetProductByIdQuery(productId);
        var productOptional = productQueryService.handle(query);
        if (productOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(productOptional.get());
        return ResponseEntity.ok(productResource);
    }


}
