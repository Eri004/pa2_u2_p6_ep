package ec.edu.uce;



import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.ClienteService;
import ec.edu.uce.application.service.EmpleadoService;
import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.model.Pedido;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);

    }

    public static class App implements QuarkusApplication {

        @Inject
        private ClienteService clienteService;

         
     
        @Override
        public int run(String... args) throws Exception {

              Cliente cliente = new Cliente();
                cliente.setCedula("1234567890");
                cliente.setNombre("Juan Perez");
            
                
            Pedido p1 = new Pedido();
                p1.setFecha(LocalDate.now());
                p1.setCliente(cliente);
                p1.setTotal(100L);
            Pedido p2 = new Pedido();
                p2.setFecha(LocalDate.now());
                p2.setCliente(cliente);
                p2.setTotal(200L);

                ArrayList<Pedido> pedidos = new ArrayList<>();
                pedidos.add(p1);
                pedidos.add(p2);
                
                cliente.setPedidos(pedidos);

                clienteService.guardar(cliente);
               


        
            
            return 0;
        }
    }
}
