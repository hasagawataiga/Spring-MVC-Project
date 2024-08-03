package com.hasagawataiga.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "treatment_record")
public class TreatmentRecordEntity extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private UserEntity customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_id", nullable = false)
    private TreatmentEntity treatment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technician_id", nullable = false)
    private TechnicianEntity servedBy;

    @Column(name = "booking_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate;

    @Column(name = "treatment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date treatmentDate;

    @Column(name = "price", nullable = false)
    private Double price;

    public UserEntity getCustomer() {
        return customer;
    }

    public void setCustomer(UserEntity customer) {
        this.customer = customer;
    }

    public TreatmentEntity getTreatment() {
        return treatment;
    }

    public void setTreatment(TreatmentEntity treatment) {
        this.treatment = treatment;
    }

    public TechnicianEntity getServedBy() {
        return servedBy;
    }

    public void setServedBy(TechnicianEntity servedBy) {
        this.servedBy = servedBy;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(Date treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
