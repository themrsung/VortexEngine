package pegasus.scheduler;

public class TaskRegister {
    public final Runnable action;
    public final long delay;
    public final long interval;
    public final Scheduler host;

    TaskRegister(Runnable action, long delay, long interval, Scheduler host) {
        this.action = action;
        this.delay = delay;
        this.interval = interval;
        this.host = host;
    }

    /**
     * Attempts to unregister itself from the host scheduler.
     */
    public void unregister() {
        host.unregisterTask(this);
    }
}
