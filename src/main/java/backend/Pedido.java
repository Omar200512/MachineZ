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
public class Pedido {
    private static int numeroPedidoActual =0;
    private int numeroPedido;
    Cliente cliente;
    Producto producto;

    public Pedido(int numeroPedido, Cliente cliente, Producto producto) {
        this.numeroPedido = ++numeroPedidoActual;
        this.cliente = cliente;
        this.producto = producto;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
    
    

    public static void setNumeroPedidoActual(int numeroPedidoActual) {
        Pedido.numeroPedidoActual = numeroPedidoActual;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public static int getNumeroPedidoActual() {
        return numeroPedidoActual;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    
   
    
     public String agregarPedidoBDD() {
    try {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("MachineZ");
        MongoCollection<Document> pedidoCollection = database.getCollection("pedidos");

        Document pedidoDocument = new Document()
                .append("#", this.numeroPedido)
                .append("Nombres", this.cliente.getNombres())
                .append("Apellidos", this.cliente.getApellidos())
                .append("Telefono", this.cliente.getTelefono())
                .append("Email", this.cliente.getEmail())
                .append("Producto", this.producto.getProducto())
                .append("Precio", this.producto.getPrecio())
                .append("Descripción", this.producto.getDescripcion())
                .append("Codigo", this.producto.getCodigo_producto());

        pedidoCollection.insertOne(pedidoDocument);

        mongoClient.close();

        return "Pedido guardado en la base de datos.";
    } catch (Exception e) {
        return "Error al guardar el pedido en la base de datos: " + e.getMessage();
    }
}
     
    public List<Document> consultarPedidoBDD() {
    try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
        MongoDatabase database = mongoClient.getDatabase("MachineZ");
        MongoCollection<Document> pedidoCollection = database.getCollection("pedidos");

        List<Document> pedidos = new ArrayList<>();

        try (MongoCursor<Document> cursor = pedidoCollection.find().iterator()) {
            while (cursor.hasNext()) {
                pedidos.add(cursor.next());
            }
        }

        return pedidos;
    } catch (Exception e) {
        System.err.println("Error al obtener pedidos: " + e.getMessage());
        return Collections.emptyList();
    }
}  
    
           public String eliminarPedidoBDD(int numeroPedido) {
    try {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("MachineZ");
        MongoCollection<Document> productoCollection = database.getCollection("pedidos");

        productoCollection.deleteOne(Filters.eq("#", numeroPedido));

        mongoClient.close();

        return "Pedido eliminado de la base de datos.";
    } catch (Exception e) {
        return "Error al eliminar el pedido de la base de datos: " + e.getMessage();
    }
}
}
