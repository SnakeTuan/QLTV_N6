-- Thêm dữ liệu mẫu cho bảng Headquarter (Trụ sở chính)
INSERT INTO headquarter (id, headquarter_name, headquarter_address) VALUES
(N'HQHN', N'Hà Nội Headquarter', N'Hà Nội, Việt Nam'),
(N'HQBG', N'Bắc Giang Headquarter', N'Bắc Giang, Việt Nam'),
(N'HQSG', N'Sài Gòn Headquarter', N'Sài Gòn, Việt Nam');

-- Thêm dữ liệu mẫu cho bảng Branch (Chi nhánh)
INSERT INTO branch (id, headquarter_id, branch_name, branch_address) VALUES
(N'HN001', N'HQHN', N'Hà Nội Branch 1', N'Hà Nội, Việt Nam'),
(N'HN002', N'HQHN', N'Hà Nội Branch 2', N'Hà Nội, Việt Nam'),
(N'BG001', N'HQBG', N'Bắc Giang Branch 1', N'Bắc Giang, Việt Nam'),
(N'SG001', N'HQSG', N'Sài Gòn Branch 1', N'Sài Gòn, Việt Nam');
