
package com.adellapo.demo.models.domain;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class Factura {

  @Value("${factura.descripcion}")
  private String             descripcion;
  @Autowired
  private Cliente            cliente;
  @Autowired
  private List <ItemFactura> items;

  static int contador;

  @PostConstruct
  public void inicializar() {

    cliente.setNombre(cliente.getNombre().concat(" " + ++contador));
    descripcion = descripcion.concat(" del cliente: " + cliente.getNombre());

  }

  @PreDestroy
  public void destruir() { System.out.println("Factura descruida: " + this.descripcion); }

  public String getDescripcion() { return descripcion; }

  public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

  public Cliente getCliente() { return cliente; }

  public void setCliente(Cliente cliente) { this.cliente = cliente; }

  public List <ItemFactura> getItems() { return items; }

  public void setItems(List <ItemFactura> items) { this.items = items; }

}
