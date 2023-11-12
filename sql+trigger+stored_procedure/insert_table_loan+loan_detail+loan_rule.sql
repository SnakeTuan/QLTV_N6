
-- Bảng Loan Rule (Quy định mượn)
INSERT INTO dbo.loan_rule (id, branch_id, overdue_fine, damage_fine, max_day, max_book, date_start) VALUES 
('HNLR001', 'CNHN', 1.50, 2.00, 10, 5, '2023-02-01'),
('SGLR001', 'CNSG', 2.00, 2.50, 10, 5, '2023-03-01'),
('HPLR001', 'CNHP', 1.50, 2.50, 10, 5, '2023-04-01');

-- Bảng Loan (Phiếu mượn)
INSERT INTO dbo.loan (id, branch_id, account_id, loan_rule_id, date_start) VALUES 
('HNL001', 'CNHN', 'HNA002', 'HNLR001', '2023-05-10'),
('SGL001', 'CNSG', 'SGA001', 'SGLR001', '2023-06-15'),
('HPL001', 'CNHP', 'HPA004', 'HPLR001', '2023-06-15');

-- Bảng Loan Detail (Chi tiết phiếu mượn)
INSERT INTO dbo.loan_detail (id, loan_id, book_id, date_end, detail_status) VALUES 
('HNLD001', 'HNL001', 'HNB001', '', 0),
('HNLD002', 'HNL001', 'HNB003', '2023-05-15', 1),
('SGLD001', 'SGL001', 'SGB002', '', 0),
('HPLD001', 'HPL001', 'HPB004', '', 0),
('HPLD002', 'HPL001', 'HPB003', '', 0);
