USE [QLTV_N6]
GO
/****** Object:  StoredProcedure [dbo].[SP_GetAllRevenueInMonth]    Script Date: 2023-11-16 7:10:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

ALTER PROCEDURE [dbo].[SP_GetAllRevenueInMonth]
	@Month int,
	@Year int
AS
BEGIN

	SELECT a.id, a.account_name, e.date_start, ep.per_month, e.amount
	FROM account a INNER JOIN extension e ON a.id = e.account_id INNER JOIN extension_price ep ON e.extension_price_id = ep.id
	WHERE YEAR(e.date_start) = @Year and MONTH(e.date_start) = @Month

	return 0
END
