#include <jni.h>
#include <string>


extern "C"
JNIEXPORT void JNICALL
Java_com_blackmirror_MainActivity_run(JNIEnv *env, jobject thiz, jstring input) {
    char buf[64];
    const char *str = env->GetStringUTFChars(input,0);
    strcpy(buf, str);
}