package com.example;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: kiki
 * Date: 29/05/12
 * Time: 18:26
 * To change this template use File | Settings | File Templates.
 */

public class FirstAndroidApplicationController extends Application {

    private HashMap<Integer, Stack<Activity>> tasks;
    private ActivityManager manager;

    @Override
    public void onCreate() {
        super.onCreate();
        manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        tasks = new HashMap<Integer, Stack<Activity>>();
    }

    public void pushToStack(Activity baseActivity) {
        int currentTaskId = getCurrentTaskId();
        if (tasks != null) {
            if (!tasks.containsKey(currentTaskId)) {
                tasks.put(currentTaskId, new Stack<Activity>());
            }
            Stack<Activity> stack = tasks.get(currentTaskId);
            stack.add(baseActivity);
        }
    }

    private int getCurrentTaskId() {
        if (manager != null) {
            List<ActivityManager.RunningTaskInfo> runningTasks = manager.getRunningTasks(1);
            return (runningTasks != null && !runningTasks.isEmpty()) ? runningTasks.get(0).id : -1;
        }
        return -1;
    }

    public void removeFromStack(Activity baseActivity) {
        Stack<Activity> stack = tasks.get(getCurrentTaskId());
        if (stack != null) {
            stack.remove(baseActivity);
        }
    }

    public Stack<Activity> getCurrentStack() {
        return tasks.get(getCurrentTaskId());
    }
}
