USE [QLTV_N6]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[SP_GetAmountMoneyByMonth] 
	@Month int
AS
BEGIN
	select @Month * per_month from dbo.extension_price order by date_start desc
		RETURN 0  -- THANH CONG
END
GO
