/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.machinez;

import backend.Cliente;
import backend.Pedido;
import backend.Producto;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import frontend.MenuJFrame;

/**
 *
 * @author toapa
 */
public class MachineZ {

    public static void main(String[] args) {
        FlatMaterialLighterIJTheme.setup();
        MenuJFrame menu = new MenuJFrame();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        
        
        
        /*
        Cliente cliente = new Cliente("Carlos Juan","Zurita Caiza","099856555","oatoapanat@dafas.com");
        Producto producto = new Producto("tv","25pg",255,123456789);
        
        producto.agregarProductoBDD();
       
        System.out.println("Consulta"+producto.consultarProductosBDD());
        producto.eliminarProductoBDD(133456789);
        
        Pedido pedido = new Pedido(0,cliente,producto);
        
        pedido.agregarPedidoBDD();
        
        
        //CLIENTE 2 PRUEBA
        Cliente cliente2 = new Cliente("Carlos Juan","Zurita Caiza","099856555","oatoapanat@dafas.com");
        Producto producto2 = new Producto("tv","25pg",255,123456789);
        
        producto2.agregarProductoBDD();
       
        System.out.println("Consulta"+producto2.consultarProductosBDD());
        producto2.eliminarProductoBDD(133456789);
        
        Pedido pedido2 = new Pedido(0,cliente2,producto2);
        
        pedido2.agregarPedidoBDD();
        
        */
         
    }
    
    
}
