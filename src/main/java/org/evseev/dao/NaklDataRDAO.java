package org.evseev.dao;


import org.evseev.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class NaklDataRDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session = sessionFactory.openSession();

    public List<Object[]> getById(Integer id){

        String query = "select \n" +
                "nakldatar.nds,\n" +
                "drug.drug,\n" +
                "fabr.fabr,\n" +
                "form.form,\n" +
                "nakldata.srokg,\n" +
                "nakldatar.uquantity,\n" +
                "nakldatar.sumroznwnds\n" +
                "from registry\n" +
                "join drug on registry.drugid = drug.drugid\n" +
                "join fabr on registry.fabrid = fabr.fabrid\n" +
                "join form on registry.formid = form.formid\n" +
                "join nakldata on registry.regid = nakldata.regid\n" +
                "join nakldatar on nakldata.nakldataid = nakldatar.nakldataid\n" +
                "where nakldatar.disable = '0' and nakldatar.nakltitlerid  = '" + id.toString() + "'";

        NativeQuery<Object[]> nativeQuery = session.createNativeQuery(query);

        List<Object[]> resultList = nativeQuery.getResultList();


//        session.close();
//        sessionFactory.close();


        return  resultList;
    }
}
