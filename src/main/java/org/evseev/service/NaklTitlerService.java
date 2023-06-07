package org.evseev.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.evseev.dao.NaklTitlerDAO;
import org.evseev.model.Sales;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class NaklTitlerService {

    public String getAllNaklTitlers() {

        NaklTitlerDAO naklTitlerDAO = new NaklTitlerDAO();

        List<Sales> salesList = mapToSalesList(naklTitlerDAO.getAll());
        String json = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(salesList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    private static List<Sales> mapToSalesList(List<Object[]> resultList) {

        List<Sales> salesList = new ArrayList<>();

        for (Object[] row : resultList) {
            Sales sales = new Sales();
            sales.setId((Integer) row[0]);
            sales.setBranch((String) row[1]);
            sales.setDocType((String) row[2]);
            sales.setPosCount((BigInteger) row[3]);
            sales.setCreateDate(row[4].toString());
            sales.setSumQuantity((BigDecimal) row[5]);
            sales.setSumRoznWNDS((BigDecimal) row[6]);
            salesList.add(sales);
        }

        return salesList;
    }
}
