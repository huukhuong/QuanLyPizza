-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 07, 2021 lúc 05:58 PM
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
(111, 'Pizza Hải Sản Pesto Xanh', 1, 34, 'Cái', 'pizza0.png', 169000),
(112, 'Pizza Hải Sản Nhiệt Đới', 1, 39, 'Cái', 'pizza1.png', 129000),
(113, 'Pizza Hải Sản Cocktail', 1, 35, 'Cái', 'pizza2.png', 119000),
(114, 'Pizza Tôm Cocktail', 1, 36, 'Cái', 'pizza3.png', 159000),
(115, 'Pizza Aloha', 1, 39, 'Cái', 'pizza4.png', 119000),
(116, 'Pizza Thịt Xông Khói', 1, 40, 'Cái', 'pizza5.png', 130000),
(117, 'Pizza Thịt Nguội', 1, 36, 'Cái', 'pizza6.png', 149000),
(118, 'Pizza Gà Nướng 3 Vị', 1, 36, 'Cái', 'pizza7.png', 129000),
(119, 'Pizza hải sản Pesto gấp đôi nhân', 1, 14, 'Cái', 'pizza8.jpg', 239000),
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
(131, 'Nước suối Aquafina', 2, 60, 'Chai', 'douong7.jpg', 10000),
(132, 'Trà sữa trà đen', 2, 6, 'Ly', 'douong8.jpg', 25000),
(135, 'Bột mì Meizan 500g', 3, 100, 'Gói', 'default.png', 10000),
(136, 'Men nở Mauripan 50g*5', 3, 200, 'Hộp', 'default.png', 23000),
(137, 'Dầu olive Olivoilà 250ml', 3, 80, 'Chai', 'default.png', 84500);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `sanpham_ibfk_1` (`MaLoai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MaSP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=141;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `loai` (`MaLoai`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
