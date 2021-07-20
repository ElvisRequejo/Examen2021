/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examen.config;

import com.examen.daoImpl.VentaDaoImpl;
import com.examen.daoImpl.SucursalDaoImpl;
import com.examen.daoImpl.ClienteDaoImpl;
import com.google.gson.Gson;

/**
 *
 */
public class Test {
static VentaDaoImpl vent = new VentaDaoImpl();
static SucursalDaoImpl sucur = new SucursalDaoImpl();
static ClienteDaoImpl cli = new ClienteDaoImpl();
static Gson gson= new Gson();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if(Conexion.getConexion()!=null){
            System.out.println("si");
        }
     System.out.println(gson.toJson(vent.readAll2()));
    }
    
}
