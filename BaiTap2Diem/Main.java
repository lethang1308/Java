import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== BAI TAP 2 - KE THUA DIEM 2D VA 3D ===");
            int soLuong = nhapSoNguyenDuong(scanner, "Nhap so luong diem: ");
            List<Diem2D> danhSach = new ArrayList<>();

            for (int i = 0; i < soLuong; i++) {
                danhSach.add(nhapDiem(scanner, i + 1));
            }

            hienThiDanhSach("\nDanh sach diem vua nhap:", danhSach);
            System.out.printf("%nTong khoang cach tung cap diem 2D: %.4f%n",
                    tinhTongKhoangCach2D(danhSach));
            System.out.printf("Tong khoang cach tung cap diem 3D: %.4f%n",
                    tinhTongKhoangCach3D(danhSach));

            List<Diem2D> danhSachDoiXung = taoDanhSachDoiXung(danhSach);
            hienThiDanhSach("\nDanh sach cac diem doi xung qua goc toa do:",
                    danhSachDoiXung);
        }
    }

    private static Diem2D nhapDiem(Scanner scanner, int thuTu) {
        System.out.println("\nDiem thu " + thuTu + ":");
        int loai;
        while (true) {
            loai = nhapSoNguyen(scanner, "  Chon loai diem (2 = 2D, 3 = 3D): ");
            if (loai == 2 || loai == 3) {
                break;
            }
            System.out.println("  Chi duoc nhap 2 hoac 3.");
        }

        double x = nhapSoThuc(scanner, "  x = ");
        double y = nhapSoThuc(scanner, "  y = ");
        if (loai == 2) {
            return new Diem2D(x, y);
        }

        double z = nhapSoThuc(scanner, "  z = ");
        return new Diem3D(x, y, z);
    }

    private static int nhapSoNguyenDuong(Scanner scanner, String thongBao) {
        while (true) {
            int giaTri = nhapSoNguyen(scanner, thongBao);
            if (giaTri > 0) {
                return giaTri;
            }
            System.out.println("Gia tri phai lon hon 0.");
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
            System.out.println("Vui long nhap mot so nguyen.");
        }
    }

    private static double nhapSoThuc(Scanner scanner, String thongBao) {
        while (true) {
            System.out.print(thongBao);
            if (scanner.hasNextDouble()) {
                double giaTri = scanner.nextDouble();
                if (Double.isFinite(giaTri)) {
                    return giaTri;
                }
                System.out.println("Gia tri phai la mot so huu han.");
            } else {
                if (!scanner.hasNext()) {
                    throw new IllegalStateException("Du lieu nhap ket thuc som.");
                }
                scanner.next();
                System.out.println("Vui long nhap mot so thuc.");
            }
        }
    }

    /**
     * Tinh tong khoang cach cua moi cap diem 2D phan biet trong danh sach.
     * Cac doi tuong Diem3D khong duoc tinh vao nhom 2D.
     */
    public static double tinhTongKhoangCach2D(List<Diem2D> danhSach) {
        List<Diem2D> cacDiem2D = new ArrayList<>();
        for (Diem2D diem : danhSach) {
            if (!(diem instanceof Diem3D)) {
                cacDiem2D.add(diem);
            }
        }

        double tong = 0;
        for (int i = 0; i < cacDiem2D.size(); i++) {
            for (int j = i + 1; j < cacDiem2D.size(); j++) {
                tong += cacDiem2D.get(i).khoangCach(cacDiem2D.get(j));
            }
        }
        return tong;
    }

    /** Tinh tong khoang cach cua moi cap diem 3D phan biet trong danh sach. */
    public static double tinhTongKhoangCach3D(List<Diem2D> danhSach) {
        List<Diem3D> cacDiem3D = new ArrayList<>();
        for (Diem2D diem : danhSach) {
            if (diem instanceof Diem3D) {
                cacDiem3D.add((Diem3D) diem);
            }
        }

        double tong = 0;
        for (int i = 0; i < cacDiem3D.size(); i++) {
            for (int j = i + 1; j < cacDiem3D.size(); j++) {
                tong += cacDiem3D.get(i).khoangCach(cacDiem3D.get(j));
            }
        }
        return tong;
    }

    /** Tao danh sach moi, khong thay doi cac diem trong danh sach ban dau. */
    public static List<Diem2D> taoDanhSachDoiXung(List<Diem2D> danhSach) {
        List<Diem2D> ketQua = new ArrayList<>();
        for (Diem2D diem : danhSach) {
            // Da hinh: Java tu goi dung ban ghi de cua Diem2D hoac Diem3D.
            ketQua.add(diem.doiXungQuaGocToaDo());
        }
        return ketQua;
    }

    private static void hienThiDanhSach(String tieuDe, List<Diem2D> danhSach) {
        System.out.println(tieuDe);
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + danhSach.get(i));
        }
    }
}
