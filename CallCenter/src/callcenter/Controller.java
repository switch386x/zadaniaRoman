package callcenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Copyright (c) 2019. Schenker AG
 * All rights reserved.
 */

public class Controller {

    private static final int LEVELS = 3;
    private static final int NUM_FRESHERS = 5;

    ArrayList<Employee>[] employeeLevels = new ArrayList[LEVELS];

    Queue<Call>[] callQueues = new LinkedList[LEVELS];

    public Controller() {
        ArrayList<Employee> freshers = new ArrayList(NUM_FRESHERS);
        for (int k = 0; k < NUM_FRESHERS - 1; k++) {
            freshers.add(new Fresher());
        }
        employeeLevels[0] = freshers;

        ArrayList<Employee> tls = new ArrayList(1);
        tls.add(new TL());
        employeeLevels[1] = tls;

        ArrayList<Employee> pms = new ArrayList(1);
        pms.add(new PM());
        employeeLevels[1] = pms;
    }

    Employee getCallHandler(Call call) {
        for (int level = call.rank; level < LEVELS - 1; level++) {
            ArrayList<Employee> employeeLevel = employeeLevels[level];
            for (Employee emp : employeeLevel) {
                if (emp.free) {
                    return emp;
                }
            }
        }
        return null;
    }

    public void dispatchCall(Call call) {
        Employee emp = getCallHandler(call);
        if (emp != null) {
            emp.ReceiveCall(call);
        }
        else {
            call.reply("Please wait for free employee to reply");
            callQueues[call.rank].add(call);
        }
    }

    public void getNextCall(Employee emp) {

        for (int rank = emp.rank; rank >= 0; rank--) {
            Queue<Call> que = callQueues[rank];
            Call call = que.poll(); // remove the first call, if any
            if (call != null) {
                emp.ReceiveCall(call);
                return;
            }
        }
    }
}
