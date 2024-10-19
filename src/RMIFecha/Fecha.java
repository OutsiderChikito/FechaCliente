/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RMIFecha;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Fecha extends Remote{
    public void horaActual(String a) throws RemoteException;
}