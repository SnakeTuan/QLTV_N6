USE [QLTV_N6]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE SP_GetAllRevenueInMonth
	@Month int,
	@Year int
AS
BEGIN

	SELECT a.id, a.account_name, e.date_extend, ep.per_month, e.amount
	FROM account a INNER JOIN extension e ON a.id = e.account_id INNER JOIN extension_price ep ON e.extension_price_id = ep.id
	WHERE YEAR(e.date_extend) = @Year and MONTH(e.date_extend) = @Month

	return 0
END
GO
