USE [QLTV_N6]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE SP_AddExtension
	@ExtensionID NVARCHAR(255),
	@BranchID NVARCHAR(255),
	@AccountID NVARCHAR(255),
	@ExtensionPriceId int,
	@AmountMoney int,
	@StartDate date,
	@EndDate date
AS
BEGIN
	if @AmountMoney is null select @AmountMoney = 0
	if @StartDate is null select @StartDate = GETDATE()
	if @ExtensionPriceId is null select @ExtensionPriceId = (select top(1) id from dbo.extension_price order by date_start desc)
	insert into extension (id, branch_id, account_id, extension_price_id, amount, date_start, date_extend)
		values (@ExtensionID, @BranchID, @AccountID, @ExtensionPriceId, @AmountMoney, @StartDate, @EndDate)
END
GO
