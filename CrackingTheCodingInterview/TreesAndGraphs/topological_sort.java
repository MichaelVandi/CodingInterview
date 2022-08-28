public class MyClass {
    public static void main(String args[]) {
      // Create a Task Graph
      String[][] dependencies = 
      new String[][] {{"a", "d"}, {"f", "b"}, {"b", "d"}, 
      {"f", "a"}, {"d", "c"}};
      
      // Then we can create the graph
      TaskGraph graph = new TaskGraph();
      for (String[] dep : dependencies) {
          graph.addDependencies(dep[1], dep[0]);
      }
      // Now we can get the order
      List<String> result = getTaskOrder(graph);
      System.out.println(Arrays.toString(result.toArray()));
      
    }

    public List<String> getTaskOrder(TaskGraph graph) {
        // Get the list of tasks
        List<Task> tasks = new ArrayList<Task>(graph.tasks);
        // Then the result to return
        List<String> result = new ArrayList<String>();
        for (Task task : tasks) {
            // Loop through each task and check that
            // there are no cycles and we've performed
            // All the dependencies
            boolean cycle = dfs(task, result);
            if (cycle) return new ArrayList<String>();
            
        }
        return result;
    }
    public boolean dfs(Task task, List<String> result) {
        if (task.visiting) return true;
        // Return true is a cycle exists
        if (task.visited) return false;
        // We have performed this task
        task.visiting = true;
        // Go through all it's depenencies
        for (Task dep : task.deps) {
            boolean cycle = dfs(dep, result);
            // if contains cycle return false w/o adding
            // anything to the order
            if (cycle) return false;
        }
        // No deps and no cycle
        result.add(task.taskName);
        task.visiting = false;
        task.visited = true;
        return false;
    }
   
}
public class Task {
    String taskName;
    List<Task> deps;
    boolean visited;
    boolean visiting;
    public Task(String taskName) {
        this.taskName = taskName;
        deps = new ArrayList<>();
        visited = false;
        visiting = false;
    }

}
public class TaskGraph {
    String taskName;
    List<Task> tasks;
    // First String is for graph name and the next
    // String list is for the dependencies
    Map<String, Task> map;
    public TaskGraph(List<String> taskList) {
        tasks = new ArrayList<Task>();
        map = new HashMap<String, Task>();
        for (String task : taskList) {
            addTask(task);
        }
    }
    public void addTask(String name) {
        Task task = new Task(name);
        // Add it to the list
        tasks.add(task);
        // Add it to the map.
        map.put(name, task);
    }
    public void addDependencies(String a, String b) {
        // First of all we get the task
        // b is dependent on a
        Task a_ = getTask(a);
        Task b_ = getTask(b);
        // Add this dependency to the list
        b_.dep.add(a_);
    }
    public Task getTask(String task) {
        if (map.containsKey(task)) {
            return map.get(task);
        } else {
            // Create a new task?
            addTask(task);
        }
    }
    
    
}