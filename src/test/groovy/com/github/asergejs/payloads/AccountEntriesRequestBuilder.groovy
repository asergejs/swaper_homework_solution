package com.github.asergejs.payloads


class AccountEntriesRequestBuilder extends RequestBuilder {


    @Override
    Map populateDefaultValues(Map customValues) {
        return [
                page                   : 1,
                pageSize               : 9,
                sortOption             : null,
                interestRateFrom       : null,
                interestRateTo         : null,
                amountFrom             : null,
                amountTo               : null,
                filtered               : false,
                transactionTypes       : [],
                remainingTermMonthsFrom: null,
                bookingDateFrom        : customValues.bookingDateFrom ?: "2024-08-01",
                bookingDateTo          : customValues.bookingDateTo ?: "2024-08-07"
        ]
    }

}
