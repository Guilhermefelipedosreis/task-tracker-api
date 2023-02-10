package task.tracker.api.task;

public record TaskListDataTransfer(Long id, String title, String description, Status status) {
    public TaskListDataTransfer(Task task) {
        this(task.getId(), task.getTitle(), task.getDescription(), task.getStatus());
    }
    
}
