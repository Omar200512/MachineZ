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
public class Factura {
    Cliente cliente;
    Producto producto;
    Pedido pedido;
    private String estado;

    public Factura(Cliente cliente, Producto producto, Pedido pedido, String estado) {
        this.cliente = cliente;
        this.producto = producto;
        this.pedido = pedido;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    public Cliente getCliente() {
        return cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    
   
    
     public String guardarFacturaBDD(int numeroPedido) {
    try {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("MachineZ");

        // Obtener la colección de pedidos
        MongoCollection<Document> pedidoCollection = database.getCollection("pedidos");

        // Buscar el pedido en la base de datos
        Document pedidoDocument = pedidoCollection.find(Filters.eq("NumeroPedido", numeroPedido)).first();

        // Verificar si el pedido existe
        if (pedidoDocument == null) {
            return "No se encontró el pedido con el número especificado.";
        }

        // Obtener los datos del pedido
        String nombresCliente = pedidoDocument.getString("Nombres");
        String apellidosCliente = pedidoDocument.getString("Apellidos");
        String productoPedido = pedidoDocument.getString("Producto");
        double precioProducto = pedidoDocument.getDouble("Precio");
        double codigoProducto = pedidoDocument.getDouble("Codigo");

        // Crear un documento para la factura
        Document facturaDocument = new Document()
                .append("NumeroPedido", numeroPedido)
                .append("NombresCliente", nombresCliente)
                .append("ApellidosCliente", apellidosCliente)
                .append("ProductoPedido", productoPedido)
                .append("PrecioProducto", precioProducto)
                .append("CodigoProducto", codigoProducto)
                .append("Estado", this.getEstado());

        // Obtener la colección de facturas
        MongoCollection<Document> facturaCollection = database.getCollection("facturas");

        // Insertar la factura en la base de datos
        facturaCollection.insertOne(facturaDocument);

        // Cerrar la conexión a la base de datos
        mongoClient.close();

        return "Factura guardada en la base de datos.";
    } catch (Exception e) {
        return "Error al guardar la factura en la base de datos: " + e.getMessage();
    }
}
     
    public List<Document> consultarFacturaBDD(int numeroPedido) {
    try {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("MachineZ");

        // Obtener la colección de facturas
        MongoCollection<Document> facturaCollection = database.getCollection("facturas");

        // Consultar la factura por el número de pedido
        List<Document> facturas = new ArrayList<>();
        try (MongoCursor<Document> cursor = facturaCollection.find(Filters.eq("NumeroPedido", numeroPedido)).iterator()) {
            while (cursor.hasNext()) {
                facturas.add(cursor.next());
            }
        }

        // Cerrar la conexión a la base de datos
        mongoClient.close();

        return facturas;
    } catch (Exception e) {
        System.err.println("Error al consultar la factura en la base de datos: " + e.getMessage());
        return Collections.emptyList();
    }
}
    
    
        public String eliminarFacturaBDD(int numeroPedido) {
    try {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("MachineZ");

        // Obtener la colección de facturas
        MongoCollection<Document> facturaCollection = database.getCollection("facturas");

        // Eliminar la factura por el número de pedido
        facturaCollection.deleteOne(Filters.eq("NumeroPedido", numeroPedido));

        // Cerrar la conexión a la base de datos
        mongoClient.close();

        return "Factura eliminada de la base de datos.";
    } catch (Exception e) {
        return "Error al eliminar la factura de la base de datos: " + e.getMessage();
    }
}
}
