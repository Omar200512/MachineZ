/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author toapa
 */
public class Producto {
    private String producto;
    private String descripcion;
    private double precio;
    private double codigo_producto; 

    public Producto(String producto, String descripcion, double precio, double codigo_producto) {
        this.producto = producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.codigo_producto = codigo_producto;
    }
    
    public String getProducto() {
        return producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public double getCodigo_producto() {
        return codigo_producto;
    }
    
    
    
     public String agregarProductoBDD() {
    try {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("MachineZ");
        MongoCollection<Document> productoCollection = database.getCollection("productos");

        Document productoDocument = new Document()
                .append("Producto", this.getProducto())
                .append("Precio", this.getPrecio())
                .append("Código", this.getCodigo_producto())
                .append("Descripción", this.getDescripcion());

        productoCollection.insertOne(productoDocument);

        mongoClient.close();

        return "Producto guardado en la base de datos.";
    } catch (Exception e) {
        return "Error al guardar el producto en la base de datos: " + e.getMessage();
    }
}
     
       public String eliminarProductoBDD(double codigoProducto) {
    try {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("MachineZ");
        MongoCollection<Document> productoCollection = database.getCollection("productos");

        productoCollection.deleteOne(Filters.eq("Código", codigoProducto));

        mongoClient.close();

        return "Producto eliminado de la base de datos.";
    } catch (Exception e) {
        return "Error al eliminar el producto de la base de datos: " + e.getMessage();
    }
}
       
      public List<Document> consultarProductosBDD() {
    try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
        MongoDatabase database = mongoClient.getDatabase("MachineZ");
        MongoCollection<Document> productoCollection = database.getCollection("productos");

        List<Document> productos = new ArrayList<>();

        try (MongoCursor<Document> cursor = productoCollection.find().iterator()) {
            while (cursor.hasNext()) {
                productos.add(cursor.next());
            }
        }

        return productos;
    } catch (Exception e) {
        System.err.println("Error al obtener productos: " + e.getMessage());
        return Collections.emptyList();
    }
}
}
