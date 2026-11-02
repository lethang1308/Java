/**
 * Lop diem trong khong gian Oxyz, ke thua tu Diem2D.
 */
public class Diem3D extends Diem2D {
    private double z;

    public Diem3D() {
        this(0, 0, 0);
    }

    public Diem3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    /** Tinh khoang cach Euclid giua hai diem 3D. */
    public double khoangCach(Diem3D diemKhac) {
        double deltaX = x - diemKhac.x;
        double deltaY = y - diemKhac.y;
        double deltaZ = z - diemKhac.z;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }

    /** Ghi de phuong thuc cua lop cha va tra ve dung kieu Diem3D. */
    @Override
    public Diem3D doiXungQuaGocToaDo() {
        return new Diem3D(doiDau(x), doiDau(y), doiDau(z));
    }

    /** Tinh tien diem 3D theo ba do lech. */
    public void tinhTien(double deltaX, double deltaY, double deltaZ) {
        super.tinhTien(deltaX, deltaY);
        z += deltaZ;
    }

    @Override
    public String toString() {
        return String.format("Diem3D(%.2f, %.2f, %.2f)", x, y, z);
    }
}
