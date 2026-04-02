package Job_Scheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import android.widget.Toast
import android.os.Handler
import android.os.Looper

class MyJobService : JobService() {

    private var isWorking = false

    override fun onStartJob(params: JobParameters?): Boolean {
        Log.d("JobScheduler", "Job Started")
        isWorking = true

        // Run background task
        Thread {
            try {
                for (i in 1..5) {
                    if (!isWorking) break
                    Log.d("JobScheduler", "Working... Step $i")
                    Thread.sleep(1000)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            // Show toast on main thread
            Handler(Looper.getMainLooper()).post {
                Toast.makeText(applicationContext, "Job Completed!", Toast.LENGTH_SHORT).show()
            }

            Log.d("JobScheduler", "Job Finished")

            // Tell system job is done
            jobFinished(params, false)

        }.start()

        return true // Work is still running in background
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("JobScheduler", "Job Stopped")
        isWorking = false

        // Return true → reschedule job
        return true
    }
}