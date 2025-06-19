package pe.upc.pc2logistipro.Inventory.domain.model.valueobjects

enum class ProductReviewCriterion(val id: Int, val nombre: String, val descripcion: String) {
    PERFORMANCE(1, "PERFORMANCE", "Evalúa el rendimiento general del producto (velocidad, eficiencia, etc.)."),
    DESIGN(2, "DESIGN", "Refleja la estética y el diseño del producto (ergonomía, apariencia visual)."),
    USER_FRIENDLINESS(3, "USER_FRIENDLINESS", "Mide cuán fácil es usar el producto (interfaz, accesibilidad, manuales)."),
    DURABILITY(4, "DURABILITY", "Evalúa la durabilidad y la resistencia del producto a largo plazo."),
    VALUE_FOR_MONEY(5, "VALUE_FOR_MONEY", "Determina si el producto ofrece una buena relación calidad-precio."),
    PACKAGING(6, "PACKAGING", "Analiza el embalaje del producto (protección, facilidad de apertura, diseño).");
}