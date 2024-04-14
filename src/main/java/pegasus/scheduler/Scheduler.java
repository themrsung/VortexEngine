package pegasus.scheduler;

/**
 * A scheduler.
 */
public interface Scheduler {
    /**
     * Starts this scheduler.
     */
    void start();

    /**
     * Interrupts this scheduler.
     */
    void interrupt();

    /**
     * Registers a task to this scheduler.
     * @param action The action to perform
     * @param interval The interval of which to repeat the action
     * @return The registry reference of the registered task
     */
    TaskRegister registerTask(Runnable action, long interval);

    /**
     * Unregisters the referenced task from this scheduler.
     * @param reference The task reference to unregister
     */
    void unregisterTask(TaskRegister reference);
}
