-- Thêm dữ liệu mẫu cho bảng Book
INSERT INTO dbo.book (id, branch_id, category_id, title, Author, published_year, price, current_copies, actual_copies, book_status)
VALUES
(N'HN1B001', N'HN1', 1, N'Sách khoa học A', N'Tác giả A', 2021, 16000, 10, 10, 1),
(N'HN1B002', N'HN1', 1, N'Sách khoa học B', N'Tác giả E', 2022, 18500, 8, 8, 1),
(N'HN2B003', N'HN2', 2, N'Sách văn học F', N'Tác giả G', 2019, 12500, 6, 6, 1),
(N'SG1B001', N'SG1', 2, N'Sách văn học D', N'Tác giả B', 2020, 20500, 20, 20, 1),
(N'SG1B002', N'SG1', 3, N'Sách lịch sử E', N'Tác giả E', 2019, 19000, 8, 8, 1),
(N'SG1B003', N'SG1', 2, N'Sách văn học G', N'Tác giả G', 2018, 13000, 6, 6, 1),
(N'BG1B001', N'BG1', 3, N'Sách lịch sử A', N'Tác giả C', 2019, 12500, 5, 5, 1),
(N'BG1B002', N'BG1', 2, N'Sách văn học I', N'Tác giả D', 2020, 18500, 8, 8, 1),
(N'BG1B003', N'BG1', 1, N'Sách khoa học F', N'Tác giả H', 2020, 22000, 9, 9, 1),
(N'BG1B004', N'BG1', 3, N'Sách lịch sử F', N'Tác giả I', 2017, 17000, 7, 7, 1);

-- Thêm dữ liệu mẫu cho bảng Account (Tài khoản)
INSERT INTO account (id, branch_id, account_role_id, account_name, gender, date_of_birth, registered_date, email, phone, account_address, account_username, account_password, account_status) VALUES
(N'HN1A001', N'HN1', 1, N'Người dùng Hà Nội 1', N'Nam', '1990-01-15', '2022-01-01', N'userHN1@example.com', N'123456789', N'Địa chỉ Hà Nội 1', N'1', N'123', 1),
(N'HN1A002', N'HN1', 2, N'Người dùng Hà Nội 2', N'Nữ', '1990-01-15', '2022-01-01', N'userHN1@example.com', N'123456789', N'Địa chỉ Hà Nội 1', N'2', N'123', 1),
(N'HN2A001', N'HN2', 3, N'Người dùng Hà Nội 3', N'Nam', '1990-01-15', '2022-01-01', N'userHN1@example.com', N'123456789', N'Địa chỉ Hà Nội 1', N'3', N'123', 1),
(N'BG1A001', N'BG1', 2, N'Người dùng BG 1', N'Nam', '1990-01-15', '2022-01-01', N'userHN1@example.com', N'123456789', N'Địa chỉ BG 1', N'userBG1', N'passwordHN1', 1),
(N'SG1A001', N'SG1', 2, N'Người dùng Sài Gòn 1', N'Nữ', '1988-06-20', '2022-01-01', N'userSG1@example.com', N'987654321', N'Địa chỉ Sài Gòn 1', N'userSG1', N'passwordSG1', 1);



