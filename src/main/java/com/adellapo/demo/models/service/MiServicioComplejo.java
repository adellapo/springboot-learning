package com.adellapo.demo.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


//@Component("miServicioComplejo") --> comentado porque se hizo con @Bean
public class MiServicioComplejo implements IServicio{

	@Override
	public String operacion() {
		return "ejecutando algún proceso importante complicado.....";
	}
}
