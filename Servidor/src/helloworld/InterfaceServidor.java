/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;

/**
 *
 * @author juaum
 */
public interface InterfaceServidor extends Remote{
    //Consulta aos objetos cadastrados no servidor pelo cliente
    void getHoteis(InterfaceCliente ref_Cli) throws RemoteException;
    void getVoos(InterfaceCliente ref_Cli) throws RemoteException;
    void getPacotes(InterfaceCliente ref_Cli) throws RemoteException;
    
    //Consulta aos objetos cadastrados no servidor pelo servidor
    public void getHoteisServ() throws RemoteException;
    public void getVoosServ() throws RemoteException;
    public void getPacotesServ() throws RemoteException;
    
    //Adição de objetos ao servidor pelo servidor
    public void addHoteis(int idAux, int preco, int pessoas, int quartos, String nome, String local) throws RemoteException;
    public void addVoo(int idAux, int assentos, int preco, String origem, String destino, String saida) throws RemoteException, ParseException;
    public void addPacote(int idAux, int idHotel, int idVoo1, int idVoo2) throws RemoteException, ParseException;
    
    //Adição de reservas ao servidor pelo cliente
    public void reservaHoteis(InterfaceCliente ref_Cli, String local, int preco) throws RemoteException;
    public void reservaVoo(InterfaceCliente ref_Cli, String origem, String destino, int preco) throws RemoteException;
    public void reservaPacote(InterfaceCliente ref_Cli, String origem, String destino, int preco) throws RemoteException;
    
    //Consulta as reservas presentes no servidor pelo cliente
    public void getReservasHoteis(InterfaceCliente ref_Cli) throws RemoteException;
    public void getReservasVoos(InterfaceCliente ref_Cli) throws RemoteException;
    public void getReservasPacotes(InterfaceCliente ref_Cli) throws RemoteException;
    
    //Consulta as reservas presentes no servidor pelo servidor
    public void getReservasHoteisServ() throws RemoteException;
    public void getReservasVoosServ() throws RemoteException;
    public void getReservasPacotesServ() throws RemoteException;
    
    //Cancelamento de reservas presentes no servidor pelo cliente
    public void cancelarReservasHoteis(InterfaceCliente ref_Cli, int id) throws RemoteException;
    public void cancelarReservasVoos(InterfaceCliente ref_Cli, int id) throws RemoteException;
    public void cancelarReservasPacotes(InterfaceCliente ref_Cli, int id) throws RemoteException;
   
    //Adição de compras ao servidor pelo cliente
    public void comprarVoos(InterfaceCliente ref_Cli, int opt, int qtde, int preco, String destino, String origem, String part, String cheg) throws RemoteException;
    public void comprarHoteis(InterfaceCliente ref_Cli, int opt, int preco, int pessoas, int quartos, String entrada, String saida, String nome, String local) throws RemoteException;
    public void comprarPacotes(InterfaceCliente ref_Cli, int opt, int preco, int pessoas, int quartos, String destino, String origem, String part, String cheg, String nome) throws RemoteException;
}