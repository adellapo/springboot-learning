package com.adellapo.demo.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
 * Si hay multiples implementaciones de un servicio va haber un conflicto
 * al momento de inyectar las dependencias. Para que Spring sepa que usar hay que
 * o marcarlo con @Primary, cosa que en caso de conflicto levante una implementacion
 * especifica, o usar @Qualifier("[nombreDelServicio]") pegado al @Autowired, para que
 * Spring sepa que implementacion inyectar.
 * 
 * @Qualifier > @Primary
 * Entonces si tenemos ambas Spring va a usar la implementacion
 * marcada con Qualifier
 * 
 */
//@Primary 
//@Component("miServicioSimple")
public class MiServicio implements IServicio{

	@Override
	public String operacion() {
		return "ejecutando algún proceso importante simple.....";
	}
}
