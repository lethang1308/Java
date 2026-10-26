import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== BAI TAP 1 - LOP PHAN SO ===");
            int n = nhapSoNguyen(scanner, "Nhap so luong phan so (n > 0): ");
            while (n <= 0) {
                System.out.println("So luong phai lon hon 0.");
                n = nhapSoNguyen(scanner, "Nhap lai n: ");
            }

            List<PhanSo> danhSach = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                danhSach.add(nhapPhanSo(scanner, i + 1));
            }

            System.out.println("\nCac phan so sau khi rut gon: " + danhSach);
            System.out.println("Phan so lon nhat: " + timLonNhat(danhSach));
            try {
                System.out.println("Tong cac phan so: " + tinhTong(danhSach));
            } catch (ArithmeticException e) {
                System.out.println("Khong tinh duoc tong: " + e.getMessage());
            }

            List<PhanSo> khongNguyen = timPhanSoKhongNguyen(danhSach);
            if (khongNguyen.isEmpty()) {
                System.out.println("Khong co phan so nao khong phai so nguyen.");
            } else {
                System.out.println("Cac phan so khong phai so nguyen: " + khongNguyen);
                System.out.println("So luong phan so khong phai so nguyen: " + khongNguyen.size());
            }

            // Minh hoa cac phep toan va so sanh tren hai phan so dau tien.
            if (danhSach.size() >= 2) {
                minhHoaHaiPhanSo(danhSach.get(0), danhSach.get(1));
            }
        }
    }

    private static int nhapSoNguyen(Scanner scanner, String thongBao) {
        while (true) {
            System.out.print(thongBao);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            if (!scanner.hasNext()) {
                throw new IllegalStateException("Du lieu nhap ket thuc som.");
            }
            scanner.next();
            System.out.println("Vui long nhap mot so nguyen trong pham vi int.");
        }
    }

    private static PhanSo nhapPhanSo(Scanner scanner, int stt) {
        while (true) {
            System.out.println("\nPhan so thu " + stt + ":");
            int tu = nhapSoNguyen(scanner, "  Tu so: ");
            int mau = nhapSoNguyen(scanner, "  Mau so (khac 0): ");
            try {
                return new PhanSo(tu, mau);
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println(e.getMessage() + " Vui long nhap lai phan so.");
            }
        }
    }

    public static PhanSo timLonNhat(List<PhanSo> danhSach) {
        if (danhSach.isEmpty()) {
            throw new IllegalArgumentException("Danh sach phan so khong duoc rong.");
        }
        PhanSo lonNhat = danhSach.get(0);
        for (PhanSo phanSo : danhSach) {
            if (phanSo.soSanh(lonNhat) > 0) {
                lonNhat = phanSo;
            }
        }
        return lonNhat;
    }

    public static PhanSo tinhTong(List<PhanSo> danhSach) {
        PhanSo tong = new PhanSo();
        for (PhanSo phanSo : danhSach) {
            tong = tong.cong(phanSo);
        }
        return tong;
    }

    public static List<PhanSo> timPhanSoKhongNguyen(List<PhanSo> danhSach) {
        List<PhanSo> ketQua = new ArrayList<>();
        for (PhanSo phanSo : danhSach) {
            if (!phanSo.laSoNguyen()) {
                ketQua.add(phanSo);
            }
        }
        return ketQua;
    }

    private static void minhHoaHaiPhanSo(PhanSo a, PhanSo b) {
        System.out.println("\nMinh hoa voi a = " + a + ", b = " + b + ":");
        String[] tenPhepTinh = {"a + b", "a - b", "a * b", "a / b"};
        for (int i = 0; i < tenPhepTinh.length; i++) {
            try {
                PhanSo ketQua;
                switch (i) {
                    case 0: ketQua = a.cong(b); break;
                    case 1: ketQua = a.tru(b); break;
                    case 2: ketQua = a.nhan(b); break;
                    default: ketQua = a.chia(b); break;
                }
                System.out.println(tenPhepTinh[i] + " = " + ketQua);
            } catch (ArithmeticException e) {
                System.out.println(tenPhepTinh[i] + ": " + e.getMessage());
            }
        }
        int soSanh = a.soSanh(b);
        System.out.println("So sanh: a " + (soSanh < 0 ? "<" : soSanh > 0 ? ">" : "=") + " b");
    }
}
