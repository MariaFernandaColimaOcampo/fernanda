package mx.edu.utez.proyecto1D.controller;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto1D.controller.dto.RequestBodyDTO;
import mx.edu.utez.proyecto1D.controller.dto.RequestCalculadoraDTO;
import mx.edu.utez.proyecto1D.controller.dto.ResponseCalculadoraDTO;
import mx.edu.utez.proyecto1D.service.MyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/my-services")
public class MyController {

    private final MyService myService;

    public MyController(MyService myService){
        this.myService =myService;
    }
    @GetMapping
    public String miprimerservicio() {
        System.out.println("holamundo");
        return "hello world";
    }

    @GetMapping("/segundoservicio")
    public String serviciodos() {
        return "este es mi segundo serv bots";
    }

    @PostMapping
    public String servtres() {
        return "tercer servicio bots";
    }

    @GetMapping("/pathVariable/{id}")
    public String pathvariable(@PathVariable String id) {
        System.out.println("Id" + id);
        return "Id: " + id;
    }

    @PostMapping("/request-body")
    public ResponseEntity<RequestBodyDTO> requetsbody(@RequestBody @Valid RequestBodyDTO payload) {
        System.out.println(payload.getNombre());
        System.out.println(payload.getEdad());
        System.out.println(payload.getCorreo());

        return ResponseEntity
                .status(201).body(payload);
    }

    @PostMapping("/calculadora")
    public ResponseEntity<ResponseCalculadoraDTO> calculadora
            (@RequestBody @Valid RequestCalculadoraDTO payload){

        return ResponseEntity
                .status(200)
                .body(myService.calculadora(payload));

    }
}
