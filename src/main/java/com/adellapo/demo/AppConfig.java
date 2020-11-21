package com.adellapo.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adellapo.demo.models.domain.ItemFactura;
import com.adellapo.demo.models.domain.Producto;
import com.adellapo.demo.models.service.IServicio;
import com.adellapo.demo.models.service.MiServicio;
import com.adellapo.demo.models.service.MiServicioComplejo;

@Configuration
public class AppConfig {

	@Bean("miServicioSimple")
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}

	@Bean("miServicioComplejo")
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}

	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems() {
		
		Producto producto1 = new Producto("Camara Sony", 100);
		Producto producto2 = new Producto("Bicicleta Bianchi aro 26", 200);

		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 4);

		return Arrays.asList(linea1, linea2);

	}

}
