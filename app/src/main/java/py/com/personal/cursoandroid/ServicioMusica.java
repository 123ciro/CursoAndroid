package py.com.personal.cursoandroid;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class ServicioMusica extends Service {


    MediaPlayer miReproductor;

    public void OnCreate(){
        super.onCreate();

        miReproductor = MediaPlayer.create(this,R.raw.aves_16);
        miReproductor.setLooping(true);

        miReproductor.setVolume(100,100);

    }

    public int onStartComman(Intent intent,int flags,int startId){
        miReproductor.start();

        return START_STICKY;
    }

    public void onDestroy(){
        super.onDestroy();

        if(miReproductor.isPlaying()) miReproductor.stop();
        miReproductor.release();
        miReproductor=null;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
