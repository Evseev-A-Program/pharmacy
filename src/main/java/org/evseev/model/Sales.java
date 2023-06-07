package org.evseev.model;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
public class Sales {

    private Integer id;

    private String branch;

    private String docType;

    private BigInteger posCount;

    private String createDate;

    private BigDecimal sumQuantity;

    private BigDecimal sumRoznWNDS;


}