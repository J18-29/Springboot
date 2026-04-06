package com.example.demo.model;
public class Producto {
 private String nombre;
 private String descripcion;
 private String imagen;
 private String categoria;
 private double precio;
 public Producto(){}
 public Producto(String nombre, String descripcion, String imagen, double precio, String categoria) {
 this.nombre = nombre;
 this.descripcion = descripcion;
 this.imagen = imagen;
 this.precio = precio;
 this.categoria = categoria;
 }
 //Ahora mismo vamos a consultar cosas
 public String getNombre() { return nombre; }
 public String getDescripcion() { return descripcion; }
 public String getImagen() { return imagen; }
 public double getPrecio() { return precio; }
 public String getCategoria() { return categoria; }
}