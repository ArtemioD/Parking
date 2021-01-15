package parking.model;

import java.io.Serializable;
import java.util.Date;

public final class Car implements Serializable {

    private String patente;
    private Date date;

    public Car() {
    }

    public Car(String patente) {
        this.patente = patente.toUpperCase();
        this.date = new Date();
    }

    public String getPatente() {
        return patente;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("patente='").append(patente).append('\'');
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}
