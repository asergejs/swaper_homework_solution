package com.github.asergejs.steps

import com.github.asergejs.api.ClientBalanceApi
import com.github.asergejs.payloads.AccountEntriesRequestBuilder
import io.cucumber.java.en.Given

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.CoreMatchers.is

class ClientBalanceSteps {

    private ClientBalanceApi clientBalanceApi
    private AccountEntriesRequestBuilder accountEntriesRequestBuilder

    ClientBalanceSteps(AccountEntriesRequestBuilder accountEntriesRequestBuilder, ClientBalanceApi clientBalanceApi) {
        this.clientBalanceApi = clientBalanceApi
        this.accountEntriesRequestBuilder = accountEntriesRequestBuilder
    }

    @Given("client balance is {float} from {string} to {string}")
    void checkBalance(float balance, String dateFrom, String dateTo) {
        String payload = accountEntriesRequestBuilder
                .withCustomParams([
                        bookingDateFrom : dateFrom,
                        bookingDateTo : dateTo])
                .build()
        def response = clientBalanceApi.fetchAccountEntries(payload)
        assertThat("Mismatch in client balance", response.openingBalance as float, is(balance))
    }


}
