package org.evseev.dao;


import org.evseev.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class NaklTitlerDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session = sessionFactory.openSession();

    public List<Object[]> getAll(){

        String query = "select \n" +
                "nakltitler.nakltitlerid,\n" +
                "branch.branch, \n" +
                "doctype.doctype, \n" +
                "  (\n" +
                "    SELECT COUNT(*) \n" +
                "    FROM nakldatar \n" +
                "    WHERE nakldatar.nakltitlerid = nakltitler.nakltitlerid\n" +
                "  ) AS posCount,\n" +
                "nakltitler.createdate, \n" +
                "nakldatar.UQuantity,\n" +
                "nakldatar.sumroznWNDS\n" +
                "\n" +
                "from branch join nakltitler \n" +
                "on branch.branchid = nakltitler.branchid\n" +
                "join doctype \n" +
                "on doctype.doctypeid = nakltitler.doctypeid\n" +
                "join nakldatar\n" +
                "on nakldatar.nakltitlerid = nakltitler.nakltitlerid\n" +
                "where nakltitler.disable = 0 and nakltitler.ispost = 1\n" +
                "order by nakltitler.createdate DESC\n";

        NativeQuery<Object[]> nativeQuery = session.createNativeQuery(query);

        List<Object[]> resultList = nativeQuery.getResultList();


//        session.close();
//        sessionFactory.close();


        return  resultList;
    }
}
