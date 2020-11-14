package com.ithillel.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class ClientCommonInfo {

    @Column(name = "client_type")
    @Enumerated(value = EnumType.STRING)
    private ClientType clientType;

    @Column(name = "description")
    private String description;

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
