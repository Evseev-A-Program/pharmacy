package org.evseev.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.evseev.dao.NaklDataRDAO;
import org.evseev.model.ChequeContent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NaklDataRService {

    public String getNaklDataRAllById(Integer id) {

        NaklDataRDAO naklDataRDAO = new NaklDataRDAO();

        List<ChequeContent> chequeContentList = mapToSalesList(naklDataRDAO.getById(id));
        String json = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(chequeContentList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    private static List<ChequeContent> mapToSalesList(List<Object[]> resultList) {

        List<ChequeContent> chequeContentList = new ArrayList<>();

        for (Object[] row : resultList) {
            ChequeContent chequeContent = new ChequeContent();
            chequeContent.setNds((Short) row[0]);
            chequeContent.setDrug(row[1].toString());
            chequeContent.setFabr(row[2].toString());
            chequeContent.setForm(row[3].toString());
            chequeContent.setSrokG(row[4].toString());
            chequeContent.setQuantity((BigDecimal) row[5]);
            chequeContent.setSumRoznWNDS((BigDecimal) row[6]);
            chequeContentList.add(chequeContent);
        }

        return chequeContentList;
    }
}
