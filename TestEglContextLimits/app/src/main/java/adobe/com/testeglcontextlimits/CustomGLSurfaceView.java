package adobe.com.testeglcontextlimits;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class CustomGLSurfaceView extends GLSurfaceView
{
    private RendererWrapper mRenderer = null;
    private EGL10 mEgl;
    
    public CustomGLSurfaceView(final Context context)
    {
        super(context);
        init();
    }
    
    public CustomGLSurfaceView(final Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
        init();
    }
    
    private void init()
    {
        this.setEGLContextFactory(new MyDefaultContextFactory());
        this.setDebugFlags(GLSurfaceView.DEBUG_CHECK_GL_ERROR
                           | GLSurfaceView.DEBUG_LOG_GL_CALLS);
        this.setPreserveEGLContextOnPause(true);
        this.setEGLContextClientVersion(2);
        this.setEGLConfigChooser(GL_RED_SIZE, GL_GREEN_SIZE, GL_BLUE_SIZE,
                                 GL_ALPHA_SIZE, GL_DEPTH_SIZE, 0);
    }
    
    @Override
    public final void onResume() {
        super.onResume();
        setRenderMode(RENDERMODE_CONTINUOUSLY);
    }
    
    @Override
    public final void onPause() {
        super.onPause();
        setRenderMode(RENDERMODE_CONTINUOUSLY);
    }
    
    public final void setRenderer(final RendererWrapper renderer)
    {
        super.setRenderer((Renderer) renderer);
        mRenderer = renderer;
    }
    
    public EGLContext createSharedEglContext(boolean isSystemContext)
    {
        EGLContext context;
        
        if (isSystemContext)
        {
            context = mEgl.eglCreateContext(mEglDisplay, mEglConfig, EGL10.EGL_NO_CONTEXT, attributeList);
        }
        else
        {
            context = mEgl.eglCreateContext(mEglDisplay, mEglConfig, mEglContext, attributeList);
        }
        
        Log.d("TestEGLContextLimit", "createContext2 Status " + Thread.currentThread().getId() + " = " + mEgl.eglGetError());
        return context;
    }
    
    class MyDefaultContextFactory implements EGLContextFactory
    {
        @Override
        public EGLContext createContext(final EGL10 egl, final EGLDisplay display, final EGLConfig config)
        {
            mEgl = egl;
            mEglDisplay = display;
            mEglConfig = config;
            mEglContext = createSharedEglContext(true);
            
            Log.d("TestEGLContextLimit", "createContextStatus1 Status " + Thread.currentThread().getId() + " = " + mEgl.eglGetError());
            
            return mEglContext;
        }
        
        @Override
        public void destroyContext(final EGL10 egl, final EGLDisplay display, final EGLContext context)
        {
            egl.eglDestroyContext(display, context);
        }
    }
    
    private static final int EGL_CONTEXT_CLIENT_VERSION = 0x3098;
    int[] attributeList = { EGL_CONTEXT_CLIENT_VERSION, 2, EGL10.EGL_NONE };
    private static final int GL_RED_SIZE = 8;
    private static final int GL_GREEN_SIZE = 8;
    private static final int GL_BLUE_SIZE = 8;
    private static final int GL_ALPHA_SIZE = 8;
    private static final int GL_DEPTH_SIZE = 24;
    
    private EGLContext mEglContext = null;
    private EGLDisplay mEglDisplay = null;
    private EGLConfig mEglConfig = null;
}