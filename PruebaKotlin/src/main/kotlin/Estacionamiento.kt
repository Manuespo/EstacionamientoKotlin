class Estacionamiento(private val tarifaPorHora: Double) {
    private val vehiculosEstacionados = mutableListOf<Vehiculo>()

    fun estacionarVehiculo(vehiculo: Vehiculo) {
        vehiculosEstacionados.add(vehiculo)
    }

    fun quitarVehiculo(placa: String) {
        val vehiculo=vehiculosEstacionados.find { it.placa==placa }
        if (vehiculo!=null) vehiculosEstacionados.remove(vehiculo)
    }

    fun mostrarVehiculosEstacionados() {
        println("Vehículos estacionados:")
        for (vehiculo in vehiculosEstacionados) {
            println("Placa: ${vehiculo.placa}, Marca: ${vehiculo.marca}, Modelo: ${vehiculo.modelo}")
        }
    }

    fun buscarVehiculoPorPlaca(placa: String): Vehiculo? {
        return vehiculosEstacionados.find { it.placa == placa }
    }

    fun contarVehiculosEstacionados(): Int {
        return vehiculosEstacionados.size
    }

    fun calcularCostoEstacionamiento(placa: String, horasEstacionado: Int): Double {
        val vehiculo = buscarVehiculoPorPlaca(placa)
        if (vehiculo != null) {
            return tarifaPorHora * horasEstacionado;
        }
        return 0.0;
    }

    override fun toString(): String {
        return "Estacionamiento(tarifaPorHora=$tarifaPorHora, vehiculosEstacionados=$vehiculosEstacionados)"
    }

}