
package project.model;

/**
 *
 * @author Nicolas
 */
public class Caja {
    private int ingresos;
    private int egresos;
    private int balance;

    public Caja() {
        this.ingresos = 0;
        this.egresos = 0;
        this.balance = 0;
    }

    public int getIngresos() {
        return ingresos;
    }

    public int getEgresos() {
        return egresos;
    }

    public int getBalance() {
        return balance;
    }

    public void setIngresos(int x) {
        this.ingresos = ingresos+x;
    }

    public void setEgresos(int x) {
        this.egresos = egresos+x;
    }
    
    public void setBalance(int x) {
        this.balance = balance+x;
    }

    public void setBalance() {
        this.balance = this.getIngresos()-this.getEgresos();
    }

    @Override
    public String toString() {
        return "Caja: " + "ingresos: $" + ingresos + ", egresos: $" + egresos + ", balance: $" + balance;
    }
    
}
