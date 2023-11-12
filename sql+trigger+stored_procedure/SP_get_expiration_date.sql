USE [QLTV_N6]
GO
/****** Object:  StoredProcedure [dbo].[SP_GetExpirationDate]    Script Date: 2023-11-10 8:01:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

ALTER PROCEDURE [dbo].[SP_GetExpirationDate] 
	@ACCOUNT_ID NVARCHAR(255),
	@EXTENSION_ID NVARCHAR(255),
	@BRANCH_ID NVARCHAR(255)
AS
	declare @FinalStartDate date
	declare @ExtensionPriceId int
	declare @AmountMoney int
	declare @MonthAdd int
	declare @ExpirationDate date
BEGIN
	SELECT TOP(1) @FinalStartDate = e.date_extend, @ExtensionPriceId = e.extension_price_id, @AmountMoney = e.amount
		FROM extension e where e.account_id = @ACCOUNT_ID ORDER BY e.date_start DESC

	IF @FinalStartDate is null
		BEGIN
			if exists (select * from dbo.account where id = @ACCOUNT_ID)
				begin
					insert into extension (branch_id, id, amount , date_start, account_id, extension_price_id, date_extend) 
						values (@BRANCH_ID, @EXTENSION_ID, 0, (select registered_date from account where account.id = @ACCOUNT_ID), @ACCOUNT_ID, (select top (1) id from extension_price order by date_start desc), GETDATE())
					select registered_date from account where id = @ACCOUNT_ID
				end
			else 
				begin
					raiserror(N'Không tìm thấy account trùng với id hoặc insert bảng extension fail', 16, 1)
					return 1
				end
			return 0
		END
	select @MonthAdd = @AmountMoney / (Select EP.per_month from extension_price EP where EP.id = @ExtensionPriceId)
	select @ExpirationDate = DATEADD(MONTH, @MonthAdd, @FinalStartDate)
	select @ExpirationDate
	RETURN 0  -- THANH CONG
END
