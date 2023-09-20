class Vehiculo(
    val marca: String,
    val modelo: String,
    val placa: String,
    val color: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vehiculo

        if (marca != other.marca) return false
        if (modelo != other.modelo) return false
        if (placa != other.placa) return false
        return color == other.color
    }

    override fun hashCode(): Int {
        var result = marca.hashCode()
        result = 31 * result + modelo.hashCode()
        result = 31 * result + placa.hashCode()
        result = 31 * result + color.hashCode()
        return result
    }

    override fun toString(): String {
        return "Vehiculo(marca='$marca', modelo='$modelo', placa='$placa', color='$color')"
    }

}