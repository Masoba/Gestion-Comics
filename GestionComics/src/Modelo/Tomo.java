
package Modelo;

import java.sql.*;
import util.Conexion;
import java.util.Date;
import javax.swing.*;


public class Tomo {
    private int IDTomo;
    private String portada;
    private double precio;
    private String editorialUSA;
    private String editorialESP;
    private String superheroe;
    private String titulo;
    private String genero;
    private String paginas;
    private String fechaEdicion;
    private String guionista;
    private String dibujante;
    private String link;
    private String tipo;
    private String coleccion;

    public String getTipo() {
        return tipo;
    }

    public Tomo(int IDTomo, String portada) {
        this.IDTomo = IDTomo;
        this.portada = portada;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColeccion() {
        return coleccion;
    }

    public void setColeccion(String coleccion) {
        this.coleccion = coleccion;
    }
    
    private Conexion conexion = new Conexion();

    public Tomo(int IDTomo, String portada, double precio, String editorialUSA, String editorialESP, String superheroe, String titulo, String genero, String paginas, String fechaEdicion, String guionista, String dibujante, String link, String comicManga, String coleccion) {
        this.IDTomo = IDTomo;
        this.portada = portada;
        this.precio = precio;
        this.editorialUSA = editorialUSA;
        this.editorialESP = editorialESP;
        this.superheroe = superheroe;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.fechaEdicion = fechaEdicion;
        this.guionista = guionista;
        this.dibujante = dibujante;
        this.link = link;
        this.tipo = comicManga;
        this.coleccion = coleccion;
    }

    public Tomo() {
    }

    public Tomo(int IDTomo, String portada, double precio, String editorialUSA, String editorialESP, String superheroe, String titulo, String genero, String paginas, String fechaEdicion, String guionista, String dibujante, String comicManga) {
        this.IDTomo = IDTomo;
        this.portada = portada;
        this.precio = precio;
        this.editorialUSA = editorialUSA;
        this.editorialESP = editorialESP;
        this.superheroe = superheroe;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.fechaEdicion = fechaEdicion;
        this.guionista = guionista;
        this.dibujante = dibujante;
        this.tipo = comicManga;
    }

    public Tomo(int IDTomo, String portada, String comicManga) {
        this.IDTomo = IDTomo;
        this.portada = portada;
        this.tipo = comicManga;
    }

    public Tomo(int IDTomo, String portada, double precio, String editorialUSA, String editorialESP, String titulo, String genero, String paginas, String fechaEdicion, String guionista, String dibujante, String comicManga) {
        this.IDTomo = IDTomo;
        this.portada = portada;
        this.precio = precio;
        this.editorialUSA = editorialUSA;
        this.editorialESP = editorialESP;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.fechaEdicion = fechaEdicion;
        this.guionista = guionista;
        this.dibujante = dibujante;
        this.tipo = comicManga;
    }

    public Tomo(int IDTomo, double precio, String editorialUSA, String editorialESP, String titulo, String genero, String paginas, String fechaEdicion, String guionista, String dibujante, String comicManga) {
        this.IDTomo = IDTomo;
        this.precio = precio;
        this.editorialUSA = editorialUSA;
        this.editorialESP = editorialESP;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.fechaEdicion = fechaEdicion;
        this.guionista = guionista;
        this.dibujante = dibujante;
        this.tipo = comicManga;
    }

    public Tomo(int IDTomo, double precio, String editorialUSA, String editorialESP, String titulo, String genero, String paginas, String fechaEdicion, String guionista, String dibujante, String link, String comicManga) {
        this.IDTomo = IDTomo;
        this.precio = precio;
        this.editorialUSA = editorialUSA;
        this.editorialESP = editorialESP;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.fechaEdicion = fechaEdicion;
        this.guionista = guionista;
        this.dibujante = dibujante;
        this.link = link;
        this.tipo = comicManga;
    }

    public int getIDTomo() {
        return IDTomo;
    }

    public void setIDTomo(int IDTomo) {
        this.IDTomo = IDTomo;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEditorialUSA() {
        return editorialUSA;
    }

    public void setEditorialUSA(String editorialUSA) {
        this.editorialUSA = editorialUSA;
    }

    public String getEditorialESP() {
        return editorialESP;
    }

    public void setEditorialESP(String editorialESP) {
        this.editorialESP = editorialESP;
    }

    public String getSuperheroe() {
        return superheroe;
    }

    public void setSuperheroe(String superheroe) {
        this.superheroe = superheroe;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(String fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public String getGuionista() {
        return guionista;
    }

    public void setGuionista(String guionista) {
        this.guionista = guionista;
    }

    public String getDibujante() {
        return dibujante;
    }

    public void setDibujante(String dibujante) {
        this.dibujante = dibujante;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
