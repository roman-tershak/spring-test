package com.tests.transactional;

import static org.springframework.transaction.event.TransactionPhase.*;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class TransactionalListener {

    @TransactionalEventListener(phase = BEFORE_COMMIT, fallbackExecution = false)
    public void onBeforeCommit(TransEvent event) {
        System.out.println("inside BEFORE_COMMIT " + event);
    }

    @TransactionalEventListener(phase = AFTER_COMMIT, fallbackExecution = false)
    public void onAfterCommit(TransEvent event) {
        System.out.println("inside AFTER_COMMIT " + event);
    }

    @TransactionalEventListener(phase = AFTER_ROLLBACK, fallbackExecution = false)
    public void onAfterRollback(TransEvent event) {
        System.out.println("inside AFTER_ROLLBACK " + event);
    }

    @TransactionalEventListener(phase = AFTER_COMPLETION, fallbackExecution = false)
    public void onAfterCompletion(TransEvent event) {
        System.out.println("inside AFTER_COMPLETION " + event);
    }
}
