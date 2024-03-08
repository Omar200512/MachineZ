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
public class Buscador {
    private String producto;
    private double codigo_producto;

    public Buscador(String producto, double codigo_producto) {
        this.producto = producto;
        this.codigo_producto = codigo_producto;
    }
    
    public List<Document> buscarProductoBDD(String producto, double codigo_producto) {
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("MachineZ");

            // Obtener la colección de productos
            MongoCollection<Document> productoCollection = database.getCollection("productos");

            // Consultar el producto por nombre o código
            List<Document> productos = new ArrayList<>();
            if (!producto.isEmpty()) {
                try (MongoCursor<Document> cursor = productoCollection.find(Filters.eq("Producto", producto)).iterator()) {
                    while (cursor.hasNext()) {
                        productos.add(cursor.next());
                    }
                }
            } else {
                try (MongoCursor<Document> cursor = productoCollection.find(Filters.eq("Codigo", codigo_producto)).iterator()) {
                    while (cursor.hasNext()) {
                        productos.add(cursor.next());
                    }
                }
            }

            mongoClient.close();

            return productos;
        } catch (Exception e) {
            System.err.println("Error al buscar el producto en la base de datos: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
