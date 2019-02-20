package callcenter;

/*
 * Copyright (c) 2019. Schenker AG
 * All rights reserved.
 */

public class Employee {
    
    /**
     *  0-fresher 1-tl 2-pm
     */
    
    private Controller callController;
    public int rank;
    public boolean free;

    public Employee(int rank) {
        this.rank = rank;
    }

    public void ReceiveCall(Call call) {
        free = false;
    }

    public void CallHandled(Call call) {
        call.disconnect();
        free = true;
        callController.getNextCall(this);
    }

    public void CannotHandle(Call call) {
        call.rank = rank + 1;
        callController.dispatchCall(call);
        free = true;
        callController.getNextCall(this);
    }
}
