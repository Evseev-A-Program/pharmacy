package org.evseev.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ChequeContent {

    private String drug;

    private String form;

    private String fabr;

    private BigDecimal quantity;

    private BigDecimal sumRoznWNDS;

    private Short nds;

    private String srokG;
}
