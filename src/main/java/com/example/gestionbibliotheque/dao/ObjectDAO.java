package com.example.gestionbibliotheque.dao;

import com.example.gestionbibliotheque.utility.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

public class ObjectDAO <T>{


    Session s = null;
    Transaction t = null;



   public boolean saveOrUpdateObject(T p) {
    try {
           s = HibernateUtil.getSession();
           t = s.beginTransaction();
           s.saveOrUpdate(p);

           t.commit();

           return true;
    } catch (HibernateException ex) { ex.printStackTrace();
      return false;
    } finally {
            s.close();
    }
    }

    public boolean deleteObject(T p) {
        try {
            s = HibernateUtil.getSession();
            t = s.beginTransaction();
            s.delete(p);
            t.commit();
            return true;
        } catch (HibernateException ex) {
            return false;
        } finally {
            s.close();
        }
    }


    public List<T> getAllObjects(String className){
        List<T> l = null;
        s = HibernateUtil.getSession();
        Query req = s.createQuery("from " + className);
        l = req.list();
        return l;
    }

    public T findById(int value, String critere, String className){
        T res = null;
        s = HibernateUtil.getSession();
        String r = "from " + className + " where "+critere+" = "+value;
        System.out.println("requete de rech by id "+r);
        Query req = s.createQuery(r);
        res = (T) req.uniqueResult();
        System.out.println("res found == "+res);
        return res;
    }



}
