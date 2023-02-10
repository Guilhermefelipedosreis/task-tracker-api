package task.tracker.api.task;

public record TaskUpdateDataTransfer(Long id, String title, String description, Status status) {

}
