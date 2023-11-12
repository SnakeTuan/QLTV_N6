-- Bảng Category (Danh mục sách)
CREATE TABLE category (
    id INT PRIMARY KEY,
    category_name NVARCHAR(255)
);

-- Bảng Role (Vai trò)
CREATE TABLE account_role (
    id INT PRIMARY KEY,
    account_name NVARCHAR(50)
);

-- Bảng Headquarter (Trụ sở chính)
CREATE TABLE headquarter (
    id NVARCHAR(255) PRIMARY KEY,
    headquarter_name NVARCHAR(255),
    headquarter_address NVARCHAR(255)
);

-- Bảng Branch (Chi nhánh)
CREATE TABLE branch (
    id NVARCHAR(255) PRIMARY KEY,
	headquarter_id NVARCHAR(255),
    branch_name NVARCHAR(255),
	branch_address NVARCHAR(255),
	FOREIGN KEY (headquarter_id) REFERENCES headquarter(id)
);

-- Bảng Book (Sách)
CREATE TABLE book (
    id NVARCHAR(255) PRIMARY KEY,
    branch_id NVARCHAR(255),
    category_id INT,
    title NVARCHAR(255),
    Author NVARCHAR(255),
    published_year INT,
    price INT,
    current_copies INT,
    actual_copies INT,
    book_status INT,
    FOREIGN KEY (branch_id) REFERENCES branch(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

-- Bảng Account (Tài khoản)
CREATE TABLE account (
    id NVARCHAR(255) PRIMARY KEY,
    branch_id NVARCHAR(255),
    account_role_id INT,
    account_name NVARCHAR(255),
	gender NVARCHAR(100),
	date_of_birth DATE,
	registered_date DATE,
    email NVARCHAR(255),
    phone NVARCHAR(20),
    account_address NVARCHAR(255),
    account_username NVARCHAR(50),
    account_password NVARCHAR(255),
	account_status INT,
    FOREIGN KEY (branch_id) REFERENCES branch(id),
    FOREIGN KEY (account_role_id) REFERENCES account_role(id)
);

-- Bảng Rule (Quy định)
CREATE TABLE loan_rule (
    id NVARCHAR(255) PRIMARY KEY,
    overdue_fine INT,
    damage_fine INT,
    max_day INT,
    max_book INT,
    date_start DATE
);

-- Bảng Loan (Phiếu mượn)
CREATE TABLE loan (
    id NVARCHAR(255) PRIMARY KEY,
    branch_id NVARCHAR(255),
    account_id NVARCHAR(255),
    loan_rule_id NVARCHAR(255),
    date_start DATE,
    FOREIGN KEY (branch_id) REFERENCES branch(id),
    FOREIGN KEY (account_id) REFERENCES account(id),
    FOREIGN KEY (loan_rule_id) REFERENCES loan_rule(id)
);

-- Bảng Loan_detail (Chi tiết phiếu mượn)
CREATE TABLE loan_detail (
    id NVARCHAR(255) PRIMARY KEY,
    loan_id NVARCHAR(255),
    book_id NVARCHAR(255),
    date_end DATE,
    detail_status INT,
    FOREIGN KEY (loan_id) REFERENCES loan(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
);

CREATE TABLE extension_price (
	id INT PRIMARY KEY,
	per_month INT,
	date_start DATE
);

CREATE TABLE extension (
	id NVARCHAR(255) PRIMARY KEY,
	branch_id NVARCHAR(255),
	account_id NVARCHAR(255),
	extension_price_id INT,
	amount INT,
	date_start DATE,
	date_extend DATE,
	FOREIGN KEY (branch_id) REFERENCES branch(id),
	FOREIGN KEY (account_id) REFERENCES account(id),
	FOREIGN KEY (extension_price_id) REFERENCES extension_price(id)
);


