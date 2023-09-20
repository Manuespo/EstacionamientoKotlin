fun main() {
    val estacionamiento = Estacionamiento(tarifaPorHora = 100.0) // Tarifa por hora

    while (true) {
        println("Seleccione una opción:")
        println("1. Estacionar un vehículo")
        println("2. Quitar un vehículo")
        println("3. Mostrar la lista de vehículos estacionados")
        println("4. Buscar un vehículo por placa e imprimir sus detalles")
        println("5. Mostrar el costo total del estacionamiento")
        println("6. Salir")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("Ingrese los detalles del vehículo:")
                print("Marca: ")
                val marca = readLine() ?: ""
                print("Modelo: ")
                val modelo = readLine() ?: ""
                print("Placa: ")
                val placa = readLine() ?: ""
                print("Color: ")
                val color = readLine() ?: ""

                val vehiculo = Vehiculo(marca, modelo, placa, color)
                estacionamiento.estacionarVehiculo(vehiculo)
                println("Vehículo estacionado con éxito.")
            }
            2 -> {
                println("Ingrese la placa del vehículo a quitar:")
                val placa = readLine() ?: ""
                estacionamiento.quitarVehiculo(placa)
                println("Vehículo retirado con éxito.")
            }
            3 -> {
                estacionamiento.mostrarVehiculosEstacionados()
            }
            4 -> {
                println("Ingrese la placa del vehículo a buscar:")
                val placa = readLine() ?: ""
                val vehiculo = estacionamiento.buscarVehiculoPorPlaca(placa)
                if (vehiculo != null) {
                    println("Detalles del vehículo:")
                    println("Marca: ${vehiculo.marca}")
                    println("Modelo: ${vehiculo.modelo}")
                    println("Placa: ${vehiculo.placa}")
                    println("Color: ${vehiculo.color}")
                } else {
                    println("Vehículo no encontrado en el estacionamiento.")
                }
            }
            5 -> {
                println("Ingrese la placa del vehículo para calcular el costo:")
                val placa = readLine() ?: ""
                val vehiculo = estacionamiento.buscarVehiculoPorPlaca(placa)
                if (vehiculo != null) {
                    println("Ingrese la cantidad de horas estacionadas:")
                    val horasEstacionado = readLine()?.toIntOrNull() ?: 0
                    val costo = estacionamiento.calcularCostoEstacionamiento(placa, horasEstacionado)
                    println("Costo del estacionamiento: $costo")
                } else {
                    println("Vehículo no encontrado en el estacionamiento.")
                }
            }
            6 -> {
                println("Programa terminado")
                return
            }
            else -> {
                println("Opción no válida. Inténtelo de nuevo.")
            }
        }
    }
}