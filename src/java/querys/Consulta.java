/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package querys;

import java.util.List;
import model.Client;
import model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utilidades.NewHibernateUtil;

/**
 *
 * @author jc
 */

public class Consulta {
    public List<Employee> getEmployees(){
        SessionFactory sesion=NewHibernateUtil.getSessionFactory();
        Session session=sesion.openSession();
        Query query=session.createQuery("FROM Employee");
        List<Employee> myEmployees=query.list();
        session.close();
        return myEmployees;
    }
    public List<Client> getClients(){
        SessionFactory sesion=NewHibernateUtil.getSessionFactory();
        Session session=sesion.openSession();
        Query query=session.createQuery("FROM Client");
        List<Client> myClients=query.list();
        session.close();
        return myClients;
    }
    public boolean isClient(Client client){
        SessionFactory sesion=NewHibernateUtil.getSessionFactory();
        Session session=sesion.openSession();
        Query query=session.createQuery("FROM Client WHERE email='"+client.getEmail()+"' and"
                + " password='"+client.getPassword()+"'");
        boolean isClient=query.list().isEmpty();//lo guardamos en una variable para luego cerrar la sesión
        session.close();
        return !isClient;
    }
    //<editor-fold defaultstate="collapsed" desc="ADD DEL UPD CLIENT">
    public void addClient(Client client){
        SessionFactory sesion=NewHibernateUtil.getSessionFactory();
        Session session=sesion.openSession();
        Transaction t=session.beginTransaction();
        session.save(client);
        t.commit();
        session.close();
    }
    public void deleteClient(Client client){
        SessionFactory sesion=NewHibernateUtil.getSessionFactory();
        Session session=sesion.openSession();
        Transaction t=session.beginTransaction();
        session.delete(client);
        t.commit();
        session.close();
    }
    public void updateClient(Client client){
        SessionFactory sesion=NewHibernateUtil.getSessionFactory();
        Session session=sesion.openSession();
        Transaction t=session.beginTransaction();
        session.update(client);
        t.commit();
        session.close();
    }
//</editor-fold>
    
}
