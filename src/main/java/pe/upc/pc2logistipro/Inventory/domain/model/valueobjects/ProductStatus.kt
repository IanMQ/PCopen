package pe.upc.pc2logistipro.Inventory.domain.model.valueobjects

enum class ProductStatus(val id: Int, val nombre: String, val descripcion: String) {
    AVAILABLE(1, "AVAILABLE", "El producto está en stock y disponible para la venta."),
    OUT_OF_STOCK(2, "OUT_OF_STOCK", "El producto está agotado y no se puede comprar en este momento."),
    DISCONTINUED(3, "DISCONTINUED", "El producto ha sido descontinuado y ya no se fabrica ni se vende."),
    PENDING(4, "PENDING", "El producto está en proceso de fabricación o de nuevo stock."),
    BACKORDER(5, "BACKORDER", "El producto no está disponible, pero se puede pedir bajo pedido y llegará más tarde.");
}