package ba.unsa.etf.rpr.tutorijal02;

import java.util.Objects;

public class Interval {
    private double pocetnaTacka, krajnjaTacka;
    private boolean pocetnaPripada, krajnjaPripada;

    public static Interval intersect(Interval i, Interval i2) {
        return i.intersect(i2);
    }

    public double getPocetnaTacka() {
        return pocetnaTacka;
    }

    public double getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public boolean isPocetnaPripada() {
        return pocetnaPripada;
    }

    public boolean isKrajnjaPripada() {
        return krajnjaPripada;
    }

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocetnaPripada, boolean krajnjaPripada)
    throws IllegalArgumentException{
        if(pocetnaTacka > krajnjaTacka) throw new IllegalArgumentException("greska");
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pocetnaPripada = pocetnaPripada;
        this.krajnjaPripada = krajnjaPripada;
    }

    public Interval(){
        pocetnaPripada = false; krajnjaPripada = false; pocetnaTacka = 0; krajnjaTacka = 0;
    }

    public boolean isIn(double v) {
        if(v > pocetnaTacka && v < krajnjaTacka) return true;
        else if(v == pocetnaTacka && pocetnaPripada == true) return true;
        else if(v == krajnjaTacka && krajnjaPripada == true) return true;
        return false;
    }

    public boolean isNull() {
        if(pocetnaTacka == krajnjaTacka) return true;
        return false;
    }

    public Interval intersect(Interval interval) {
        if(this.pocetnaTacka < interval.pocetnaTacka && this.krajnjaTacka > interval.pocetnaTacka) {
            if (interval.krajnjaTacka < this.krajnjaTacka)
                return interval;
            else return new Interval(interval.pocetnaTacka, this.krajnjaTacka, interval.pocetnaPripada, this.krajnjaPripada);
        }
        else if(this.pocetnaTacka > interval.krajnjaTacka && this.krajnjaTacka < interval.krajnjaTacka)
            return new Interval(this.pocetnaTacka, interval.krajnjaTacka, this.pocetnaPripada, interval.krajnjaPripada);
        else return new Interval();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return Double.compare(interval.pocetnaTacka, pocetnaTacka) == 0 &&
                Double.compare(interval.krajnjaTacka, krajnjaTacka) == 0 &&
                pocetnaPripada == interval.pocetnaPripada &&
                krajnjaPripada == interval.krajnjaPripada;
    }

    //metodu intersect koja vraća presjek dva intervala: metoda treba biti urađena kao klasična public metoda (prima jedan interval)
// i kao statička metoda (prima dva intervala);
//također treba preklopiti metode klase Object a to su toString i equals, na način koji ima smisla za te metode.

}
