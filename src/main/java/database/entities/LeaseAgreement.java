package database.entities;

import database.enums.StatusENUM;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lease_agreements")
@HashCodeAndEqualsPlugin.Enhance(invokeSuper = HashCodeAndEqualsPlugin.Enhance.InvokeSuper.ALWAYS)
public class LeaseAgreement extends BaseEntity {
    public LeaseAgreement() {}

    public LeaseAgreement(Date departure_date, Date expected_return_date, Date return_date, int departure_mileage, int return_mileage, double price, double penalty, StatusENUM status) {
        this.departure_date = departure_date;
        this.expected_return_date = expected_return_date;
        this.return_date = return_date;
        this.departure_mileage = departure_mileage;
        this.return_mileage = return_mileage;
        this.price = price;
        this.penalty = penalty;
        this.status = status;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "departure_date", nullable = false)
    private Date departure_date;

    public Date getDepartureDate() { return departure_date; }

    public void setDepartureDate(Date departureDate) { this.departure_date = departureDate; }


    @Temporal(TemporalType.DATE)
    @Column(name = "expected_return_date")
    private Date expected_return_date;

    public Date getExpectedReturnDate() { return expected_return_date; }

    public void setExpectedReturnDate(Date expectedReturnDate) { this.expected_return_date = expectedReturnDate; }


    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private Date return_date = null;

    public Date getReturnDate() { return return_date; }

    public void setReturnDate(Date returnDate) { this.return_date = returnDate; }


    @Column(name = "departure_mileage", nullable = false)
    private int departure_mileage;

    public int getDepartureMileage() { return departure_mileage; }

    public void setDepartureMileage(int departureMileage) { this.departure_mileage = departureMileage; }


    @Column(name = "return_mileage")
    private int return_mileage;

    public int getReturnMileage() { return return_mileage; }

    public void setReturnMileage(int returnMileage) { this.return_mileage = returnMileage; }


    @Column(name = "price", nullable = false)
    private double price;

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }


    @Column(name = "penalty")
    private double penalty = 0.0;

    public double getPenalty() { return penalty; }

    public void setPenalty(double penalty) { this.penalty = penalty; }


    @Column(name = "status", columnDefinition = "enum('ACTIVATED', 'PENDING', 'HOLDING', 'CANCELED')", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusENUM status = StatusENUM.ACTIVATED;

    public StatusENUM getStatus() { return status; }

    public void setStatus(StatusENUM status) { this.status = status; }


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicles_id;

    public Vehicle getVehicleId() { return vehicles_id; }

    public void setVehicles(Vehicle vehicleId) { this.vehicles_id = vehicleId; }


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer_id;

    public Customer getCustomerId() { return customer_id; }

    public void setCustomers(Customer customerId) { this.customer_id = customerId; }


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee_id;

    public Employee getEmployeeId() { return employee_id; }

    public void setEmployeeId(Employee employeeId) { this.employee_id = employeeId; }
}
