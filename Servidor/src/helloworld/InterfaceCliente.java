/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author juaum
 */
public interface InterfaceCliente extends Remote{
    //Adicionar nova reserva a lista local
    public void ReservarHotel(int id) throws RemoteException;
    public void ReservarVoo(int id) throws RemoteException;
    public void ReservarPacote(int id) throws RemoteException;
    
    //Verificar presença ou não de um id na lista local de reservas
    public int verificarReservaHotel(int id) throws RemoteException;
    public int verificarReservaVoo(int id) throws RemoteException;
    public int verificarReservaPacote(int id) throws RemoteException;
    
    //Retirar uma reserva da lista local
    public void cancelarReservaHotel(int id) throws RemoteException;
    public void cancelarReservaVoo(int id) throws RemoteException;
    public void cancelarReservaPacote(int id) throws RemoteException;
    
    //Printar
    void echo(String str) throws RemoteException;
}
