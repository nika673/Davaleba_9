package com.example.davaleba_9

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.TaskStackBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var button2: Button
    companion object {
        private const val CHANNEL_ID = "MY_CHANNEL"
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()
        var string = getString(R.string.notification_text)

        val mainintent= Intent(this,SecondActivity::class.java)
        mainintent.putExtra("NAME", string)
        mainintent.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val mainPendingIntent = PendingIntent.getActivity(this,1,mainintent,PendingIntent.FLAG_ONE_SHOT)








        val notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("gamocda")
            .setContentText(string)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.btu_logo))
            .setContentIntent(mainPendingIntent)
            .setStyle(NotificationCompat.BigPictureStyle()
                .bigPicture(BitmapFactory.decodeResource(resources, R.drawable.btu_logo))
                .bigLargeIcon(null))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .addAction(R.drawable.ic_launcher_foreground,"New",mainPendingIntent)




        button = findViewById(R.id.button)
        button.setOnClickListener {

            NotificationManagerCompat.from(this).notify(1, notificationBuilder.build())

        }

        button2 = findViewById(R.id.button2)
        button2.setOnClickListener {
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.cancel(1)
        }


    }


    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "NAME"
            val descriptionText = "Desc"
            val importance = NotificationManager.IMPORTANCE_DEFAULT


            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = descriptionText

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            NotificationManagerCompat.from(this).createNotificationChannel(channel)
        }

    }

}

//
//class MainActivity : AppCompatActivity() {
//    private lateinit var button: Button
//    private lateinit var button2: Button
//
//    companion object {
//        private const val CHANNEL_ID = "MY_CHANNEL"
//    }
//
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        button = findViewById(R.id.button)
//        button2 = findViewById(R.id.button2)
//        button2.setOnClickListener {
//            val notificationManager: NotificationManager =
//                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            notificationManager.cancel(1)
//        }
//        this.createNotificationChannel()
//        val resultIntent = Intent(this, MainActivity::class.java)
//        intent.putExtra("NAME", "qwertyuiop")
//        val snoozeIntent = Intent(this, MainActivity::class.java)
//        val resultPendingIntent: PendingIntent = TaskStackBuilder.create(this).run {
//            addNextIntentWithParentStack(
//                (resultIntent)
//                        getPendingIntent (0,
//                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
//            )
//        }
//
//        val snoozePendingIntent: PendingIntent = TaskStackBuilder.create(this).run {
//            addNextIntentWithParentStack(
//                (snoozeIntent)
//                        getPendingIntent (0,
//                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
//            )
//        }
//        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
//            .setSmallIcon(R.drawable.ic_launcher_foreground)
//            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.img))
//            .setContentTitle("Title")
//            .setContentText("Message")
//            .setContentIntent(resultPendingIntent)
//            .setStyle(
//                NotificationCompat.BigPictureStyle()
//                    .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.img))
//            )
//            .addAction(R.drawable.ic_launcher_background, "click me", snoozePendingIntent)
//            .setPriority(NotificationCompat.PRIORITY_HIGH)
//        var counter = 1
//        button.setOnClickListener {
//            val nbc = NotificationManagerCompat.from(this)
//            nbc.notify(counter, builder.build())
//            counter++
//        }
//    }
//
//    private fun createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val name = "NAME"
//            val descriptionText = "Desc"
//            val importance = NotificationManager.IMPORTANCE_DEFAULT
//            val channel = NotificationChannel(CHANNEL_ID, name, importance)
//            channel.description = descriptionText
//            val notificationManager: NotificationManager =
//                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            notificationManager.createNotificationChannel(channel)
//        }
//    }
//}