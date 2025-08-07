package com.proyectospring.proyecto.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectospring.proyecto.models.Usuario;
import com.proyectospring.proyecto.models.services.IServicio;
import com.proyectospring.proyecto.models.services.Service;

// La anotación @Controller se utiliza para indicar que esta clase es un controlador
// en una aplicación Spring MVC. Spring la detecta automáticamente durante el escaneo
// de componentes y permite manejar peticiones HTTP, devolviendo vistas (por ejemplo, HTML).
//
// A diferencia de @RestController, que devuelve directamente datos (JSON), @Controller
// se usa junto con tecnologías como Thymeleaf para renderizar páginas web.

@Controller
@RequestMapping("/app") // Cuando se establece esto como anotación de la clase se esta estableciendo que
                        // esto va a ser una ruta comun para este controlador, proporcionandola a todos
                        // los métodos miembros de esta clase. Estableciendo esta como ruta de primer
                        // nivel mientras que las rutas establecidas en los metodos serían de segundo
                        // nivel
public class IndexController {

    // Para la clase Service vamos a utilizar el paradigma Hollywood el cual se basa
    // en el que nosotros llamaremos a la clase, esta no nos llamara.

    // Tambien, voy a desaclopar la necesidad de establecer la instanciación ya que
    // he establecido esta clase como un component por lo que ya es parte del
    // contenedor.
    // Por lo que, esta anotacion (AutoWired) significa que este bean esta
    // registrado en el contenedor y lo busca, inyectandolo.

    // Pero, todavia tenemos un problema. Este método sigue estando acoplado a una
    // clase por lo que nos limita en el caso de que necesitemos combinar más
    // logicas , expandir el proyecto , etc.
    // Para arreglar esto, vamos a terminar asociando Autowired a una interfaz, lo
    // que nos permitira ser implementada por mas de una clase concreta.

    // Aquí dejo como estaba anteriormente establecido, es decir con la anterior clase
    // @Autowired
    // private Service service;


    //Y voy a añadir como valor a la interfaz
    @Autowired
    private IServicio service;

    // Usamos la anotación @Value para inyectar valores definidos en el archivo
    // application.properties, que normalmente se utiliza para almacenar
    // configuraciones externas como textos, rutas, credenciales o cualquier valor
    // configurable.

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;
    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;
    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    // @RequestMapping vincula este método a la URL "/index" (value es un alias de
    // path) y lo asocia al método HTTP GET.
    // GET → Solicita datos al servidor (ej: obtener una página o recurso).
    // POST → Envía datos al servidor (ej: enviar un formulario).
    // PUT → Actualiza un recurso existente en el servidor.
    // DELETE → Elimina un recurso del servidor.
    // @RequestParam indica que se debe recibir un parámetro de la query string
    // (?param=valor)
    // y lo asignará a la variable 'param'.
    // Tengamos en cuenta también que value es basicamente path (es literalmente
    // este)

    // También se podría hacer GetMapping , el cual es una anotación con
    // RequestMapping ya en si, si no se puede usr RequestMethod como use con
    // anterioridad
    @GetMapping(value = { "/index", "/", "/home" })
    public String index(Model model) {

        // Al utilizar Model model , se esta trabajando con el patron MVC

        // Esto devuelve el nombre de la vista (index.html) que Spring buscará en
        // src/main/resources/templates usando el motor de plantillas configurado (p.ej.
        // Thymeleaf)
        model.addAttribute("titulo", textoIndex);
        // Se tiene que tener en cuenta de que cuando se está trabajando con un espacio
        // de nombre se ha de establecer que valores este va a poder leer, ya que los
        // espacios de nombre no se cargaran si no se establece que tambien toma la raiz

        // Model es una interfaz mientras que ModelMap es una class, esta implementa
        // .map de java por lo que nos permite utilizar las capacidades de esta interfaz
        // funcional

        // Aqui estamos asociando un valor a el metodo de la clase
        model.addAttribute("servicio", service.operacion());
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Luis");
        usuario.setApellido("Gil");

        /*
         * Acordarse de que en el html, al usar la instancia añadida (en este caso la de
         * usuario), esta tendra los nombres establecidos en esta y no utilizará los
         * nombres de los atributos establecidos abajo. Los atributos / claves
         * establecidas abajo han de ser invocadas o llamadas directamente
         */
        model.addAttribute("titulo", textoPerfil);
        model.addAttribute("usuario", usuario);
        model.addAttribute("nombreUsu", "Nombre: ".concat(usuario.getNombre()));
        model.addAttribute("apellidoUsu", "Apellido: ".concat(usuario.getApellido()));
        return "perfil";
    }

    // Para mostrar una lista

    @RequestMapping("/listar")
    public String listar(Model model) {

        model.addAttribute("titulo", textoListar);
        return "listar";
    }

    /*
     * Antes de que Spring llame a cualquier método handler de este controlador
     * (getMapping, PostMapping,etc..) realiza un paso previo de preparacion. En
     * este paso busca todos los metodos del controlador que tengan @ModelAttribute
     * y
     * que NO tengan @RequestMapping, es decir que no sean handlers
     * 
     * Luego este atributo pasa a estar presente en el Model de todos los metodos
     * del controlador incluso si en esos metodos no declaramos Model model
     */
    @ModelAttribute("usuarios")
    public List<Usuario> tomandoUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("Luis", "Gil"));
        usuarios.add(new Usuario("Ana", "Yague"));
        usuarios.add(new Usuario("Marco", "Polo"));

        return usuarios;

    }

}
