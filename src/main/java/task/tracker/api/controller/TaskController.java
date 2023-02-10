package task.tracker.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import task.tracker.api.task.Task;
import task.tracker.api.task.TaskRepository;
import task.tracker.api.task.TaskSaveDataTransfer;
import task.tracker.api.task.TaskUpdateDataTransfer;
import task.tracker.api.task.TaskListDataTransfer;


@RestController
@RequestMapping("/tasks")
@CrossOrigin("http://localhost:4200/")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @PostMapping
    public void saveTask(@RequestBody TaskSaveDataTransfer data) {
        repository.save(new Task(data));
    }

    @GetMapping
    public List<TaskListDataTransfer> listTask() {
        return repository.findAll().stream().map(TaskListDataTransfer::new).toList();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody TaskUpdateDataTransfer data) {
        var task = repository.getReferenceById(data.id());
        task.update(data);
    }

    @GetMapping("/{id}")
    public Optional<Task> findTask(@PathVariable Long id) {
        return repository.findById(id);
    }



}