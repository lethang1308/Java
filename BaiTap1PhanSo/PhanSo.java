/**
 * Bai tap 1: lop bieu dien phan so T/M voi tu so va mau so nguyen.
 * Phan so luon duoc rut gon, mau so duong va khac 0.
 */
public class PhanSo {
    private int tuSo;
    private int mauSo;

    // Ham tao mac dinh: 0/1.
    public PhanSo() {
        this(0, 1);
    }

    // Ham tao co doi.
    public PhanSo(int tuSo, int mauSo) {
        ganGiaTri(tuSo, mauSo);
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        ganGiaTri(tuSo, this.mauSo);
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        ganGiaTri(this.tuSo, mauSo);
    }

    public PhanSo cong(PhanSo khac) {
        return taoKetQua((long) tuSo * khac.mauSo + (long) khac.tuSo * mauSo,
                (long) mauSo * khac.mauSo);
    }

    public PhanSo tru(PhanSo khac) {
        return taoKetQua((long) tuSo * khac.mauSo - (long) khac.tuSo * mauSo,
                (long) mauSo * khac.mauSo);
    }

    public PhanSo nhan(PhanSo khac) {
        return taoKetQua((long) tuSo * khac.tuSo, (long) mauSo * khac.mauSo);
    }

    public PhanSo chia(PhanSo khac) {
        if (khac.tuSo == 0) {
            throw new ArithmeticException("Khong the chia cho phan so bang 0.");
        }
        return taoKetQua((long) tuSo * khac.mauSo, (long) mauSo * khac.tuSo);
    }

    // Tra ve so am, 0, so duong khi this nho hon, bang, lon hon khac.
    public int soSanh(PhanSo khac) {
        return Long.compare((long) tuSo * khac.mauSo, (long) khac.tuSo * mauSo);
    }

    public void rutGon() {
        ganGiaTri(tuSo, mauSo);
    }

    public boolean laSoNguyen() {
        return tuSo % mauSo == 0;
    }

    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }

    private static long uocChungLonNhat(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long du = a % b;
            a = b;
            b = du;
        }
        return a;
    }

    private void ganGiaTri(long tu, long mau) {
        if (mau == 0) {
            throw new IllegalArgumentException("Mau so phai khac 0.");
        }
        long ucln = uocChungLonNhat(tu, mau);
        tu /= ucln;
        mau /= ucln;
        if (mau < 0) {
            tu = -tu;
            mau = -mau;
        }
        // Kiem tra ca hai gia tri truoc khi thay doi thuoc tinh.
        if (tu < Integer.MIN_VALUE || tu > Integer.MAX_VALUE || mau > Integer.MAX_VALUE) {
            throw new ArithmeticException("Ket qua vuot pham vi kieu int.");
        }
        this.tuSo = (int) tu;
        this.mauSo = (int) mau;
    }

    private static PhanSo taoKetQua(long tu, long mau) {
        PhanSo ketQua = new PhanSo();
        ketQua.ganGiaTri(tu, mau);
        return ketQua;
    }
}
