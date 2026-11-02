/**
 * Lop bieu dien mot diem trong mat phang Oxy.
 */
public class Diem2D {
    // protected de lop con Diem3D co the truy cap truc tiep.
    protected double x;
    protected double y;

    public Diem2D() {
        this(0, 0);
    }

    public Diem2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /** Tinh khoang cach Euclid giua hai diem 2D. */
    public double khoangCach(Diem2D diemKhac) {
        double deltaX = x - diemKhac.x;
        double deltaY = y - diemKhac.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    /** Tao va tra ve diem doi xung qua goc toa do O. */
    public Diem2D doiXungQuaGocToaDo() {
        return new Diem2D(doiDau(x), doiDau(y));
    }

    /** Tinh tien diem hien tai theo do lech deltaX, deltaY. */
    public void tinhTien(double deltaX, double deltaY) {
        x += deltaX;
        y += deltaY;
    }

    @Override
    public String toString() {
        return String.format("Diem2D(%.2f, %.2f)", x, y);
    }

    /** Doi dau va chuan hoa -0.0 thanh 0.0 de hien thi dep hon. */
    protected static double doiDau(double giaTri) {
        return giaTri == 0 ? 0 : -giaTri;
    }
}
