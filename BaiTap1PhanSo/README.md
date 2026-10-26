# Bài tập 1 — Lớp và đối tượng: Phân số

## Các file

- `PhanSo.java`: hai thuộc tính `tuSo`, `mauSo` kiểu `int`, hàm tạo mặc định và có đối, getters/setters, `toString`, cộng, trừ, nhân, chia, so sánh và rút gọn.
- `Main.java`: nhập danh sách, tìm phân số lớn nhất, tính tổng, liệt kê và đếm phân số không phải số nguyên. Minh họa các phép toán với hai phân số đầu nếu có.

## Chạy bằng terminal PowerShell

Yêu cầu cài JDK (máy hiện tại có JDK 17).

```powershell
cd D:\Java\BaiTap1PhanSo
javac -encoding UTF-8 PhanSo.java Main.java
java Main
```

Có thể mở thư mục bằng VS Code hoặc IntelliJ IDEA, sau đó chạy hàm `main` trong `Main.java`.

## Ví dụ nhập

Nhập `4` cho số lượng, sau đó lần lượt nhập tử số và mẫu số của từng phân số:

```text
4
1 2
3 4
4 2
-2 3
```

Kết quả chính:

```text
Cac phan so sau khi rut gon: [1/2, 3/4, 2/1, -2/3]
Phan so lon nhat: 2/1
Tong cac phan so: 31/12
Cac phan so khong phai so nguyen: [1/2, 3/4, -2/3]
So luong phan so khong phai so nguyen: 3

a + b = 5/4
a - b = -1/4
a * b = 3/8
a / b = 2/3
So sanh: a < b
```

## Cách làm

- Dùng thuật toán Euclid tìm ước chung lớn nhất để rút gọn tử và mẫu.
- Luôn chuẩn hóa mẫu dương; phân số 0 được biểu diễn bằng `0/1`. Hàm tạo và setters tự rút gọn; có thể gọi riêng `rutGon()`.
- Cộng/trừ bằng quy đồng mẫu; nhân bằng tích hai tử và tích hai mẫu; chia bằng nhân nghịch đảo.
- So sánh bằng nhân chéo vì mẫu đã dương, không dùng số thực để tránh sai số.
- Phân số là số nguyên khi tử chia hết cho mẫu.
- Dùng `long` cho phép tính trung gian; báo lỗi nếu phân số sau rút gọn không thể lưu bằng hai số `int`. Tổng được cộng lần lượt nên mỗi tổng trung gian cũng phải biểu diễn được bằng `int`.
- Mẫu bằng 0 và phép chia cho phân số 0 đều được xử lý. Danh sách giữ nguyên các phần tử trùng nhau nếu người dùng nhập nhiều lần.

Chương trình dùng tiếng Việt không dấu trong terminal để hiển thị ổn định trên Windows.
