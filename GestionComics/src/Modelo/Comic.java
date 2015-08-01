
package Modelo;


public class Comic {
    private int IDComic;
    private String portada;
    private String volumen;
    private String numero;
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
    private String enlace;
    private int IDTomo;

    public Comic(int IDComic, String portada, String volumen, String numero, double precio, String editorialUSA, String editorialESP, String superheroe, String titulo, String genero, String paginas, String fechaEdicion, String guionista, String dibujante, String enlace, int IDTomo) {
        this.IDComic = IDComic;
        this.portada = portada;
        this.volumen = volumen;
        this.numero = numero;
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
        this.enlace = enlace;
        this.IDTomo = IDTomo;
    }

    public Comic(int IDComic, String numero, double precio, String editorialUSA, String editorialESP, String titulo, String genero, String paginas, String fechaEdicion, String guionista, String dibujante) {
        this.IDComic = IDComic;
        this.numero = numero;
        this.precio = precio;
        this.editorialUSA = editorialUSA;
        this.editorialESP = editorialESP;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.fechaEdicion = fechaEdicion;
        this.guionista = guionista;
        this.dibujante = dibujante;
    }

    public Comic() {
    }

    public int getIDComic() {
        return IDComic;
    }

    public void setIDComic(int IDComic) {
        this.IDComic = IDComic;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public int getIDTomo() {
        return IDTomo;
    }

    public void setIDTomo(int IDTomo) {
        this.IDTomo = IDTomo;
    }
}
