package pe.upc.pc2logistipro.Inventory.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.pc2logistipro.Inventory.domain.model.aggregates.ProductReview;
import pe.upc.pc2logistipro.Inventory.domain.services.ProductReviewQueryService;
import pe.upc.pc2logistipro.Inventory.infrastructure.persistence.jpa.repositories.ProductReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductReviewQueryServiceImpl implements ProductReviewQueryService {
    private final ProductReviewRepository productReviewRepository;

    public ProductReviewQueryServiceImpl(ProductReviewRepository productReviewRepository) {
        this.productReviewRepository = productReviewRepository;
    }

    @Override
    public List<ProductReview> getProductReviewsByProductId(Long productId) {
        return productReviewRepository.findByProductId(productId);
    }

    @Override
    public Optional<ProductReview> getProductReviewById(Long productReviewId) {
        return productReviewRepository.findById(productReviewId);
    }

}
