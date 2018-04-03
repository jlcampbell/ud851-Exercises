/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.background.sync;

import android.os.AsyncTask;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

import javax.xml.transform.Result;

public class WaterReminderFirebaseJobService extends JobService{

    @Override
    public boolean onStartJob(final JobParameters jobParameters) {
        class mBackgroundTask extends AsyncTask<Object, Result, Void>{

            @Override
            protected Void doInBackground(Object[] objects) {
                ReminderTasks.executeTask(WaterReminderFirebaseJobService.this,ReminderTasks.ACTION_CHARGING_NOTIFICATION);
                return null;
            }

            @Override
            protected Object onPostExecute(Result result){
                jobFinished(jobParameters, false);
                return null;
            }
        }
        mBackgroundTask task = new mBackgroundTask();
        task.execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
    // c (3) WaterReminderFirebaseJobService should extend from JobService

    // c (4) Override onStartJob
        // c (5) By default, jobs are executed on the main thread, so make an anonymous class extending
        //  AsyncTask called mBackgroundTask.
            // c (6) Override doInBackground
                // c (7) Use ReminderTasks to execute the new charging reminder task you made, use
                // this service as the context (WaterReminderFirebaseJobService.this) and return null
                // when finished.
            // c (8) Override onPostExecute and called jobFinished. Pass the job parameters
            // and false to jobFinished. This will inform the JobManager that your job is done
            // and that you do not want to reschedule the job.

        // c (9) Execute the AsyncTask
        // c (10) Return true

    // TODO (11) Override onStopJob
        // TODO (12) If mBackgroundTask is valid, cancel it
        // TODO (13) Return true to signify the job should be retried

}
