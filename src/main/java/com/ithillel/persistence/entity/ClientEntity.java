package com.ithillel.persistence.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
@SequenceGenerator(name = "seq_name", sequenceName = "seq_client", allocationSize = 1)
public class ClientEntity extends CommonEntity {

    public ClientEntity() {}

    @Column(name = "name")
    @Convert(converter = CryptoConverterAES.class)
    private String fullname;

   /* @Column(name = "create_timestamtp")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createTimestamp;*/
/*
    @Column(name = "create_time")
    private Instant createTime;*/

    @Column(name = "have_access")
    private boolean haveAccess;

    @Embedded
    private ClientCommonInfo clientCommonInfo;

    public void setClientCommonInfo(ClientCommonInfo clientCommonInfo) {
        this.clientCommonInfo = clientCommonInfo;
    }

    @OneToMany(mappedBy = "client")
    private List<ClientInfoEntity> clientInfos = new ArrayList<>();

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


   /* public Calendar getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Calendar createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }*/

    public boolean isHaveAccess() {
        return haveAccess;
    }

    public void setHaveAccess(boolean haveAccess) {
        this.haveAccess = haveAccess;
    }

    /*
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "create_timestamp")
    private ZonedDateTime createTimestamp; */

}
