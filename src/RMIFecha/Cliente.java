/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package RMIFecha;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class Cliente {

    public static void main(String[] args) {
        
        //Definir la hora que queremos tomar la hora
        ZoneId zonaHoraria = ZoneId.of("America/Lima");
        
        // Obtener la fecha y hora actual en esa zona horaria
        ZonedDateTime fechaHoraActual = ZonedDateTime.now(zonaHoraria);
        
        // Formatear la fecha y hora
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        //Conseguir la fecha y hora formateada
        String fechaHoraFormateada = fechaHoraActual.format(formato);

        try {
            // Buscar el registro RMI
            Registry registry = LocateRegistry.getRegistry("10.194.0.4", 8080);

            // Obtener la referencia al servicio remoto
            Fecha fecha = (Fecha) registry.lookup("FechaService");

            //Mandar la hora actual al servidor
            fecha.horaActual(fechaHoraFormateada);
            System.out.println("La fecha y hora actual fueron enviados correctamente al servidor");
            
        } catch (Exception e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
