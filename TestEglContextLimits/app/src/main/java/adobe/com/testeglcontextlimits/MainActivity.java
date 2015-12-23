package adobe.com.testeglcontextlimits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import javax.microedition.khronos.egl.EGLContext;

public class MainActivity extends AppCompatActivity
{
    CustomGLSurfaceView mGLSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGLSurfaceView = (CustomGLSurfaceView) findViewById(R.id.GLSurfaceView1);
        mGLSurfaceView.setRenderer(new RendererWrapper(mGLSurfaceView));
    }

    int count = 0;

    public void onBackPressed() {


        if (count == 1) {
            super.onBackPressed();
            return;
        }

        count++;

        new Thread(new Runnable() {
            @Override
            public void run() {

                EGLContext c = mGLSurfaceView.createSharedEglContext(false);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                EGLContext c = mGLSurfaceView.createSharedEglContext(false);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                EGLContext c = mGLSurfaceView.createSharedEglContext(false);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                EGLContext c = mGLSurfaceView.createSharedEglContext(false);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                EGLContext c = mGLSurfaceView.createSharedEglContext(false);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                EGLContext c = mGLSurfaceView.createSharedEglContext(false);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                EGLContext c = mGLSurfaceView.createSharedEglContext(false);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                EGLContext c = mGLSurfaceView.createSharedEglContext(false);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                EGLContext c = mGLSurfaceView.createSharedEglContext(false);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                EGLContext c = mGLSurfaceView.createSharedEglContext(false);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                EGLContext c = mGLSurfaceView.createSharedEglContext(false);

            }
        }).start();
    }
}
