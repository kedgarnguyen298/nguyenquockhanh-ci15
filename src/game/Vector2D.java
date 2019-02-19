package game;

public class Vector2D {
    public double x;
    public double y;

    // ham tao rong
    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    // ham tao day du
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // gan gia tri x, y cho vector dc goi
    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // cong gia tri x, y vao vector dc goi
    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    // tru gia tri x, y vao vector dc goi
    public void minus(double x, double y) {
        this.x -= x;
        this.y -= y;
    }

    // nhan gia tri rate vao vector dc goi
    public void scale(double rate) {
        this.x *= rate;
        this.y *= rate;
    }

    // tra ra do dai cua vector dc goi
    public double getLength() {
        double l = Math.sqrt(this.x*this.x + this.y*this.y);
        return l;
    }

    // giu nguyen huong cua vector dc goi, thay doi do dai = do dai truyen vao
    public void setLength(double length) {
        double r = length/(this.getLength());
        this.x *= r;
        this.y *= r;
    }

    // tra ra goc tao giua vector vs truc hoanh
    public double getAngle() {
        double a;
        double le = this.getLength();
        if (this.x > 0 && this.y > 0) {
            a = Math.toDegrees(Math.acos(this.x/le));
        }
        else if (this.x > 0 && this.y <0 ) {
            a = 360 - Math.toDegrees(Math.acos(this.x/le));
        }
        else if (this.x <0 && this.y >0) {
            a = Math.toDegrees(Math.acos(this.x/le));
        }
        else {
            a = 360 - Math.toDegrees(Math.acos(this.x/le));
        }
        return a;
    }

    // giu nguyen do dai cua vector, quay vector den goc truyen vao
    public void setAngle(double angle) { //
        double le = this.getLength();
        this.x = Math.cos(angle)*le;
        this.y = Math.sin(angle)*le;
    }
}

