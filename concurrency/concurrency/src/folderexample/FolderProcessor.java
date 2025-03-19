package folderexample;

/* Example of the Fork/Join Framework which is based upon the work of Doug Lea */

/* This example searches for any files with a matching extension within
 * the current folder or its sub-folders.
 *
 * The code makes use of ForkJoinPool instead of ExecutorService as FJP
 * uses a work-stealing algorithm to balance the workload.
 */

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

@Data
@EqualsAndHashCode(callSuper=false)
class FolderProcessor extends RecursiveTask<List<String>> {
    // cannot use record structure as it already extends Record
    private final String path;
    private final String extension;

    @Override
    protected List<String> compute() {
        System.err.format("Task: %s%n", Thread.currentThread().getName());

        List<String> list = new ArrayList<>(); // files stored in folder
        List<FolderProcessor> tasks = new ArrayList<>(); // list of tasks to perform

        var file = new File(path); // The contents of the current folder
        File[] content = file.listFiles(); // files in the folder
        if (content != null) { // some files/folders to process
            //System.err.format("Looking at %s%n", content[i]);
            Arrays.stream(content).forEach(item -> {
                if (item.isDirectory()) {
                    //System.err.format("Examining directory %s%n", item);
                    // create a task to examine the folder/directory
                    var task = new FolderProcessor(item.getAbsolutePath(), extension);
                    task.fork(); // run the task
                    tasks.add(task); // add to the list of tasks
                } else { // an ordinary file
                    if (check(item.getName())) {
                        list.add(item.getAbsolutePath());
                    }
                }
            });
        }
        return addToResults(list, tasks);
    }

    boolean check(@NonNull String fileName) {
        //System.err.format("Examining %s%n", fileName);
        return fileName.endsWith(extension);
    }

    List<String> addToResults(@NonNull List<String> list, @NonNull List<FolderProcessor> tasks) {
        List<String> result = new ArrayList(list);
        tasks.stream().map(ForkJoinTask::join).forEach(result::addAll);
        return result;
    }
}