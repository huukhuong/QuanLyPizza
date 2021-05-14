-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 14, 2021 lúc 01:26 PM
-- Phiên bản máy phục vụ: 10.4.18-MariaDB
-- Phiên bản PHP: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlypizza`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cthoadon`
--

CREATE TABLE `cthoadon` (
  `MaHD` int(11) NOT NULL,
  `MaSP` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `cthoadon`
--

INSERT INTO `cthoadon` (`MaHD`, `MaSP`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES
(18, 114, 2, 159000, 318000),
(18, 122, 3, 249000, 747000),
(18, 124, 6, 19000, 114000),
(18, 130, 2, 19000, 38000),
(18, 132, 2, 25000, 50000),
(19, 115, 2, 119000, 238000),
(19, 120, 1, 239000, 239000),
(19, 128, 4, 19000, 76000),
(19, 131, 5, 10000, 50000),
(20, 118, 1, 129000, 129000),
(20, 120, 2, 239000, 478000),
(20, 129, 5, 19000, 38000),
(20, 130, 5, 19000, 95000),
(20, 131, 10, 10000, 100000),
(21, 112, 3, 129000, 387000),
(21, 117, 2, 149000, 298000),
(21, 126, 10, 19000, 190000),
(21, 127, 3, 29000, 87000),
(21, 128, 15, 19000, 285000),
(21, 131, 6, 10000, 60000),
(22, 114, 5, 159000, 795000),
(22, 127, 10, 29000, 290000),
(22, 129, 6, 19000, 95000),
(22, 132, 3, 25000, 75000),
(23, 112, 3, 129000, 387000),
(23, 113, 1, 119000, 119000),
(23, 118, 1, 129000, 129000),
(23, 128, 6, 19000, 114000),
(23, 131, 5, 10000, 50000),
(23, 132, 2, 25000, 25000),
(24, 115, 1, 119000, 119000),
(24, 116, 1, 130000, 130000),
(24, 119, 1, 239000, 239000),
(24, 126, 6, 19000, 114000),
(24, 127, 3, 29000, 87000),
(24, 131, 7, 10000, 70000),
(24, 132, 4, 25000, 100000),
(25, 118, 1, 129000, 129000),
(25, 121, 1, 229000, 229000),
(25, 130, 4, 19000, 76000),
(25, 131, 5, 10000, 50000),
(25, 132, 3, 25000, 75000),
(26, 111, 3, 169000, 507000),
(26, 120, 3, 239000, 717000),
(26, 122, 2, 249000, 498000),
(26, 127, 4, 29000, 116000),
(27, 113, 1, 119000, 119000),
(27, 119, 1, 239000, 239000),
(27, 123, 1, 269000, 269000),
(27, 126, 1, 19000, 19000),
(27, 131, 1, 10000, 10000),
(28, 113, 10, 119000, 1190000),
(28, 116, 4, 130000, 520000),
(28, 119, 3, 239000, 717000),
(28, 132, 5, 25000, 125000),
(29, 114, 4, 159000, 636000),
(29, 115, 1, 119000, 119000),
(29, 116, 1, 130000, 130000),
(29, 131, 2, 10000, 20000),
(30, 116, 1, 130000, 130000),
(30, 117, 7, 149000, 1043000),
(30, 123, 10, 269000, 2690000),
(30, 125, 1, 29000, 29000),
(30, 127, 2, 29000, 29000),
(31, 111, 1, 169000, 169000),
(31, 115, 6, 119000, 595000),
(31, 117, 1, 149000, 149000),
(31, 118, 1, 129000, 129000),
(31, 130, 4, 19000, 76000),
(32, 120, 5, 239000, 1195000),
(32, 121, 4, 229000, 916000),
(33, 116, 1, 130000, 130000),
(33, 119, 30, 239000, 7170000),
(35, 113, 1, 119000, 119000),
(35, 117, 1, 149000, 149000),
(35, 131, 8, 10000, 70000),
(37, 116, 1, 130000, 130000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `MaPN` int(11) NOT NULL,
  `MaSP` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ctphieunhap`
--

INSERT INTO `ctphieunhap` (`MaPN`, `MaSP`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES
(4, 128, 100, 10000, 1000000),
(4, 129, 3, 9000, 27000),
(5, 124, 6, 10000, 60000),
(5, 125, 3, 15000, 45000),
(5, 126, 7, 10000, 70000),
(5, 127, 2, 15000, 30000),
(5, 130, 3, 9000, 27000),
(5, 131, 9, 4000, 36000),
(7, 126, 9, 10000, 90000),
(8, 124, 30, 10000, 300000),
(8, 126, 50, 10000, 500000),
(8, 129, 30, 9000, 270000),
(9, 135, 100, 10000, 1000000),
(10, 136, 200, 23000, 4600000),
(10, 137, 80, 84500, 6760000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giamgia`
--

CREATE TABLE `giamgia` (
  `MaGiam` int(11) NOT NULL,
  `TenGiamGia` text NOT NULL,
  `PhanTramGiam` int(11) NOT NULL,
  `DieuKien` int(11) NOT NULL,
  `NgayBD` date NOT NULL,
  `NgayKT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `giamgia`
--

INSERT INTO `giamgia` (`MaGiam`, `TenGiamGia`, `PhanTramGiam`, `DieuKien`, `NgayBD`, `NgayKT`) VALUES
(1, 'Không giảm giá', 0, 0, '2020-01-01', '2042-12-31'),
(2, 'Giảm 20% đơn hàng từ 150.000đ', 20, 150000, '2021-04-22', '2021-05-13'),
(4, 'Giảm 10% đơn hàng từ 80.000đ', 10, 80000, '2021-03-26', '2021-05-31'),
(6, '30/04-01/05 giảm 30% đơn hàng từ 300.000đ', 30, 300000, '2021-04-20', '2021-05-08');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` int(11) NOT NULL,
  `MaKH` int(11) NOT NULL,
  `MaNV` int(11) NOT NULL,
  `NgayLap` date NOT NULL,
  `TongTien` int(11) NOT NULL,
  `GhiChu` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaKH`, `MaNV`, `NgayLap`, `TongTien`, `GhiChu`) VALUES
(18, 4, 3, '2021-01-18', 1013600, 'Đã thanh toán'),
(19, 1, 1, '2021-01-20', 482400, 'Đã thanh toán'),
(20, 2, 1, '2021-01-28', 840000, 'Đã thanh toán'),
(21, 3, 2, '2021-02-07', 1045600, 'Đã thanh toán'),
(22, 1, 1, '2021-02-14', 1004000, 'Đã thanh toán'),
(23, 7, 3, '2021-02-16', 576800, 'Đã thanh toán'),
(24, 7, 2, '2021-03-08', 601300, 'Đã thanh toán'),
(25, 2, 2, '2021-03-09', 391300, 'Đã thanh toán'),
(26, 8, 4, '2021-03-12', 1286600, 'Đã thanh toán'),
(27, 8, 3, '2021-03-24', 590400, 'Đã thanh toán'),
(28, 7, 4, '2021-02-04', 2041600, 'Đã thanh toán'),
(29, 9, 2, '2021-04-10', 633500, 'Đã thanh toán'),
(30, 10, 4, '2021-04-15', 3136800, 'Đã thanh toán'),
(31, 11, 4, '2021-05-02', 782600, 'Đã thanh toán'),
(32, 11, 0, '2021-05-03', 1477700, 'Đã thanh toán'),
(33, 9, 0, '2021-05-06', 5110000, 'Đã thanh toán'),
(35, 3, 0, '2021-05-08', 304200, 'Đã thanh toán'),
(37, 2, 0, '2021-05-08', 117000, 'Đã thanh toán');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` int(11) NOT NULL,
  `Ho` varchar(255) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `GioiTinh` varchar(3) NOT NULL,
  `TongChiTieu` int(11) NOT NULL DEFAULT 0,
  `TinhTrang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `Ho`, `Ten`, `GioiTinh`, `TongChiTieu`, `TinhTrang`) VALUES
(1, 'Nguyễn Văn', 'An', 'Nam', 1486400, 1),
(2, 'Trần Ngọc', 'Bình', 'Nữ', 1497300, 1),
(3, 'Lê Thị', 'Giải', 'Nữ', 1468800, 1),
(4, 'Hà Thanh', 'Thoát', 'Nam', 1013600, 1),
(7, 'Trịnh Thị', 'Yên', 'Nữ', 3219700, 1),
(8, 'Trương Đình', 'Vui', 'Nam', 1877000, 1),
(9, 'Lại Thị Ngọc', 'Miền', 'Nữ', 5743500, 1),
(10, 'Trần Quang', 'Cực', 'Nam', 3136800, 1),
(11, 'Nguyễn Ngọc', 'Lạc', 'Nam', 2260300, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai`
--

CREATE TABLE `loai` (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `loai`
--

INSERT INTO `loai` (`MaLoai`, `TenLoai`) VALUES
(1, 'Pizza'),
(2, 'Nước uống'),
(3, 'Nguyên liệu');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` int(11) NOT NULL,
  `TenNCC` varchar(255) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  `DienThoai` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`, `DienThoai`) VALUES
(1, 'Bột mì Khánh Toàn', '273 An Dương Vương, phường 3, quận 5, TP.HCM', '0396527908'),
(2, 'Công ty giải khát Tường Vy', '12/49/2 Võ Văn Kiệt, P. Cô Giang, Q1', '0902669733'),
(5, 'Nguyên liệu bánh Việt Hoàng', '492 Xô Viết Nghệ Tĩnh, P.25, Q. Bình Thạnh', '0397682193');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` int(11) NOT NULL,
  `Ho` varchar(255) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `GioiTinh` varchar(3) NOT NULL,
  `ChucVu` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `Ho`, `Ten`, `GioiTinh`, `ChucVu`) VALUES
(0, 'Admin', '', '', 'Admin'),
(1, 'Sau Đại', 'Phát', 'Nam', 'Quản Lý'),
(2, 'Trần Quang', 'Vinh', 'Nam', 'Quản Lý'),
(3, 'Trần Hữu', 'Khương', 'Nam', 'Quản Lý'),
(4, 'Nhữ Quốc Anh', 'Tài', 'Nam', 'Nhân Viên'),
(12, 'Trịnh Thu', 'Huyền', 'Nữ', 'Nhân Viên'),
(13, 'Nguyễn Ngọc Mai', 'Linh', 'Nữ', 'Nhân Viên'),
(14, 'Hà Văn', 'Hùng', 'Nam', 'Nhân Viên'),
(15, 'Lê Thị Thuý', 'Diễm', 'Nữ', 'Quản Lý');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanquyen`
--

CREATE TABLE `phanquyen` (
  `Quyen` varchar(255) NOT NULL,
  `NhapHang` int(1) NOT NULL,
  `QLSanPham` int(1) NOT NULL,
  `QLNhanVien` int(1) NOT NULL,
  `QLKhachHang` int(1) NOT NULL,
  `ThongKe` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phanquyen`
--

INSERT INTO `phanquyen` (`Quyen`, `NhapHang`, `QLSanPham`, `QLNhanVien`, `QLKhachHang`, `ThongKe`) VALUES
('Default', 0, 0, 0, 0, 0),
('Nhân viên', 0, 0, 0, 1, 0),
('Quản lý', 1, 0, 1, 1, 1),
('Quản trị', 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPN` int(11) NOT NULL,
  `MaNCC` int(11) NOT NULL,
  `MaNV` int(11) NOT NULL,
  `NgayLap` date NOT NULL,
  `TongTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`MaPN`, `MaNCC`, `MaNV`, `NgayLap`, `TongTien`) VALUES
(4, 2, 0, '2021-04-19', 1027000),
(5, 2, 0, '2021-04-23', 268000),
(7, 2, 0, '2021-04-26', 90000),
(8, 2, 0, '2021-05-02', 1070000),
(9, 1, 0, '2021-05-04', 1000000),
(10, 5, 0, '2021-05-07', 11360000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSP` int(11) NOT NULL,
  `TenSP` varchar(255) NOT NULL,
  `MaLoai` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonViTinh` varchar(255) NOT NULL,
  `HinhAnh` varchar(255) NOT NULL,
  `DonGia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Bang San Pham';

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `TenSP`, `MaLoai`, `SoLuong`, `DonViTinh`, `HinhAnh`, `DonGia`) VALUES
(111, 'Pizza Hải Sản Pesto Xanh', 1, 31, 'Cái', 'pizza0.png', 169000),
(112, 'Pizza Hải Sản Nhiệt Đới', 1, 39, 'Cái', 'pizza1.png', 129000),
(113, 'Pizza Hải Sản Cocktail', 1, 34, 'Cái', 'pizza2.png', 119000),
(114, 'Pizza Tôm Cocktail', 1, 36, 'Cái', 'pizza3.png', 159000),
(115, 'Pizza Aloha', 1, 38, 'Cái', 'pizza4.png', 119000),
(116, 'Pizza Thịt Xông Khói', 1, 39, 'Cái', 'pizza5.png', 130000),
(117, 'Pizza Thịt Nguội', 1, 34, 'Cái', 'pizza6.png', 149000),
(118, 'Pizza Gà Nướng 3 Vị', 1, 35, 'Cái', 'pizza7.png', 129000),
(119, 'Pizza hải sản Pesto gấp đôi nhân', 1, 13, 'Cái', 'pizza8.jpg', 239000),
(120, 'Pizza gấp đôi nhân phủ cơn lốc hải sản', 1, 37, 'Cái', 'pizza9.jpg', 239000),
(121, 'Pizza gấp đôi nhân phủ hải sản xốt tiêu đen', 1, 41, 'Cái', 'pizza10.jpg', 229000),
(122, 'Pizza bò nướng tiêu đen', 1, 43, 'Cái', 'pizza11.jpg', 249000),
(123, 'Pizza cá ngừ thanh cua', 1, 33, 'Cái', 'pizza12.jpg', 269000),
(124, 'Pepsi lon 330ml', 2, 150, 'Lon', 'douong0.jpeg', 19000),
(125, 'Pepsi chai 1.5l', 2, 250, 'Chai', 'douong1.jpeg', 29000),
(126, '7Up lon 330ml', 2, 150, 'Lon', 'douong2.jpeg', 19000),
(127, '7Up chai 1.5l', 2, 110, 'Chai', 'douong3.jpeg', 29000),
(128, 'Pepsi no calories 330ml', 2, 180, 'Lon', 'douong4.jpg', 19000),
(129, 'Mirinda cam 330ml', 2, 100, 'Lon', 'douong5.jpg', 19000),
(130, 'Mirinda kem soda 330ml', 2, 80, 'Lon', 'douong6.jpg', 19000),
(131, 'Nước suối Aquafina', 2, 52, 'Chai', 'douong7.jpg', 10000),
(132, 'Trà sữa trà đen', 2, 6, 'Ly', 'douong8.jpg', 25000),
(135, 'Bột mì Meizan 500g', 3, 100, 'Gói', 'default.png', 10000),
(136, 'Men nở Mauripan 50g*5', 3, 200, 'Hộp', 'default.png', 23000),
(137, 'Dầu olive Olivoilà 250ml', 3, 80, 'Chai', 'default.png', 84500);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MaNV` int(11) NOT NULL,
  `TenDangNhap` varchar(255) NOT NULL,
  `MatKhau` varchar(255) NOT NULL,
  `Quyen` varchar(255) NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`MaNV`, `TenDangNhap`, `MatKhau`, `Quyen`, `TrangThai`) VALUES
(0, 'admin', 'admin', 'Quản trị', 1),
(1, 'ql01', 'ql01', 'Quản lý', 1),
(2, 'ql02', 'ql02', 'Quản lý', 1),
(3, 'ql03', 'ql03', 'Quản lý', 1),
(4, 'nv01', 'nv01', 'Nhân viên', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD PRIMARY KEY (`MaHD`,`MaSP`),
  ADD KEY `cthoadon_ibfk_1` (`MaHD`);

--
-- Chỉ mục cho bảng `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD PRIMARY KEY (`MaPN`,`MaSP`);

--
-- Chỉ mục cho bảng `giamgia`
--
ALTER TABLE `giamgia`
  ADD PRIMARY KEY (`MaGiam`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `hoadon_ibfk_1` (`MaNV`),
  ADD KEY `hoadon_ibfk_2` (`MaKH`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Chỉ mục cho bảng `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Chỉ mục cho bảng `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`Quyen`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPN`),
  ADD KEY `phieunhap_ibfk_1` (`MaNCC`),
  ADD KEY `phieunhap_ibfk_2` (`MaNV`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `sanpham_ibfk_1` (`MaLoai`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`MaNV`),
  ADD KEY `taikhoan_ibfk_2` (`Quyen`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `giamgia`
--
ALTER TABLE `giamgia`
  MODIFY `MaGiam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MaHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MaKH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `loai`
--
ALTER TABLE `loai`
  MODIFY `MaLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `MaNCC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MaNV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `MaPN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MaSP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=145;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `MaNV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD CONSTRAINT `cthoadon_ibfk_1` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD CONSTRAINT `ctphieunhap_ibfk_2` FOREIGN KEY (`MaPN`) REFERENCES `phieunhap` (`MaPN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `loai` (`MaLoai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `taikhoan_ibfk_2` FOREIGN KEY (`Quyen`) REFERENCES `phanquyen` (`Quyen`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
