package com.financial.tools.recorderserver.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.financial.tools.recorderserver.business.FinancialManager;
import com.financial.tools.recorderserver.entity.FinancialRecord;
import com.financial.tools.recorderserver.payload.CashinRequest;
import com.financial.tools.recorderserver.payload.UserFinancialInfoResponse;

@Path("/finance")
@Produces(MediaType.APPLICATION_JSON)
public class FinancialService {

	private FinancialManager financialManager;

	@POST
	@Path("/cashin")
	@Produces(MediaType.TEXT_PLAIN)
	public String cashin(CashinRequest request) {
		financialManager.updateUserBalance(request.getUserId(), request.getAmount());
		return "";
	}

	@POST
	@Path("/create")
	@Produces(MediaType.TEXT_PLAIN)
	public String createFinancialRecord(FinancialRecord financialRecord) {
		financialManager.createFinancialRecord(financialRecord);
		return "";
	}

	@GET
	@Path("/update/{financialRecord}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateFinance(@PathParam("financialRecord") String financialRecordId) {
		financialManager.updateFinance(Long.valueOf(financialRecordId));
		return "";
	}

	@GET
	@Path("/info/{userId}")
	public UserFinancialInfoResponse getUserFinancialInfo(@PathParam("userId") String userId) {
		return financialManager.getUserFinancialInfo(Long.valueOf(userId));
	}

	@Autowired
	public void setFinancialManager(FinancialManager financialManager) {
		this.financialManager = financialManager;
	}

}