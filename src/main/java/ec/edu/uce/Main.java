package ec.edu.uce;



import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.AlumnoService;
import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.ClienteService;
import ec.edu.uce.application.service.CuentaService;
import ec.edu.uce.application.service.EmpleadoService;
import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.application.service.MateriaService;
import ec.edu.uce.application.service.TransferenciaService;
import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.model.Cuenta;
import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.model.Materia;
import ec.edu.uce.domain.model.Pedido;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);

    }

    public static class App implements QuarkusApplication {

    
        @Inject
        TransferenciaService transferenciaService;

        @Inject 
        CuentaService cuentaService;
         
     
        @Override
        public int run(String... args) throws Exception {

            
            /* Cuenta cuenta1 = new Cuenta();
            cuenta1.setNumeroCuenta("220401739206");
            cuenta1.setSaldo(new BigDecimal("1000.00"));

            Cuenta cuenta2 = new Cuenta();
            cuenta2.setNumeroCuenta("220401739207");
            cuenta2.setSaldo(new BigDecimal("500.00"));

            cuentaService.crearCuenta(cuenta1);
            cuentaService.crearCuenta(cuenta2); */

            

            transferenciaService.transferir("220401739206", "220401739207", new BigDecimal("200.00"));

            return 0;
          
        }
    }
}
