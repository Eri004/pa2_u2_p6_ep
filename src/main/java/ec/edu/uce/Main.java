package ec.edu.uce;


import ec.edu.uce.application.service.EstudianteService;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);

    }

    public static class App implements QuarkusApplication {
        
        @Inject
        EstudianteService estudianteService;

        @Override
        @Transactional
        public int run(String... args) throws Exception {
            
          System.out.println(this.estudianteService.listarPorCedula("0400125643").toString());




                    

            return 0;
        }
    }
}
