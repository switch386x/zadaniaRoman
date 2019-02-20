package callcenter;

/*
 * Copyright (c) 2019. Schenker AG
 * All rights reserved.
 */

public class Call {
    int rank = 0; // minimal rank of employee who can handle this call

    public void reply(String message) {
        // play recorded message to the customer
    }

    public void disconnect() {
        reply("Thank you for calling");
    }
}


