package com.proyectospring.proyecto;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

// La anotación @Configuration indica que esta clase contiene definiciones de beans
// que deben ser gestionados por el contenedor de Spring. Es equivalente a declarar
// un archivo de configuración XML, pero usando Java.
//
// Las clases marcadas con @Configuration se utilizan comúnmente para definir beans
// manualmente con @Bean, o para habilitar configuraciones personalizadas como la
// carga de archivos de propiedades externos, perfiles, etc.
// Una bean es un objeto de java gestionado por el contenedor de Springboot
@Configuration
@PropertySources({
    @PropertySource("classpath:textosPrompts.properties")
})
public class TextosPropertiesConfig {
    
}
