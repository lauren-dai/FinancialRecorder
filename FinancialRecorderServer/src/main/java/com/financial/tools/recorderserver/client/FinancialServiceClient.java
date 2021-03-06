package com.financial.tools.recorderserver.client;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.financial.tools.recorderserver.payload.CashinRequest;
import com.financial.tools.recorderserver.payload.FinancialRecordListResponse;
import com.financial.tools.recorderserver.payload.FinancialRecordRequest;
import com.financial.tools.recorderserver.payload.UserFinancialInfoResponse;

public class FinancialServiceClient extends AbstractFinancialClient {

	public FinancialServiceClient(String serverAddress) {
		super(serverAddress);
	}

	public String cashin(CashinRequest request) {
		client.path("finance/cashin").type(MediaType.APPLICATION_JSON).accept(MediaType.TEXT_PLAIN);
		return post(client, request, String.class);
	}

	public String createFinancialRecord(FinancialRecordRequest financialRecordRequest) {
		client.path("/finance/create").type(MediaType.APPLICATION_JSON).accept(MediaType.TEXT_PLAIN);
		return post(client, financialRecordRequest, String.class);
	}

	public List<FinancialRecordListResponse> listFinancialRecord() {
		client.path("finance/list").accept(MediaType.APPLICATION_JSON);
		return getList(client, FinancialRecordListResponse.class);
	}

	public String updateFinance(String financialRecordId) {
		client.path("finance/update/{financialRecordId}", financialRecordId).accept(MediaType.TEXT_PLAIN);
		return get(client, String.class);
	}

	public UserFinancialInfoResponse getUserFinancialInfo(String userId) {
		client.path("finance/info/{userId}", userId).accept(MediaType.APPLICATION_JSON);
		return get(client, UserFinancialInfoResponse.class);
	}
}
