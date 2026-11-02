# Bài tập 2 — Kế thừa và access modifier

## Cấu trúc

- `Diem2D.java`: tọa độ `x`, `y`; tính khoảng cách, lấy điểm đối xứng qua gốc và tịnh tiến.
- `Diem3D.java`: kế thừa `Diem2D`, bổ sung `z`; tính khoảng cách 3D, ghi đè phép đối xứng và tịnh tiến theo ba trục.
- `Main.java`: nhập một danh sách hỗn hợp điểm 2D/3D, tính tổng khoảng cách và tạo danh sách các điểm đối xứng.

`x`, `y` dùng access modifier `protected` để lớp con truy cập được; `z` dùng `private` và được truy cập qua getter/setter. Danh sách có kiểu `List<Diem2D>` nhưng chứa được cả `Diem2D` và `Diem3D`, qua đó thể hiện tính kế thừa và đa hình.

Trong chương trình, “tổng khoảng cách các điểm” được hiểu là tổng khoảng cách của **mọi cặp điểm phân biệt** trong cùng nhóm. Nhóm 2D chỉ chứa đối tượng `Diem2D`; nhóm 3D chỉ chứa đối tượng `Diem3D`. Nếu một nhóm có ít hơn hai điểm thì tổng của nhóm đó bằng 0.

## Biên dịch và chạy

```powershell
cd D:\Java\BaiTap2Diem
javac -encoding UTF-8 Diem2D.java Diem3D.java Main.java
java Main
```

Ví dụ nhập bốn điểm: hai điểm 2D `(0, 0)`, `(3, 4)` và hai điểm 3D `(0, 0, 0)`, `(1, 2, 2)`:

```text
4
2 0 0
2 3 4
3 0 0 0
3 1 2 2
```

Khi đó tổng khoảng cách 2D là `5`, tổng khoảng cách 3D là `3`. Các điểm đối xứng lần lượt là `(0, 0)`, `(-3, -4)`, `(0, 0, 0)` và `(-1, -2, -2)`.

Các phương thức `tinhTien(...)` thay đổi trực tiếp tọa độ của điểm hiện tại. Phương thức `doiXungQuaGocToaDo()` trả về một điểm mới nên danh sách ban đầu không bị thay đổi.
