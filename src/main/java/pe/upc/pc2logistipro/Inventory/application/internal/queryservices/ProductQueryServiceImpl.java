package pe.upc.pc2logistipro.Inventory.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.pc2logistipro.Inventory.domain.model.aggregates.Product;
import pe.upc.pc2logistipro.Inventory.domain.model.queries.GetProductByIdQuery;
import pe.upc.pc2logistipro.Inventory.domain.services.ProductQueryService;
import pe.upc.pc2logistipro.Inventory.infrastructure.persistence.jpa.repositories.ProductRepository;

import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {
    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> handle(GetProductByIdQuery query) {
        return productRepository.findById(query.productId());
    }
}
