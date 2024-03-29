package adobe.com.testeglcontextlimits;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

// RenderWrapper, simply paints red color
public class RendererWrapper implements GLSurfaceView.Renderer
{
    private CustomGLSurfaceView mCustomGLSurfaceView;

    public RendererWrapper(CustomGLSurfaceView customGLSurfaceView)
    {
        super();
        mCustomGLSurfaceView = customGLSurfaceView;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height)
    {
        GLES20.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl)
    {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }
}