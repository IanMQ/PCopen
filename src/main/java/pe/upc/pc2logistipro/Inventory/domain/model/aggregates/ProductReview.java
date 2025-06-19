package pe.upc.pc2logistipro.Inventory.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import pe.upc.pc2logistipro.Inventory.domain.model.valueobjects.ProductReviewCriterion;
import pe.upc.pc2logistipro.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Getter
public class ProductReview extends AuditableAbstractAggregateRoot<ProductReview> {
    @Setter
    private String userEmail;
    @Setter
    private Integer rating;
    @Setter
    private ProductReviewCriterion reviewCriterion;
    @Setter
    private String comment;

    @Setter
    @ManyToOne
    @JoinColumn(name = "product_product_id", nullable = false)
    private Product product;
    //La anotación @ManyToOne establece que cada reseña está asociada a un único producto.

    public ProductReview() {
        this.userEmail = "";
        this.rating = 0;
        this.comment = "";
        this.product = null; // Inicialmente no está asociado a ningún producto
    }

}
