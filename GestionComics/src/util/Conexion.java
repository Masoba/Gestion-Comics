package util;

import Modelo.Comic;
import Modelo.Tomo;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    Connection conexion;

    //Conectar a la base de datos sqlite
    public void conectar() {
        conexion = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate("create table if not exists tomo (IDTomo INTEGER PRIMARY KEY,"
                    + "Portada TEXT,"
                    + "Precio REAL,"
                    + "EditorialUSA TEXT,"
                    + "EditorialESP TEXT,"
                    + "Superheroe TEXT,"
                    + "Titulo TEXT,"
                    + "Coleccion TEXT,"
                    + "Genero TEXT,"
                    + "Paginas TEXT,"
                    + "FechaEdicion TEXT,"
                    + "Guionista TEXT,"
                    + "Dibujante TEXT,"
                    + "Enlace TEXT,"
                    + "Tipo TEXT)");

            stmt.executeUpdate("create table if not exists tomoDeseado (IDTomo INTEGER PRIMARY KEY,"
                    + "Portada TEXT,"
                    + "Precio REAL,"
                    + "EditorialUSA TEXT,"
                    + "EditorialESP TEXT,"
                    + "Superheroe TEXT,"
                    + "Titulo TEXT,"
                    + "Coleccion TEXT"
                    + "Genero TEXT,"
                    + "Paginas TEXT,"
                    + "FechaEdicion TEXT,"
                    + "Guionista TEXT,"
                    + "Dibujante TEXT,"
                    + "Enlace TEXT,"
                    + "Tipo TEXT)");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Base de datos abierta");
    }

    //Cerrar la conexión con la base de datos
    public void cerrar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Guardar tomo en la base de datos
    public int guardarTomo(Tomo tomo) {

        try {
            PreparedStatement pst = conexion.prepareStatement("insert into tomo (IDTomo, Portada, Precio, EditorialUSA, EditorialESP, Superheroe,"
                    + "Titulo, Coleccion, Genero, Paginas, FechaEdicion, Guionista, Dibujante, Enlace, Tipo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pst.setInt(1, this.ultimoIDTomo());
            pst.setString(2, tomo.getPortada());
            pst.setDouble(3, tomo.getPrecio());
            pst.setString(4, tomo.getEditorialUSA());
            pst.setString(5, tomo.getEditorialESP());
            pst.setString(6, tomo.getSuperheroe());
            pst.setString(7, tomo.getTitulo());
            pst.setString(8, tomo.getColeccion());
            pst.setString(9, tomo.getGenero());
            pst.setString(10, tomo.getPaginas());
            pst.setString(11, tomo.getFechaEdicion());
            pst.setString(12, tomo.getGuionista());
            pst.setString(13, tomo.getDibujante());
            pst.setString(14, tomo.getLink());
            pst.setString(15, tomo.getTipo());
            pst.execute();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int guardarTomoDeseado(Tomo tomo) {
        try {
            PreparedStatement pst = conexion.prepareStatement("insert into tomoDeseado (IDTomo, Portada, Precio, EditorialUSA, EditorialESP, Superheroe,"
                    + "Titulo, Coleccion, Genero, Paginas, FechaEdicion, Guionista, Dibujante, Enlace, Tipo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pst.setInt(1, this.ultimoIDTomo());
            pst.setString(2, tomo.getPortada());
            pst.setDouble(3, tomo.getPrecio());
            pst.setString(4, tomo.getEditorialUSA());
            pst.setString(5, tomo.getEditorialESP());
            pst.setString(6, tomo.getSuperheroe());
            pst.setString(7, tomo.getTitulo());
            pst.setString(8, tomo.getColeccion());
            pst.setString(9, tomo.getGenero());
            pst.setString(10, tomo.getPaginas());
            pst.setString(11, tomo.getFechaEdicion());
            pst.setString(12, tomo.getGuionista());
            pst.setString(13, tomo.getDibujante());
            pst.setString(14, tomo.getLink());
            pst.setString(15, tomo.getTipo());
            pst.execute();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

   

    //Coger el último IDTomo de la base de datos
    public int ultimoIDTomo() {
        int IDTomo = 1;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rst = stmt.executeQuery("select max(IDTomo) from tomo");
            IDTomo = rst.getInt(1);
            return IDTomo + 1;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return IDTomo;
    }

    public int ultimoIDTomoDeseado() {
        int IDTomoDeseado = 1;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rst = stmt.executeQuery("select max(IDTomo) from tomoDeseado");
            IDTomoDeseado = rst.getInt(1);
            return IDTomoDeseado + 1;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return IDTomoDeseado;
    }


    public Tomo[] cargarComics() {
        Tomo[] tomos = new Tomo[ultimoIDTomo()-1];
        int i = 0;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rst = stmt.executeQuery("select * from tomo");

            while (rst.next()) {
                tomos[i] = new Tomo(rst.getInt("IDTomo"), rst.getString("Portada"), rst.getDouble("Precio"), rst.getString("EditorialUSA"), rst.getString("EditorialESP"),
                    rst.getString("Superheroe"), rst.getString("Titulo"), rst.getString("Genero"), rst.getString("Paginas"),
                    rst.getString("FechaEdicion"), rst.getString("Guionista"), rst.getString("Dibujante"), rst.getString("Enlace"), rst.getString("Tipo"), rst.getString("Coleccion"));
                i++;
            }
            return tomos;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tomos;
    }

    public Tomo[] cargarComicsDeseados() {
        Tomo[] tomos = new Tomo[ultimoIDTomoDeseado()-1];
        int i = 0;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rst = stmt.executeQuery("select * from tomoDeseado");

            while (rst.next()) {
                tomos[i] = new Tomo(rst.getInt("IDTomo"), rst.getString("Portada"));
                i++;
            }
            return tomos;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tomos;
    }

    public Tomo cargarComicFicha(int IDTomo) {
        Tomo tomo = new Tomo();

        PreparedStatement pst;
        try {
            pst = conexion.prepareStatement("SELECT IDTomo, Portada, Precio, EditorialUSA, EditorialESP, Superheroe, Titulo, Coleccion, Genero,"
                    + " Paginas, FechaEdicion, Guionista, Dibujante, Enlace, Tipo FROM tomo WHERE IDTomo =  ?");
            pst.setInt(1, IDTomo);
            ResultSet rst = pst.executeQuery();
            rst.next();
            tomo = new Tomo(IDTomo, rst.getString("Portada"), rst.getDouble("Precio"), rst.getString("EditorialUSA"), rst.getString("EditorialESP"),
                    rst.getString("Superheroe"), rst.getString("Titulo"), rst.getString("Genero"), rst.getString("Paginas"),
                    rst.getString("FechaEdicion"), rst.getString("Guionista"), rst.getString("Dibujante"), rst.getString("Enlace"), rst.getString("Tipo"), rst.getString("Coleccion"));
            return tomo;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tomo;
    }

    public Tomo cargarComicDeseadoFicha(int IDTomoDeseado) {
        Tomo tomo = new Tomo();

        PreparedStatement pst;
        try {
            pst = conexion.prepareStatement("SELECT IDTomo, Portada, Precio, EditorialUSA, EditorialESP, Superheroe, Titulo, Coleccion, Genero,"
                    + " Paginas, FechaEdicion, Guionista, Dibujante, Enlace, Tipo FROM tomoDeseado WHERE IDTomo =  ?");
            pst.setInt(1, IDTomoDeseado);
            ResultSet rst = pst.executeQuery();
            rst.next();
            tomo = new Tomo(IDTomoDeseado, rst.getString("Portada"), rst.getDouble("Precio"), rst.getString("EditorialUSA"), rst.getString("EditorialESP"),
                    rst.getString("Superheroe"), rst.getString("Titulo"), rst.getString("Genero"), rst.getString("Paginas"),
                    rst.getString("FechaEdicion"), rst.getString("Guionista"), rst.getString("Dibujante"), rst.getString("Enlace"), rst.getString("Tipo"), rst.getString("Coleccion"));
            return tomo;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tomo;
    }

    public int modificarComic(Tomo tomo) {
        try {
            PreparedStatement pst = conexion.prepareStatement("update tomo set Portada = ?, Precio = ?, EditorialUSA = ?, EditorialESP = ?,"
                    + "Superheroe = ?, Titulo = ?, Coleccion = ?, Genero = ?, Paginas = ?, FechaEdicion = ?, Guionista = ?, Dibujante = ?, Enlace = ?, Tipo = ? where IDTomo = ?");

            pst.setString(1, tomo.getPortada());
            pst.setDouble(2, tomo.getPrecio());
            pst.setString(3, tomo.getEditorialUSA());
            pst.setString(4, tomo.getEditorialESP());
            pst.setString(5, tomo.getSuperheroe());
            pst.setString(6, tomo.getTitulo());
            pst.setString(7, tomo.getGenero());
            pst.setString(8, tomo.getColeccion());
            pst.setString(9, tomo.getPaginas());
            pst.setString(10, tomo.getFechaEdicion());
            pst.setString(11, tomo.getGuionista());
            pst.setString(12, tomo.getDibujante());
            pst.setString(13, tomo.getLink());
            pst.setString(14, tomo.getTipo());
            pst.setInt(15, tomo.getIDTomo());

            pst.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int modificarComicDeseado(Tomo tomoDeseado) {
        try {
            PreparedStatement pst = conexion.prepareStatement("update tomoDeseado set Portada = ?, Precio = ?, EditorialUSA = ?, EditorialESP = ?,"
                    + "Superheroe = ?, Titulo = ?, Coleccion = ?, Genero = ?, Paginas = ?, FechaEdicion = ?, Guionista = ?, Dibujante = ?, Enlace = ?, Tipo = ? where IDTomo = ?");

            pst.setString(1, tomoDeseado.getPortada());
            pst.setDouble(2, tomoDeseado.getPrecio());
            pst.setString(3, tomoDeseado.getEditorialUSA());
            pst.setString(4, tomoDeseado.getEditorialESP());
            pst.setString(5, tomoDeseado.getSuperheroe());
            pst.setString(6, tomoDeseado.getTitulo());
            pst.setString(7, tomoDeseado.getColeccion());
            pst.setString(8, tomoDeseado.getGenero());
            pst.setString(9, tomoDeseado.getPaginas());
            pst.setString(10, tomoDeseado.getFechaEdicion());
            pst.setString(11, tomoDeseado.getGuionista());
            pst.setString(12, tomoDeseado.getDibujante());
            pst.setString(13, tomoDeseado.getLink());
            pst.setString(14, tomoDeseado.getTipo());
            pst.setInt(15, tomoDeseado.getIDTomo());

            pst.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int borrarComic(int IDTomo) {
        try {
            PreparedStatement pst = conexion.prepareStatement("delete from tomo where IDTomo = ?");
            pst.setInt(1, IDTomo);
            pst.executeUpdate();

            Statement stmt = conexion.createStatement();
            ResultSet rst = stmt.executeQuery("select max(IDTomo) from tomo");
            rst.next();
            for (int i = IDTomo; i <= rst.getInt(1); i++) {
                PreparedStatement pst2 = conexion.prepareStatement("update tomo set IDTomo = ? where IDTomo = ?");
                pst2.setInt(1, i);
                pst2.setInt(2, i + 1);
                pst2.executeUpdate();

            }
            return 1;

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int borrarComicDeseado(int IDTomoDeseado) {
        try {
            PreparedStatement pst = conexion.prepareStatement("delete from tomoDeseado where IDTomo = ?");
            pst.setInt(1, IDTomoDeseado);
            pst.executeUpdate();

            Statement stmt = conexion.createStatement();
            ResultSet rst = stmt.executeQuery("select max(IDTomo) from tomoDeseado");
            rst.next();
            for (int i = IDTomoDeseado; i <= rst.getInt(1); i++) {
                PreparedStatement pst2 = conexion.prepareStatement("update tomoDeseado set IDTomo = ? where IDTomo = ?");
                pst2.setInt(1, i);
                pst2.setInt(2, i + 1);
                pst2.executeUpdate();

            }
            return 1;

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
